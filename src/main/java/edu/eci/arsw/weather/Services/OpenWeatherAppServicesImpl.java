package edu.eci.arsw.weather.Services;

import edu.eci.arsw.weather.APIConsumers.ApiConsumerImpl;
import edu.eci.arsw.weather.Cache.OpenWeatherCacheImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherAppServicesImpl implements OpenWeatherAppServices {

    @Autowired
    ApiConsumerImpl apiConsumer;

    @Autowired
    OpenWeatherCacheImpl openWeatherCache;


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
