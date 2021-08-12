package com.bkomendera.earthquakes.service;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EarthquakesServiceInterface {
    Map<String, Point2D> getEarthquakes() throws IOException;
    List<Map.Entry<String, Float>> getCloseEarthquakes(float lat1, float lon1) throws IOException;
}
