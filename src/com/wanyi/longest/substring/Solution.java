package com.wanyi.longest.substring;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int maxStart = 0, maxEnd = 0, curStart = 0, curEnd = 0;
        StringBuilder looked = new StringBuilder(s.substring(0, 1));


        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (looked.toString().indexOf(c) == -1) {
                curEnd++;
                looked.append(c);
            } else {
                if (curEnd - curStart > maxEnd - maxStart) {
                    maxStart = curStart;
                    maxEnd = curEnd;
                }
                int p = looked.toString().indexOf(c);
                String re = looked.substring(p + 1);
                curStart = p + 1;
                curEnd = p + re.length();
                looked = new StringBuilder(re + c);
                curEnd++;
            }
        }

        if (curEnd - curStart > maxEnd - maxStart) {
            maxStart = curStart;
            maxEnd = curEnd;
        }


        return maxEnd - maxStart + 1;
    }

    public static void main(String[] args) {
        String s1 = "dvdf";
        String s2 = "au";
        String s3 = "dvabcdf";

        Solution longest = new Solution();
        System.out.println(longest.lengthOfLongestSubstring(s1));
        System.out.println(longest.lengthOfLongestSubstring(s2));
        System.out.println(longest.lengthOfLongestSubstring(s3));
    }
}
