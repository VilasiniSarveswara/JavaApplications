package com.projects.vilasini;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    private int capacity;
    static Integer mostRecentlyUsed;
    static Integer leastRecentlyUsed;
    private Map<Integer, String> cacheMap = new HashMap<>();
    //Constructor
    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(Integer k) {
        String value = null;
        //Check if key exists, else return null
        if(cacheMap.containsKey(k)){
             value =cacheMap.get(k);
             leastRecentlyUsed = mostRecentlyUsed;
             mostRecentlyUsed = k;
        }
        return value;
    }

    public void put(Integer k, String v) {
        //check if key already exists
        if(!(mostRecentlyUsed == k) || !(leastRecentlyUsed == k)){
            cacheMap.remove(leastRecentlyUsed);
            cacheMap.put(k, v);
            leastRecentlyUsed = mostRecentlyUsed;
            mostRecentlyUsed = k;
        }
    }
}
