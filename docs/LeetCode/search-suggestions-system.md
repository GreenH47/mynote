[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/search-suggestions-system/?envType=study-plan-v2&envId=leetcode-75)  
You are given an array of strings `products` and a string `searchWord`.  
您将获得一个字符串数组和一个字符串 `products` `searchWord` 。

Design a system that suggests at most three product names from `products` after each character of `searchWord` is typed. Suggested products should have common prefix with `searchWord`. If there are more than three products with a common prefix return the three lexicographically minimums products.  
设计一个系统，在键入每个 `searchWord` 字符后建议 `products` 最多三个产品名称。建议的产品应具有与 . `searchWord` 如果有三个以上的产品具有公共前缀，则返回三个按字典顺序排列的最小产品。

Return _a list of lists of the suggested products after each character of_ `searchWord` _is typed_.  
键入每个 `searchWord` 字符后返回建议产品的列表。

**Example 1: 示例 1：**

**Input:** products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
**Output:** [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
**Explanation:** products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

**Example 2: 示例 2：**

**Input:** products = ["havana"], searchWord = "havana"
**Output:** [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
**Explanation:** The only word "havana" will be always suggested while typing the search word.

**Constraints: 约束：**

- `1 <= products.length <= 1000`
- `1 <= products[i].length <= 3000`
- `1 <= sum(products[i].length) <= 2 * 104`
- All the strings of `products` are **unique**.  
    的所有 `products` 字符串都是唯一的。
- `products[i]` consists of lowercase English letters.  
    `products[i]` 由小写英文字母组成。
- `1 <= searchWord.length <= 1000`
- `searchWord` consists of lowercase English letters.  
    `searchWord` 由小写英文字母组成。

```java
package org.leetcode;  
  
import java.util.*;  
  
public class SuggestedProducts {  
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {  
        //transfer the products array to a list  
        List<String> productsList = Arrays.asList(products);  
        //Sort the products array  
        Arrays.sort(products);  
        //initialize the result list  
        List<List<String>> result = new ArrayList<>();  
        //index of the products array  
        TreeMap<String,Integer> map = new TreeMap<>();  
  
        //loop through the search word  
        // if product only have one character, then add the product to the result list        if (products.length == 1) {  
            map.put(products[0],0);  
        }else{  
            int productLength = products.length;  
            int mapRange = Math.min(searchWord.length(),productLength);  
            for(int i = 0; i < mapRange; i++){  
                map.put(products[i],i);  
            }  
        }  
  
  
  
  
        String prefix = "";  
        for(char c : searchWord.toCharArray()){  
            prefix += c;  
            String ceiling = map.ceilingKey(prefix);  
            String floor = map.floorKey(prefix + "~");  
            if(ceiling == null || floor == null){  
                break;  
            }  
            result.add(productsList.subList(map.get(ceiling),Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));  
        }  
  
        while(result.size() < searchWord.length()){  
            result.add(new ArrayList<>());  
        }  
        return result;  
    }  
  
    public static void main(String[] args) {  
        SuggestedProducts obj = new SuggestedProducts();  
        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};  
        String searchWord1 = "monl";  
        List<List<String>> result1 = obj.suggestedProducts(products1, searchWord1);  
        //Expected output: [["mobile", "moneypot", "monitor"], ["mobile", "moneypot", "monitor"], ["mouse", "mousepad"], ["mouse", "mousepad"], ["mouse", "mousepad"]]  
        System.out.println(result1);  
  
        String[] products2 = {"havana"};  
        String searchWord2 = "havana";  
        List<List<String>> result2 = obj.suggestedProducts(products2, searchWord2);  
        //Expected output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]  
        System.out.println(result2);  
  
        //["code","codephone","coddle","coddles","codes"]  
        String[] products3 = {"code","codephone","coddle","coddles","codes"};  
        String searchWord3 = "coddle";  
        List<List<String>> result3 = obj.suggestedProducts(products3, searchWord3);  
        System.out.println(result3);  
  
  
    }  
}
```