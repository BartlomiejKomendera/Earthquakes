package com.bkomendera.earthquakes.service;

import com.bkomendera.earthquakes.data.EarthquakesApiInterface;
import com.bkomendera.earthquakes.domain.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EarthquakesServiceImpl implements EarthquakesServiceInterface {

    @Autowired
    private EarthquakesApiInterface eai;

    @Override
    public List<Feature> getEarthquakes() throws IOException {
        return eai.getAllMonth();
    }

    @Override
    public List<String> getCloseEarthquakes(float lat1, float lon1) throws IOException {

        //HashMap with the Id and Distance from our coordinates of each earthquake
        HashMap<String, Float> distances = new HashMap<String, Float>();

        //Calculating the distance in kilometers with Haversine Formula
        eai.getAllMonth().forEach(e -> {
            float lat2 = e.getGeometry().getCoordinates().get(0);
            float lon2 = e.getGeometry().getCoordinates().get(1);
            float R = 6371;
            float dLat = deg2rad(lat2 - lat1);
            float dLon = deg2rad(lon2 - lon1);
            float a =
                    (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                            Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                    Math.sin(dLon / 2) * Math.sin(dLon / 2));
            float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
            float distance = R * c;

            //Updating the map
            distances.put(e.getId(), distance);
        });

        //Sorting the HashMap by Distance and selecting the closest 10 earthquakes as a list of entries<K,V>
        List<Map.Entry<String, Float>> list = distances.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).subList(0, 10);

        List<String> finalList = new ArrayList<String>();
        //Going through our 10 entries, searching for the earthquake by its Id and getting the title and distance printed
        list.forEach(e -> {
            try {
                eai.getAllMonth().forEach(f -> {
                    if (f.getId().equals(e.getKey())) {
                        finalList.add(f.getProperties().getTitle() + " || " + Math.round(e.getValue()) + " km");
                    }
                });
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        return finalList;
    }
    //Auxiliary method to convert degrees to radians for Haversine Formula
    public static float deg2rad(float deg) {
        return (float) (deg * (Math.PI / 180));
    }
}
