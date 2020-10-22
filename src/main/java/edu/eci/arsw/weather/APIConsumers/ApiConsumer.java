package edu.eci.arsw.weather.APIConsumers;

/**
 * Interfaz consumidor de api externa de OpenWeatherApp
 */
public interface ApiConsumer {

    /**
     * Obtiene el clima de una ciudad en específico
     * @param city El nombre de la ciudad a buscar
     * @return Un string con el clima de la ciudad
     * @throws ApiConsumerException cuando la ciudad no existe , hay un problema con la conexión o la URL está mal formada
     */
    public String getWeatherByCity(String city) throws ApiConsumerException;
}
