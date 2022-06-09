package com.wanyi.zigzagconversion;

public class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows) return s;


        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "PAYPALISHIRING";
        String res1 = solution.convert(s1, 3);
        // P   A   H   N
        // A P L S I I G
        // Y   I   R
        System.out.println("res1 = " + res1);
        String res2 = solution.convert(s1, 4);
        // P     I    N
        // A   L S  I G
        // Y A   H R
        // P     I
        System.out.println("res2 = " + res2);
        String s2 = "a";
        String res3 = solution.convert(s2, 1);
        System.out.println("res3 = " + res3);
    }
}
