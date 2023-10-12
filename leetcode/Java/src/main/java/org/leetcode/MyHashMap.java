package org.leetcode;
import java.util.*;
class KeyValuePair {
    private int key;
    private int value;

    public KeyValuePair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class MyHashMap {
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    private KeyValuePair[] map;
    public MyHashMap() {
        map = new KeyValuePair[1000000];
        Arrays.fill(map, null);
    }

    public void put(int key, int value) {
        map[key] = new KeyValuePair(key, value);

    }

    public int get(int key) {
        if (map[key] != null) {
            return map[key].getValue();
        }
        return -1;

    }

    public void remove(int key) {
        map[key] = null;

    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1)); // expected: 1
        System.out.println(myHashMap.get(3)); // expected: -1
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2)); // expected: 1
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2)); // expected: -1

        MyHashMap myHashMap2 = new MyHashMap();
        myHashMap2.put(1000, 1);
        System.out.println(myHashMap2.get(1000)); // expected: 1
        myHashMap2.put(0,2);
        System.out.println(myHashMap2.get(0)); // expected: 2
    }
}


