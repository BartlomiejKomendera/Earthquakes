package com.bkomendera.earthquakes.data.repository;

import com.bkomendera.earthquakes.domain.util.Coords;
import org.springframework.stereotype.Component;

import java.awt.geom.Point2D;
import java.util.Map;

@Component
public class EarthquakesRepository implements EarthquakesRepoInterface{

    private Map<String, Coords> earthquakesRepo;

    @Override
    public void saveEarthquakesRepo(Map<String, Coords> map) {
        this.earthquakesRepo = map;
    }

    @Override
    public Map<String, Coords> getEarthquakesRepo() {
        return this.earthquakesRepo;
    }
}
