package edu.eci.arsw.weather.Cache;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa a un objeto de Cache con tiempo de expiración.
 * Taken from : https://programmer.help/blogs/java-implements-simple-memory-caching-using-concurrent-hashmap.html
 **/
public class CacheObject implements Delayed {

    private final String key;
    private final String reference;
    private final long expiryTime;

    /**
     * Constructor de la clase CacheObject
     * @param key la llave a ser usada en el cache
     * @param reference el valor que se almacenará en el caché
     * @param expiryTime el tiempo que durará el valor almacenado en caché
     */
    public CacheObject(String key, String reference, long expiryTime) {
        this.key = key;
        this.reference = reference;
        this.expiryTime = expiryTime;
    }

    /**
     * Obtiene la llave del cache object
     */
    public String getKey() {
        return key;
    }

    /**
     * Obtiene la referencia del cache object
     */
    public String getReference() {
        return reference;
    }


    /**
     *
     * Devuelve el retraso restante asociado con este objeto, en la unidad de tiempo dada.
     * @param unit la unidad de tiempo
     * @return el retraso restante; Los valores cero o negativos indican que el retraso ya ha transcurrido.
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     *
     * Compara este objeto con el objeto especificado.
     * @param o el objeto a ser comparado
     * @return
     * un entero negativo, cero o un entero positivo ya que este objeto es menor, igual o mayor que el objeto especificado.
     */
    @Override
    public int compareTo(Delayed o) {
        return Long.compare(expiryTime, ((CacheObject) o).expiryTime);
    }
}