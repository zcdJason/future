package com.future.data.structure.linearStructure.Map.letcode;

import java.util.HashMap;

public class Solution {
    //letcode 1: 两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> tmpMap = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(tmpMap.containsKey(nums[i]))
            {
                res[0] = i;
                res[1] = tmpMap.get(nums[i]);
                return res;
            }
            tmpMap.put(target - nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = new int[]{4,3,1,7,8};
//        int[] t = new int[]{2,5,5,11};
        int target = 9;
        Solution s = new Solution();
        int[] rr = s.twoSum(t, target);
        for (int i : rr) {
            System.out.println(i);
        }
    }
}
