package edu.eci.arsw.weather.Services;

public interface OpenWeatherAppServices {

    public String getWeatherByCity(String city) throws OpenWeatherAppException;
}
