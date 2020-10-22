package edu.eci.arsw.weather.Cache;


/**
 * Interfaz del cache de OpenWeatherApp
 */

public interface OpenWeatherCache {

    /**
     * Añade un nuevo valor al cache de la aplicación
     * @param key la llave a ser usada en el cache
     * @param value el valor que se almacenará en el caché
     * @param periodInMillis el tiempo que durará el valor almacenado en caché
     * @throws OpenWeatherCacheException si la ciudad no existe o es nula
     */
    public void add(String key, String value, long periodInMillis) throws OpenWeatherCacheException;

    /**
     * Obtiene un valor del cache de acuerdo a una llave
     * @param key la llave a ser usada en el cache
     * @return el valor almacenado en cache
     */
    public String get(String key);


    /**
     * Obtiene el numero de elementos almacenados en caché
     * @return el numero de elementos almacenados en caché
     */
    public long size();

}