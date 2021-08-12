package com.bkomendera.earthquakes.data.repository;

import org.springframework.stereotype.Component;

import java.awt.geom.Point2D;
import java.util.Map;

@Component
public class EarthquakesRepository implements EarthquakesRepoInterface{

    private Map<String, Point2D> earthquakesRepo;

    @Override
    public void saveEarthquakesRepo(Map<String, Point2D> map) {
        this.earthquakesRepo = map;
    }

    @Override
    public Map<String, Point2D> getEarthquakesRepo() {
        return this.earthquakesRepo;
    }
}
