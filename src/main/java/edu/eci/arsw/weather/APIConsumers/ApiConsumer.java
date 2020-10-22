package edu.eci.arsw.weather.APIConsumers;


import org.springframework.stereotype.Service;

public interface ApiConsumer {

    public String getWeatherByCity(String city);
}
