package edu.eci.arsw.weather.Services;

import edu.eci.arsw.weather.APIConsumers.ApiConsumer;
import edu.eci.arsw.weather.APIConsumers.ApiConsumerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherAppServicesImpl implements OpenWeatherAppServices {

    @Autowired
    ApiConsumerImpl apiConsumer;

    @Override
    public String getWeatherByCity(String city) throws OpenWeatherAppException {
        System.out.println("hola");
        try{
            return apiConsumer.getWeatherByCity(city);
        } catch(Exception e){
            throw new OpenWeatherAppException(e.getMessage());
        }
    }
}
