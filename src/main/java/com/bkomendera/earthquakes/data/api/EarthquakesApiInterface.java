package com.bkomendera.earthquakes.data.api;

import com.bkomendera.earthquakes.domain.Feature;

import java.io.IOException;
import java.util.List;

public interface EarthquakesApiInterface {
    List<Feature> getAllMonth() throws IOException;
}
