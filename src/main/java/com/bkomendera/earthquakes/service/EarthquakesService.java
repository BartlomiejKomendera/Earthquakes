package com.bkomendera.earthquakes.service;

import com.bkomendera.earthquakes.data.api.EarthquakesApiInterface;
import com.bkomendera.earthquakes.data.repository.EarthquakesRepository;
import com.bkomendera.earthquakes.domain.util.Coords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EarthquakesService implements EarthquakesServiceInterface {

    @Autowired
    private EarthquakesApiInterface earthquakesApiInterface;
    @Autowired
    private EarthquakesRepository earthquakesRepository;

    @Override
    public Map<String, Coords> getEarthquakes() throws IOException {
        Map<String, Coords> map = new HashMap<>();
        earthquakesApiInterface.getAllMonth().forEach(feature -> map.put(feature.getProperties().getTitle(),
                new Coords(feature.getGeometry().getCoordinates().get(0).floatValue(), feature.getGeometry().getCoordinates().get(1).floatValue()))
        );
        earthquakesRepository.saveEarthquakesRepo(map);
        return earthquakesRepository.getEarthquakesRepo();
    }

    @Override
    public List<Map.Entry<String, java.lang.Float>> getCloseEarthquakes(float lat1, float lon1) throws IOException {

        HashMap<String, java.lang.Float> distances = new HashMap<>();

        earthquakesApiInterface.getAllMonth().forEach(e -> {
            float lon2 = e.getGeometry().getCoordinates().get(0);
            float lat2 = e.getGeometry().getCoordinates().get(1);
            float R = 6371;
            float dLat = deg2rad(lat2 - lat1);
            float dLon = deg2rad(lon2 - lon1);
            float a =
                    (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                            Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                    Math.sin(dLon / 2) * Math.sin(dLon / 2));
            float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
            float distance = R * c;

            distances.put(e.getProperties().getTitle(), distance);
        });

        /*List<Map.Entry<String, java.lang.Float>> list = */
        return distances.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).subList(0, 10);

        /*return list;*/
    }
    public static float deg2rad(float deg) {
        return (float) (deg * (Math.PI / 180));
    }
}
