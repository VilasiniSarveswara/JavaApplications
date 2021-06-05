package com.projects.vilasini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Try to implement a cache with capacity N. Each (key,value) pair should have a freshness value

public class LruCache {
    private static int capacity;
    private static List<Item> itemsList = new ArrayList<>();


    public LruCache(int capacityOfCache) {
        capacity = capacityOfCache;
    }

/*    public LruCache(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.freshnessValue = 0;
    }

    //DataStructure - Using a List of LruCache objects
    List<LruCache> cacheList = new ArrayList<>();*/

    public void put(Integer k, String v) {
        //1.Check if list is empty. If list is empty, add the (key,value) pair and set the freshness value.

        if (itemsList.size() == 0) {
            addItemToList(k, v);
        }
        //2.If the list already has objects, check if the key exists
        else {
            boolean isKeyAvailable = false;
            for (Item item : itemsList) {

                if (item.key.equals(k)) {
                    isKeyAvailable = true;
                    break;
                }
            }

            //3.If key does not exist AND if cache has not reached max capacity
            //Decrease the freshness value for each key-value pair & then add the new (k,v) to the list.
            if ((!(isKeyAvailable)) && (itemsList.size() != capacity)) {
                for (Iterator<Item> iterator = itemsList.iterator(); iterator.hasNext(); ) {
                    Item item = iterator.next();
                    item.freshnessValue = item.freshnessValue - 1;
                }
                addItemToList(k, v);
            } else if ((!(isKeyAvailable)) && (itemsList.size() == capacity)) {
                for (Iterator<Item> iterator = itemsList.iterator(); iterator.hasNext(); ) {
                    Item item = iterator.next();
                    item.freshnessValue = item.freshnessValue - 1;
                    if (item.freshnessValue == 0) {
                        iterator.remove();
                    }
                }
                addItemToList(k, v);
            }

        }
    }

    public String get(Integer k) {
        String value = null;
        //1.Check if the key exists. If key does not exist, there is no need to change the freshness values
        boolean keyExists = false;
        for (Item item : itemsList) {
            if (item.key == k) {
                keyExists = true;
                break;
            }
        }
        if (keyExists) { // For each object, check if the key matches. If key matches, increase its freshness value, else decrease its freshness value.
            for (int i = 0; i < itemsList.size(); i++) {
                if (itemsList.get(i).key.equals(k)) {
                    //If the item's freshness is not the freshest, increase its freshness, AND
                    // Decrease the freshness of items having freshness GREATER than it. That way we do not have remove items when MAX capacity has not been reached.
                    if (itemsList.get(i).freshnessValue != capacity) {
                        value = itemsList.get(i).value;
                        itemsList.get(i).freshnessValue = capacity;
                        for (int j = 0; j < itemsList.size(); j++) {
                            if(j != i){ //Decrease the freshness value of OTHER items
                                itemsList.get(j).freshnessValue = itemsList.get(j).freshnessValue - 1;
                            }
                        }
                        break; //BREAK OUT OF THE FOR LOOP after setting freshness values
                    }
                    else{
                        value = itemsList.get(i).value;
                    }

                }
            }
        }
        return value;
    }

    private void addItemToList(Integer key, String value) {
        Item item = new Item(key, value, capacity);
        itemsList.add(item);
    }
}
