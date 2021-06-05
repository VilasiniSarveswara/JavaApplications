package com.projects.vilasini;

public class Item {
    Integer key;
    String value;
    int freshnessValue;

    public Item(Integer key, String value, int freshnessValue) {
        this.key = key;
        this.value = value;
        this.freshnessValue = freshnessValue;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFreshnessValue() {
        return freshnessValue;
    }

    public void setFreshnessValue(int freshnessValue) {
        this.freshnessValue = freshnessValue;
    }


}
