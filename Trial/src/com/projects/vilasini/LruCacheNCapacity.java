package com.projects.vilasini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Try to implement a cache with capacity N. Each (key,value) pair should have a freshness value

public class LruCacheNCapacity {
    static int capacity;
    Integer key;
    String value;
    int freshnessValue;

    public LruCacheNCapacity(int capacityOfCache) {
        capacity = capacityOfCache;
    }

    public LruCacheNCapacity(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.freshnessValue = 0;
    }

    //DataStructure - Using a List of LruCache objects
    List<LruCacheNCapacity> cacheList = new ArrayList<>();

    public void put(Integer k, String v) {
        //1.Check if list is empty. If list is empty, add the (key,value) pair and set the freshness value.

        if (cacheList.size() == 0) {
            LruCacheNCapacity cache = new LruCacheNCapacity(k, v);
            cache.freshnessValue = capacity;
            cacheList.add(cache);
        }
        //2.If the list already has objects, check if the key exists
        else{
            boolean isKeyAvailable = false;
            for (LruCacheNCapacity cache : cacheList) {
                if (cache.key.equals(k)) {
                    isKeyAvailable = true;
                    break;
                }
            }

            //3.If key does not exist AND if cache has not reached max capacity
            //Decrease the freshness value for each key-value pair & then add the new (k,v) to the list.
            if((!(isKeyAvailable))&& (cacheList.size() != capacity)){
                for(Iterator<LruCacheNCapacity> iterator = cacheList.iterator(); iterator.hasNext();){
                    LruCacheNCapacity cacheFromList = iterator.next();
                    cacheFromList.freshnessValue = cacheFromList.freshnessValue - 1;
                }
                LruCacheNCapacity cache = new LruCacheNCapacity(k,v);
                cache.freshnessValue = capacity;
                cacheList.add(cache);
            }
            else if((!(isKeyAvailable)) && (cacheList.size() == capacity)){
                for(Iterator<LruCacheNCapacity> iterator = cacheList.iterator(); iterator.hasNext();){
                    LruCacheNCapacity cacheFromList = iterator.next();
                    cacheFromList.freshnessValue = cacheFromList.freshnessValue - 1;
                    if(cacheFromList.freshnessValue == 0){
                        iterator.remove();
                    }
                }
                LruCacheNCapacity cache = new LruCacheNCapacity(k,v);
                cache.freshnessValue = capacity;
                cacheList.add(cache);
            }

        }
    }

    public String get(Integer k){
        String value = null;
        //1.Check if the key exists
        boolean keyExists = false;
        for(LruCacheNCapacity cache : cacheList){
            if(cache.key == k){
                keyExists = true;
                break;
            }
        }
        if(keyExists){
            for(Iterator<LruCacheNCapacity> iterator = cacheList.iterator();iterator.hasNext();){
                LruCacheNCapacity cache  = iterator.next();
                if(cache.key.equals(k)){
                    value = cache.value;
                    cache.freshnessValue = capacity;
                }
                else{
                    cache.freshnessValue = cache.freshnessValue - 1;
                    if(cache.freshnessValue == 0){
                        cacheList.remove(cache);
                    }
                }
            }

        }

        return value;
    }
}
