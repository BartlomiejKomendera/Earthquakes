package com.bkomendera.earthquakes.view;

import com.bkomendera.earthquakes.service.EarthquakesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class EarthquakesController {

    private String title;
    @Autowired
    private EarthquakesServiceInterface esi;

    @RequestMapping("/")
    public String index() throws IOException {
        esi.loadEarthquakes();
        return "index";
    }

    @GetMapping("/closest")
    public String getClosest(Model model) throws IOException {
        float lat = 49.799877f;
        float lon = 19.325485f;
        model.addAttribute("earthquakes", esi.getCloseEarthquakes(lat,lon));
        title="10 closest earthquakes to your location: ";
        model.addAttribute("title",title);
        return "closest";
    }

    @GetMapping("/all")
    public String getAll(Model model) throws IOException {
        model.addAttribute("earthquakes", esi.getEarthquakes());
        title="Earthquakes that were registered in the past 30 days: ";
        model.addAttribute("title",title);
        return "all";
    }

}
