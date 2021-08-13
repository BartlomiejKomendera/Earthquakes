package com.bkomendera.earthquakes.data.repository;

import com.bkomendera.earthquakes.domain.util.Coords;

import java.awt.geom.Point2D;
import java.util.Map;

public interface EarthquakesRepoInterface {
    void saveEarthquakesRepo(Map<String, Coords> map);
    Map<String, Coords> getEarthquakesRepo();
}
