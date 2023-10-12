package org.leetcode;

import java.util.*;

public class MyHashSet {
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */

    private static final int SIZE = 10000;
    private LinkedList<Integer>[] buckets;
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }

    public void add(int key) {
        int hash = key % SIZE;
        if (buckets[hash] == null) {
            buckets[hash] = new LinkedList<>();
        }
        if (!buckets[hash].contains(key)) {
            buckets[hash].add(key);
        }
    }

    public void remove(int key) {
        int hash = key % SIZE;
        if (buckets[hash] != null) {
            buckets[hash].removeFirstOccurrence(key);
        }
    }

    public boolean contains(int key) {
        int hash = key % SIZE;
        if (buckets[hash] != null) {
            return buckets[hash].contains(key);
        }
        return false;
    }
    /*
    * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
        [[], [1], [2], [1], [3], [2], [2], [2], [2]]
        Output
        [null, null, null, true, false, null, true, null, false]

        Explanation
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    *
    * */
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1)); // expected: true
        System.out.println(myHashSet.contains(3)); // expected: false
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2)); // expected: true
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2)); // expected: false
    }
}
