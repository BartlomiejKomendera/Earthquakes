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

    @Autowired
    private EarthquakesServiceInterface esi;

    @RequestMapping("/")
    public String index(Model model) throws IOException {
        //model.addAttribute("earthquakes", esi.getEarthquakes());
        return "index";
    }

    @GetMapping("/all")
    public List<Feature> getAll() throws IOException {
        return esi.getEarthquakes();
    }

    /*@GetMapping("/closest")
    public List<String> getClosest(@RequestParam Float lat, @RequestParam Float lon) throws IOException {
        return esi.getCloseEarthquakes(lat, lon);
    }*/
    @GetMapping("/closest")
    public String getClosest(Model model) throws IOException {
        float lat = 49.799877f;
        float lon = 19.325485f;
        model.addAttribute("earthquakes", esi.getCloseEarthquakes(lat,lon));
        return "index";
    }

}
