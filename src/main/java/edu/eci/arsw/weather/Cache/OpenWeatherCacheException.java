package edu.eci.arsw.weather.Cache;

/**
 * Clase que maneja las excepciones presentadas en el manejo del cache de la aplicación OpenWeatherApp
 */

public class OpenWeatherCacheException extends Exception {

    /**
     * Constructor de la clase OpenWeatherCacheException
     * @param msg el mensaje a ser lanzado como excepción
     */
    public OpenWeatherCacheException(String msg) {
        super(msg);
    }

}