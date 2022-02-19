package com.wanyi.longest.palindromesubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return s;
        int n = s.length();
        if (n < 2) return s;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandCenterPalindrome(s, i, i);
            int len2 = expandCenterPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandCenterPalindrome(String s, int j, int k) {
        while (j >=0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        return k - j - 1;
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
