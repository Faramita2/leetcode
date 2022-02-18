package com.wanyi.longest.palindromesubstring;

public class Solution {
    public String longestPalindrome(String s) {
        return null;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";

        Solution solution = new Solution();
        String res1 = solution.longestPalindrome(s1);
        System.out.println("res1 = " + res1);
        String res2 = solution.longestPalindrome(s2);
        System.out.println("res2 = " + res2);
    }
}
