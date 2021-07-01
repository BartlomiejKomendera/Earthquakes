package com.bkomendera.earthquakes.service;

import com.bkomendera.earthquakes.domain.Feature;

import java.io.IOException;
import java.util.List;

public interface EarthquakesServiceInterface {
    public List<String> getEarthquakes() throws IOException;
    public List<String> getCloseEarthquakes(float lat1, float lon1) throws IOException;
}
