package com.projects.vilasini;

public class Main {

    public static void main(String[] args) {

        LruCache cache = new LruCache(3);
        cache.put(1,"1");
        cache.put(2,"2");
        System.out.println("Value of 1 is: "+ cache.get(1));
        cache.put(3,"3");
        System.out.println("Value of 2 is: "+ cache.get(2));
        cache.put(4,"4");
        cache.put(5,"5");
        System.out.println("Value of 6 is : " + cache.get(6));
        System.out.println("Value of 1 is: "+ cache.get(1));
        System.out.println("Value of 2 is: "+ cache.get(2));
        System.out.println("Value of 3 is: "+ cache.get(3));
        System.out.println("Value of 4 is: "+ cache.get(4));
        System.out.println("Value of 5 is: "+ cache.get(5));
        System.out.println("Value of 5 is: "+ cache.get(5));
        System.out.println("Value of 5 is: "+ cache.get(5));
        System.out.println("Value of 1 is: "+ cache.get(1));
        System.out.println("Value of 2 is: "+ cache.get(2));
        System.out.println("Value of 3 is: "+ cache.get(3));
        System.out.println("Value of 4 is: "+ cache.get(4));
        System.out.println("Value of 5 is: "+ cache.get(5));

    }
}



