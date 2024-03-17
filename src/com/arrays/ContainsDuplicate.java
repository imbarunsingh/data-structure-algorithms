package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 5, 6};
        System.out.println("Contains Duplicate :: " + containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> dupMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dupMap.containsKey(nums[i])) {
                return true;
            } else {
                dupMap.put(nums[i], 1);
            }
        }
        return false;
    }

}
