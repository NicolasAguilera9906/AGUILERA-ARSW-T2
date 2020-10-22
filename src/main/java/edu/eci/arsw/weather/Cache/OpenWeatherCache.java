package edu.eci.arsw.weather.Cache;



public interface OpenWeatherCache {

    public void add(String key, String country, long periodInMillis);

    public void remove(String key);

    public String get(String key);

    public void clear();

    public long size();

}