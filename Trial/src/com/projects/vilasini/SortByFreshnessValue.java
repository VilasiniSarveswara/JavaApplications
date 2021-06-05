package com.projects.vilasini;

import java.util.Comparator;

public class SortByFreshnessValue implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {

        return item2.getFreshnessValue() - item1.getFreshnessValue();
    }
}
