package edu.eci.arsw.weather.Controllers;

import edu.eci.arsw.weather.Cache.OpenWeatherCacheImpl;
import edu.eci.arsw.weather.Services.OpenWeatherAppException;
import edu.eci.arsw.weather.Services.OpenWeatherAppServices;
import edu.eci.arsw.weather.Services.OpenWeatherAppServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador API REST de la aplicacion Open-Weather-App
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherAppController {

    @Autowired
    OpenWeatherAppServicesImpl opas = null;

    @Autowired
    OpenWeatherCacheImpl openWeatherCache;

    /**
     * Obtiene el clima de una cierta ciudad en el mundo
     *
     * @param city El nombre de la ciudad a buscar
     * @return Una entidad de respuesta
     */
    @GetMapping(value = "")
    public ResponseEntity<?> getWeatherByCity(@RequestParam(value = "city") String city){
        System.out.println(city);
        try {
            return new ResponseEntity<>(opas.getWeatherByCity(city), HttpStatus.ACCEPTED);
        } catch (OpenWeatherAppException e) {
            Logger.getLogger(WeatherAppController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/size")
    public Long getSize(){
        return openWeatherCache.size();
    }
}
