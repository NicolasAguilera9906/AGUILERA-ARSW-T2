package edu.eci.arsw.weather.Services;


/**
 * Clase que maneja las excepciones presentadas en OpenWeatherAppServices
 */
public class OpenWeatherAppException extends Exception {

    /**
     * Constructor de la clase OpenWeatherCacheException
     * @param msg el mensaje a ser lanzado como excepción
     */
    public OpenWeatherAppException(String msg) {
        super(msg);
    }

}