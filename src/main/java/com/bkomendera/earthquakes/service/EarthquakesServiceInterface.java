package com.bkomendera.earthquakes.service;

import com.bkomendera.earthquakes.domain.util.Coords;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EarthquakesServiceInterface {
    Map<String, Coords> getEarthquakes() throws IOException;
    List<Map.Entry<String, Float>> getCloseEarthquakes(float lat1, float lon1) throws IOException;
}
