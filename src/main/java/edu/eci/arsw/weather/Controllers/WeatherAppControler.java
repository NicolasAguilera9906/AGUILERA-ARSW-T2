package edu.eci.arsw.weather.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherAppControler {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}
