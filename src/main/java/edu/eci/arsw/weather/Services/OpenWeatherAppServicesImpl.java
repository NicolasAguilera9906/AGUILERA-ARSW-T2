package edu.eci.arsw.weather.Services;

import edu.eci.arsw.weather.APIConsumers.ApiConsumerImpl;
import edu.eci.arsw.weather.Cache.OpenWeatherCacheImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz de servicios de OpenWeatherApp
 */
@Service
public class OpenWeatherAppServicesImpl implements OpenWeatherAppServices {

    @Autowired
    ApiConsumerImpl apiConsumer;

    @Autowired
    OpenWeatherCacheImpl openWeatherCache;

    /**
     * Obtiene el clima de una ciudad en base a su nombre
     * @param city El nombre de la ciudad
     * @throws OpenWeatherAppException en caso de que la ciudad no existe
     * @return Un string con el clima de la ciudad en cuestión
     */
    @Override
    public String getWeatherByCity(String city) throws OpenWeatherAppException {
        try{
            if (openWeatherCache.get(city) == null) {
                String weather = apiConsumer.getWeatherByCity(city);
                openWeatherCache.add(city,apiConsumer.getWeatherByCity(city),300000);
                return weather;
            }
            else{
                return openWeatherCache.get(city);
            }
        } catch(Exception e){
            throw new OpenWeatherAppException(e.getMessage());
        }
    }
}
