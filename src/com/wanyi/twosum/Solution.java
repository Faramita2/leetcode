package com.wanyi.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) return new int[]{i, idx};
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] nums3 = {3,3};
        int target3 = 6;

        Solution solution = new Solution();
        int[] res1 = solution.twoSum(nums1, target1);
        System.out.println("res1 = " + Arrays.toString(res1));

        int[] res2 = solution.twoSum(nums2, target2);
        System.out.println("res2 = " + Arrays.toString(res2));

        int[] res3 = solution.twoSum(nums3, target3);
        System.out.println("res3 = " + Arrays.toString(res3));
    }
}
