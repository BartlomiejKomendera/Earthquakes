package com.bkomendera.earthquakes.data.api;
import com.bkomendera.earthquakes.domain.Earthquakes;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class RESTclient {
    public Earthquakes getClient() throws IOException {
        URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
        InputStreamReader streamReader = new InputStreamReader(url.openStream());
        return new Gson().fromJson(streamReader, Earthquakes.class);
    }
}
