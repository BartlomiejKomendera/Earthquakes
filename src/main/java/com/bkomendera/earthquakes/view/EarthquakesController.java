package com.bkomendera.earthquakes.view;

import com.bkomendera.earthquakes.domain.Feature;
import com.bkomendera.earthquakes.service.EarthquakesServiceImpl;
import com.bkomendera.earthquakes.service.EarthquakesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class EarthquakesController {

    private String title;
    @Autowired
    private EarthquakesServiceInterface esi;

    @RequestMapping("/")
    public String index(Model model) throws IOException {
        model.addAttribute("earthquakes", esi.getEarthquakes());
        title="All earthquakes that happened in the last 30 days:";
        model.addAttribute("title",title);
        return "index";
    }

    @GetMapping("/closest")
    public String getClosest(Model model) throws IOException {
        float lat = 49.799877f;
        float lon = 19.325485f;
        model.addAttribute("earthquakes", esi.getCloseEarthquakes(lat,lon));
        title="10 closest earthquakes to your location:";
        model.addAttribute("title",title);
        return "closest";
    }

}
