package com.bkomendera.earthquakes.data.repository;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Map;

public interface EarthquakesRepoInterface {
    void saveEarthquakesRepo(Map<String, Point2D> map);
    Map<String, Point2D> getEarthquakesRepo();
}
