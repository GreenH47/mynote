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
        // if product only have one character, then add the product to the result list
        if (products.length == 1) {
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
