package com.projects.vilasini;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        LruCacheNCapacity nCache = new LruCacheNCapacity(2);
        nCache.put(1,"1");
        nCache.put(2,"2");
        System.out.println("Value of 1 is: "+ nCache.get(1));
        nCache.put(3,"3");
        System.out.println("Value of 2 is: "+ nCache.get(2));
        nCache.put(4,"4");
        System.out.println("Value of 1 is: "+ nCache.get(1));
        System.out.println("Value of 3 is: "+ nCache.get(3));
        System.out.println("Value of 4 is: "+ nCache.get(4));
/*        LruCache cache = new LruCache(2);
        cache.put(1,"1");
        cache.put(2,"2");
        System.out.println("Value of 1 is : "+ cache.get(1));
        cache.put(3,"3");
        System.out.println("Value of 2 is : "+cache.get(2));
        cache.put(4,"4");
        System.out.println("Value of 1 is : "+cache.get(1));
        System.out.println("Value of 3 is : "+cache.get(3));
        System.out.println("Value of 4 is : "+cache.get(4));*/
    }
}



