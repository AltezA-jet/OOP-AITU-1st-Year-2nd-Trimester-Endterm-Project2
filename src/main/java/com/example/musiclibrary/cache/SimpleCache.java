package com.example.musiclibrary.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache {

    private static SimpleCache instance;

    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    private SimpleCache() {
    }

    
    public static synchronized SimpleCache getInstance() {
        if (instance == null) {
            instance = new SimpleCache();
        }
        return instance;
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public void clear() {
        cache.clear();
    }

    public void remove(String key) {
        cache.remove(key);
    }
}
