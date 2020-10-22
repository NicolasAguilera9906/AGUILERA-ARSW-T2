package edu.eci.arsw.weather.Services;


/**
 * Interfaz de servicios de OpenWeatherApp
 */
public interface OpenWeatherAppServices {

    /**
     * Obtiene el clima de una ciudad en base a su nombre
     * @param city El nombre de la ciudad
     * @throws OpenWeatherAppException en caso de que la ciudad no existe
     * @return Un string con el clima de la ciudad en cuestión
     */
    public String getWeatherByCity(String city) throws OpenWeatherAppException;
}
