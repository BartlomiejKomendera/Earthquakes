package com.bkomendera.earthquakes.data.api;

import com.bkomendera.earthquakes.domain.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EarthquakesApi implements EarthquakesApiInterface{

    @Autowired
    private RESTclient restClient;

    @Override
    public List<Feature> getAllMonth() throws IOException {
        return restClient.getClient().getFeatures();
    }
}