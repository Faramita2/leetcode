package com.wanyi.maximum.subarray;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int num :
                nums) {
            cur = Math.max(cur + num, num);
            max = Math.max(cur, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] a2 = {1};
        int[] a3 = {5, 4, -1, 7, 8};
        int[] a4 = {-2, 1};
        int[] a5 = {};

        InputStream is = Solution.class.getResourceAsStream("nums.txt");
        assert is != null;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            String text;

            while ((text = bufferedReader.readLine()) != null) {
                a5 = Arrays.stream(text.split(",")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ignored) {

            }
        }

        Solution solution = new Solution();

        int res1 = solution.maxSubArray(a1);
        System.out.println("res1 = " + res1); // 6
        int res2 = solution.maxSubArray(a2);
        System.out.println("res2 = " + res2); // 1
        int res3 = solution.maxSubArray(a3);
        System.out.println("res3 = " + res3); // 23
        int res4 = solution.maxSubArray(a4);
        System.out.println("res4 = " + res4); // 1
        int res5 = solution.maxSubArray(a5);
        System.out.println("res5 = " + res5);
    }
}
