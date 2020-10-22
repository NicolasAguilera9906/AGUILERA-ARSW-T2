package edu.eci.arsw.weather.APIConsumers;

/**
 * Clase que maneja las excepciones presentadas en ApiConsumer
 */
public class ApiConsumerException extends Exception {

    /**
     * Constructor de la clase OpenWeatherCacheException
     * @param msg el mensaje a ser lanzado como excepción
     */
    public ApiConsumerException(String msg) {
        super(msg);
    }

}