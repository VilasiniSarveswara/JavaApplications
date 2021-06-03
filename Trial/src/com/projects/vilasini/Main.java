package com.projects.vilasini;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);
        cache.put(1,"1");
        cache.put(2,"2");
        System.out.println("Value of 1 is : "+ cache.get(1));
        cache.put(3,"3");
        System.out.println("Value of 2 is : "+cache.get(2));
        cache.put(4,"4");
        System.out.println("Value of 1 is : "+cache.get(1));
        System.out.println("Value of 3 is : "+cache.get(3));
        System.out.println("Value of 4 is : "+cache.get(4));
    }
}



