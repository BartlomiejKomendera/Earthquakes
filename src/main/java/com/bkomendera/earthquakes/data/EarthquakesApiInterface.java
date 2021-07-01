package com.bkomendera.earthquakes.data;

import com.bkomendera.earthquakes.domain.Feature;

import java.io.IOException;
import java.util.List;

public interface EarthquakesApiInterface {
    public List<Feature> getAllMonth() throws IOException;
}
