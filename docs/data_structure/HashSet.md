# The Principle of Hash Table
哈希表的原理
The key idea of Hash Table is to use a hash function to map keys to buckets. To be more specific,
哈希表的关键思想是使用哈希函数来 map keys to buckets .更具体地说，

When we insert a new key, the hash function will decide which bucket the key should be assigned and the key will be stored in the corresponding bucket;
当我们插入新密钥时，hash 函数将决定应该为哪个存储桶分配密钥，并将密钥存储在相应的存储桶中;
When we want to search for a key, the hash table will use the same hash function to find the corresponding bucket and search only in the specific bucket.
当我们想要搜索一个键时，哈希表将使用hash函数来 same 查找对应的存储桶，并且仅在特定的存储桶中进行搜索。
![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/20/screen-shot-2018-02-19-at-183537.png)

In the example, we use `y = x % 5` as our hash function. Let's go through the insertion and search strategies using this example:  
在示例中，我们使用哈希函数 `y = x % 5` 。让我们使用此示例浏览插入和搜索策略：

1. Insertion: we parse the keys through the hash function to map them into the corresponding bucket.  
    插入：我们通过哈希函数解析键，将它们映射到相应的存储桶中。
    - e.g. 1987 is assigned to bucket 2 while 24 is assigned to bucket 4.  
        例如，1987 分配给存储桶 2，而 24 分配给存储桶 4。
2. Search: we parse the keys through the same hash function and search only in the specific bucket.  
    搜索：我们通过相同的哈希函数解析键，只在特定桶中搜索。
    - e.g. if we search for 1987, we will use the same hash function to map 1987 to 2. So we search in bucket 2 and we successfully find out 1987 in that bucket.  
        例如，如果我们搜索 1987，我们将使用相同的哈希函数将 1987 映射到 2。所以我们在存储桶 2 中搜索，我们成功地在该存储桶中找到了 1987 年。
    - e.g. if we search for 23, will map 23 to 3 and search in bucket 3. And We find out that 23 is not in bucket 3 which means 23 is not in the hash table.  
        例如，如果我们搜索 23，则将 23 映射到 3 并在存储桶 3 中搜索。我们发现 23 不在存储桶 3 中，这意味着 23 不在哈希表中。

# Keys to Design a Hash Table
**The hash function is the most important component of a hash table which is used to map the key to a specific bucket. In the example in the previous article, we use y = x % 5 as a hash function, where x is the key value and y is the index of the assigned bucket.  
哈希函数是哈希表中最重要的组件，用于将键映射到特定存储桶。在上一篇文章的示例中，我们使用 y = x % 5 作为哈希函数，其中 x 是键值，y 是分配存储桶的索引。

The hash function will depend on `the range of key values` and `the number of buckets`.  
哈希函数将取决于 `the range of key values` 和 `the number of buckets` 。

Here are some examples of hash functions:  
以下是哈希函数的一些示例：

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/05/04/screen-shot-2018-05-04-at-145454.png)

It is an open problem to design a hash function. The idea is to try to assign the key to the bucket as `uniformly as you can`. Ideally, a perfect hash function will be a one-one mapping between the key and the bucket. However, in most cases, a hash function is not perfect and it is a tradeoff between `the amount of buckets` and `the capacity of a bucket`.  
设计哈希函数是一个悬而未决的问题。这个想法是尝试将存储桶的密钥分配为 `uniformly as you can` .理想情况下，完美的哈希函数将是键和存储桶之间的一对一映射。但是，在大多数情况下，哈希函数并不完美，它是 和 `the capacity of a bucket` 之间的 `the amount of buckets` 权衡。**

# Design HashSet
Implement `MyHashSet` class:  
实现 `MyHashSet` 类：

- `void add(key)` Inserts the value `key` into the HashSet.  
    `void add(key)` 将值 `key` 插入到哈希集中。
- `bool contains(key)` Returns whether the value `key` exists in the HashSet or not.  
    `bool contains(key)` 返回值 `key` 是否存在于哈希集中。
- `void remove(key)` Removes the value `key` in the HashSet. If `key` does not exist in the HashSet, do nothing.  
    `void remove(key)` 删除哈希集中的值 `key` 。如果 HashSet 中不存在，则 `key` 不执行任何操作。

```run-java
package org.leetcode;  
  
import java.util.*;  
  
public class MyHashSet {  
    /**  
     * Your MyHashSet object will be instantiated and called as such:     * MyHashSet obj = new MyHashSet();     * obj.add(key);     * obj.remove(key);     * boolean param_3 = obj.contains(key);     */  
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
    * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]        [[], [1], [2], [1], [3], [2], [2], [2], [2]]        Output        [null, null, null, true, false, null, true, null, false]  
        Explanation        MyHashSet myHashSet = new MyHashSet();        myHashSet.add(1);      // set = [1]        myHashSet.add(2);      // set = [1, 2]        myHashSet.contains(1); // return True        myHashSet.contains(3); // return False, (not found)        myHashSet.add(2);      // set = [1, 2]        myHashSet.contains(2); // return True        myHashSet.remove(2);   // set = [1]        myHashSet.contains(2); // return False, (already removed)    *    * */    public static void main(String[] args) {  
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
```

# Design HashMap 
Implement the `MyHashMap` class:  
实现 `MyHashMap` 类：

- `MyHashMap()` initializes the object with an empty map.  
    `MyHashMap()` 使用空映射初始化对象。
- `void put(int key, int value)` inserts a `(key, value)` pair into the HashMap. If the `key` already exists in the map, update the corresponding `value`.  
    `void put(int key, int value)` 将一 `(key, value)` 对插入到哈希映射中。如果映射中已存在 ， `key` 请更新相应的 `value` .
- `int get(int key)` returns the `value` to which the specified `key` is mapped, or `-1` if this map contains no mapping for the `key`.  
    `int get(int key)` 返回指定 `key` 映射到的 ， `value` 或者 `-1` 如果此映射不包含 的 `key` 映射。
- `void remove(key)` removes the `key` and its corresponding `value` if the map contains the mapping for the `key`.  
    `void remove(key)` 如果映射包含 的 `key` 映射，则删除 及其 `key` 对应的 `value` 映射。

```run-java
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
     * Your MyHashMap object will be instantiated and called as such:     * MyHashMap obj = new MyHashMap();     * obj.put(key,value);     * int param_2 = obj.get(key);     * obj.remove(key);     */    private KeyValuePair[] map;  
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
```

# Hash Set - Usage
```run-java
import java.util.*;
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize the hash set
        Set<Integer> hashSet = new HashSet<>();     
        // 2. add a new key
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        // 3. remove the key
        hashSet.remove(2);        
        // 4. check if the key is in the hash set
        if (!hashSet.contains(2)) {
            System.out.println("Key 2 is not in the hash set.");
        }
        // 5. get the size of the hash set
        System.out.println("The size of has set is: " + hashSet.size());     
        // 6. iterate the hash set
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("are in the hash set.");
        // 7. clear the hash set
        hashSet.clear();
        // 8. check if the hash set is empty
        if (hashSet.isEmpty()) {
            System.out.println("hash set is empty now!");
        }
    }
}
```

##  Single Number


Given a **non-empty** array of integers `nums`, every element appears _twice_ except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

```run-java
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums1)); // expected: true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums2)); // expected: false

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(solution.containsDuplicate(nums3)); // expected: true
    }
}

```

## Intersection of Two Arrays

Given two integer arrays `nums1` and `nums2`, return _an array of their intersection_. Each element in the result must be **unique** and you may return the result in **any order**.
```run-java
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }
        
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection1 = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection1)); // expected: [2]
        
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] intersection2 = solution.intersection(nums3, nums4);
        System.out.println(Arrays.toString(intersection2)); // expected: [9, 4]
    }
}

```

## Happy Number 快乐号码

Solution

Write an algorithm to determine if a number `n` is happy.  
编写一个算法来确定一个数字 `n` 是否满意。

A **happy number** is a number defined by the following process:  
快乐数是由以下过程定义的数字：

- Starting with any positive integer, replace the number by the sum of the squares of its digits.  
    从任何正整数开始，将数字替换为其数字的平方和。
- Repeat the process until the number equals 1 (where it will stay), or it **loops endlessly in a cycle** which does not include 1.  
    重复该过程，直到数字等于 1（它将停留在何处），或者它在不包括 1 的循环中无休止地循环。
- Those numbers for which this process **ends in 1** are happy.  
    这个过程以 1 结尾的那些数字是快乐的。

Return `true` _if_ `n` _is a happy number, and_ `false` _if not_.  
如果是一个快乐的数字， `false` 则 `n` 返回 `true` ，如果不是。

```run-java
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = calculateSumOfSquares(n);
        }
        
        return n == 1;
    }
    
    private int calculateSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n1 = 19;
        System.out.println(solution.isHappy(n1)); // expected: true
        
        int n2 = 2;
        System.out.println(solution.isHappy(n2)); // expected: false
    }
}

```

# Hash Map - Usage
```run-java
import java.util.*;
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize a hash map
        Map<Integer, Integer> hashmap = new HashMap<>();
        // 2. insert a new (key, value) pair
        hashmap.putIfAbsent(0, 0);
        hashmap.putIfAbsent(2, 3);
        // 3. insert a new (key, value) pair or update the value of existed key
        hashmap.put(1, 1);
        hashmap.put(1, 2);
        // 4. get the value of specific key
        System.out.println("The value of key 1 is: " + hashmap.get(1));
        // 5. delete a key
        hashmap.remove(2);
        // 6. check if a key is in the hash map
        if (!hashmap.containsKey(2)) {
            System.out.println("Key 2 is not in the hash map.");
        }
        // 7. get the size of the hash map
        System.out.println("The size of hash map is: " + hashmap.size()); 
        // 8. iterate the hash map
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("are in the hash map.");
        // 9. clear the hash map
        hashmap.clear();
        // 10. check if the hash map is empty
        if (hashmap.isEmpty()) {
            System.out.println("hash map is empty now!");
        }
    }
}
```

## Two Sum

Solution

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.
```run-java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (hashmap.containsKey(nums[i])) {
                return new int[] {hashmap.get(nums[i]), i};
            }
            hashmap.put(difference, i);
        }
        return null; // No valid solution found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]); // expected: 0, 1
    }
}

```

## Isomorphic Strings 同构字符串

Solution

Given two strings `s` and `t`, _determine if they are isomorphic_.  
给定两个字符串 `s` 和 `t` ，确定它们是否同构。

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.  
两个字符串 `s` ， `t` 如果可以替换 中的 `s` 字符以获得 `t` .

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.  
一个字符的所有匹配项都必须替换为另一个字符，同时保留字符的顺序。没有两个字符可以映射到同一个字符，但一个字符可以映射到自身。
```run-java
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                map.put(sChar, tChar);
            }
            
            if (map2.containsKey(tChar)) {
                if (map2.get(tChar) != sChar) {
                    return false;
                }
            } else {
                map2.put(tChar, sChar);
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "egg";
        String t1 = "add";
        System.out.println(solution.isIsomorphic(s1, t1)); // expected: true
        
        String s2 = "fot";
        String t2 = "bar";
        System.out.println(solution.isIsomorphic(s2, t2)); // expected: false
        
        String s3 = "paper";
        String t3 = "title";
        System.out.println(solution.isIsomorphic(s3, t3)); // expected: true
    }
}

```

## Minimum Index Sum of Two Lists  两个列表的最小索引总和

Solution

Given two arrays of strings `list1` and `list2`, find the **common strings with the least index sum**.  
给定两个字符串数组和 `list2` ，找到索引总和最小的公共字符串 `list1` 。

A **common string** is a string that appeared in both `list1` and `list2`.  
公共字符串是同时出现在 `list1` 和 `list2` 中的字符串。

A **common string with the least index sum** is a common string such that if it appeared at `list1[i]` and `list2[j]` then `i + j` should be the minimum value among all the other **common strings**.  
具有最小索引总和的公共字符串是一个公共字符串，因此如果它出现在 `list1[i]` and `list2[j]` 然后 `i + j` 应该是所有其他公共字符串中的最小值。

Return _all the **common strings with the least index sum**_. Return the answer in **any order**.  
返回索引总和最少的所有公共字符串。按任意顺序返回答案。

```run-java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int minIndexSum = Integer.MAX_VALUE;
        List<String> commonStrings = new ArrayList<>();
        
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int indexSum = j + map.get(list2[j]);
                
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    commonStrings.clear();
                    commonStrings.add(list2[j]);
                } else if (indexSum == minIndexSum) {
                    commonStrings.add(list2[j]);
                }
            }
        }
        
        return commonStrings.toArray(new String[commonStrings.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] result1 = solution.findRestaurant(list1, list2);
        for (String str : result1) {
            System.out.print(str + " "); // expected: Shogun
        }
        System.out.println();
        
        String[] list3 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list4 = {"KFC","Shogun","Burger King"};
        String[] result2 = solution.findRestaurant(list3, list4);
        for (String str : result2) {
            System.out.print(str + " "); // expected: Shogun
        }
        System.out.println();
        
        String[] list5 = {"happy","sad","good"};
        String[] list6 = {"sad","happy","good"};
        String[] result3 = solution.findRestaurant(list5, list6);
        for (String str : result3) {
            System.out.print(str + " "); // expected: sad happy
        }
        System.out.println();
    }
}

```

## First Unique Character in a String 字符串中的第一个唯一字符

Solution

Given a string `s`, _find the first non-repeating character in it and return its index_. If it does not exist, return `-1`.  
给定一个字符串 `s` ，找到其中的第一个非重复字符并返回其索引。如果不存在，则返回 `-1` 。

**Example 1: 示例 1：**

**Input:** s = "leetcode"
**Output:** 0

```run-java
import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        // Create a hash map to store character count
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Calculate count for each character in the string
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no non-repeating character found, return -1
        return -1;
    }
    public static void main(String[] args) {
    Solution solution = new Solution();
    
    String s = "leetcode";
    int result = solution.firstUniqChar(s);
    System.out.println("First non-repeating character index: " + result);
}

}

```

## intersection of Two Arrays II  两个阵列的交集 II

Given two integer arrays `nums1` and `nums2`, return _an array of their intersection_. Each element in the result must appear as many times as it shows in both arrays and you may return the result in **any order**.  
给定两个整数数组 `nums1` 和 `nums2` ，返回它们交集的数组。结果中的每个元素必须与它在两个数组中显示的次数一样多，并且您可以按任何顺序返回结果。

**Example 1: 示例 1：**

**Input:** nums1 = [1,2,2,1], nums2 = [2,2]
**Output:** [2,2]

**Example 2: 示例 2：**

**Input:** nums1 = [4,9,5], nums2 = [9,4,9,8,4]
**Output:** [4,9]
**Explanation:** [9,4] is also accepted.

```run-java
import java.util.*;
import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create a hash map to store element count of nums1
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        
        // Calculate count for each element in nums1
        for (int num : nums1) {
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }
        
        // Create a list to store common elements
        List<Integer> resultList = new ArrayList<>();
        
        // Find the common elements in nums2 and add them to the list
        for (int num : nums2) {
            if (elementCount.containsKey(num) && elementCount.get(num) > 0) {
                resultList.add(num);
                elementCount.put(num, elementCount.get(num) - 1);
            }
        }
        
        // Convert the list to an array and return
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
    Solution solution = new Solution();
    
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};
    int[] result1 = solution.intersect(nums1, nums2);
    System.out.println("Intersection: " + Arrays.toString(result1));
    
    int[] nums3 = {4, 9, 5};
    int[] nums4 = {9, 4, 9, 8, 4};
    int[] result2 = solution.intersect(nums3, nums4);
    System.out.println("Intersection: " + Arrays.toString(result2));
}

}

```


```run-java

  
public class ContainsNearbyDuplicate {  
    public boolean containsNearbyDuplicate(int[] nums, int k) {  
        boolean result = false;  
        int index = nums.length;  
        if(index == 0){  
            return result;  
        } else if (k== 0){  
            return result;  
        } else if (k >= index){  
            k = index;  
        }  
  
        for(int i=0;i<index-1;i++){  
            for(int j=i+1;j<=i+k && j<index;j++){  
                if(nums[i] == nums[j]){  
                    result = true;  
                    return result;  
                }  
            }  
        }  
  
        return result;  
  
    }  
  
    public static void main(String[] args){  
        ContainsNearbyDuplicate obj = new ContainsNearbyDuplicate();  
        int[] nums1 = {1,2,3,1};  
        int k1 = 3;  
        boolean result1 = obj.containsNearbyDuplicate(nums1, k1);  
        System.out.println(result1);//true  
    }  
  
  
}
```

## Group Anagrams 组字谜

Solution

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.  
给定一个字符串 `strs` 数组，将字谜组合在一起。您可以按任意顺序返回答案。

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.  
字谜是通过重新排列不同单词或短语的字母而形成的单词或短语，通常只使用一次所有原始字母。

**Example 1: 示例 1：**

**Input:** strs = ["eat","tea","tan","ate","nat","bat"]
**Output:** [["bat"],["nat","tan"],["ate","eat","tea"]]

**Example 2: 示例 2：**

**Input:** strs = [""]
**Output:** [[""]]

**Example 3: 例3：**

**Input:** strs = ["a"]
**Output:** [["a"]]

```run-java

import java.util.*;  
public class GroupAnagrams {  
    public List<List<String>> groupAnagrams(String[] strs) {  
  
        HashMap<String, List<String>> map = new HashMap<>();  
  
        for(String s : strs){  
            char[] c = s.toCharArray();  
            Arrays.sort(c);  
            String key = String.valueOf(c);  
            if(!map.containsKey(key)){  
                map.put(key, new ArrayList<>());  
            }  
            map.get(key).add(s);  
        }  
  
        List<List<String>> result = new ArrayList<>(map.values());  
        return result;  
  
    }  
  
    public static void main(String[] args) {  
        GroupAnagrams solution = new GroupAnagrams();  
  
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};  
        List<List<String>> result1 = solution.groupAnagrams(strs1);  
        System.out.println("Anagram Groups: " + result1);  
  
        String[] strs2 = {""};  
        List<List<String>> result2 = solution.groupAnagrams(strs2);  
        System.out.println("Anagram Groups: " + result2);  
  
        String[] strs3 = {"a"};  
        List<List<String>> result3 = solution.groupAnagrams(strs3);  
        System.out.println("Anagram Groups: " + result3);  
    }  
  
}
```
