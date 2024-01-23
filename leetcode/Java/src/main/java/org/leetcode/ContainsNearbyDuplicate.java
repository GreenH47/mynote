package org.leetcode;

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
