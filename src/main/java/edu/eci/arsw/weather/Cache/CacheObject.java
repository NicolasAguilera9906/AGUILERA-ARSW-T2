package edu.eci.arsw.weather.Cache;

import java.lang.ref.SoftReference;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Cached objects with key and expiration time
 * @Author laoxu
 * @Date 2019/7/27 15:28
 **/
public class CacheObject implements Delayed {

    private final String key;
    private final String reference;
    private final long expiryTime;

    public CacheObject(String key, String reference, long expiryTime) {
        this.key = key;
        this.reference = reference;
        this.expiryTime = expiryTime;
    }

    public String getKey() {
        return key;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(expiryTime, ((CacheObject) o).expiryTime);
    }
}