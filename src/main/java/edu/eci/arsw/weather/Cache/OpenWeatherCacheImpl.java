package edu.eci.arsw.weather.Cache;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;


@Service
public class OpenWeatherCacheImpl implements OpenWeatherCache {
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
    private final DelayQueue<CacheObject> cleaningUpQueue = new DelayQueue<>();

    public OpenWeatherCacheImpl() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    CacheObject cacheObject = cleaningUpQueue.take();
                    cache.remove(cacheObject.getKey(), cacheObject.getReference());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

    @Override
    public void add(String city, String weather, long periodInMillis) {
        if (city == null) {
            return;
        }
        if (weather == null) {
            cache.remove(city);
        } else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            cache.put(city, weather);
            cleaningUpQueue.put(new CacheObject(city, weather, expiryTime));
        }
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public String get(String city) {
        return cache.get(city);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public long size() {
        return cache.size();
    }

}