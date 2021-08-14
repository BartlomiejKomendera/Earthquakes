package com.bkomendera.earthquakes.view;

import com.bkomendera.earthquakes.service.EarthquakesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EarthquakesController {

    private String title;
    @Autowired
    private EarthquakesServiceInterface esi;

    @RequestMapping("/")
    public String loadData() throws IOException {
        esi.loadEarthquakes();
        return "index";
    }
    @RequestMapping("/index")
    public String backToIndex() {
        return "index";
    }

    @GetMapping("/closest")
    public String getClosest(Model model,
                             @RequestParam(value="latitude", required = true) Float latitude,
                             @RequestParam(value="longitude", required = true) Float longitude
    ) throws IOException {
        float lat = latitude;
        float lon = longitude;
        List<String> formatList = new LinkedList();
        esi.getCloseEarthquakes(lat,lon).forEach( entry -> formatList.add(entry.getKey() + " - " + Math.round(entry.getValue()) + " km"));
        model.addAttribute("earthquakes", formatList);
        title="10 closest earthquakes to your location: ";
        model.addAttribute("title",title);
        return "closest";
    }

    @GetMapping("/all")
    public String getAll(Model model) throws IOException {
        List<String> formatList = new LinkedList();
        esi.getEarthquakes().forEach((s, coords) -> formatList.add(s + " - " + coords));
        model.addAttribute("earthquakes", formatList);
        title="Earthquakes that were registered in the past 30 days: ";
        model.addAttribute("title",title);
        return "all";
    }

}
