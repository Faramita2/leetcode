package com.wanyi.median;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = m;

        while (lo <= hi) {
            int i = (hi + lo) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftI = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int maxLeftJ = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightI = i == m ? Integer.MAX_VALUE : nums1[i];
            int minRightJ = j == n ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftI > minRightJ) {
                hi = i - 1;
            } else if (maxLeftJ > minRightI) {
                lo = i + 1;
            } else {
                int maxLeft = Math.max(maxLeftI, maxLeftJ);
                int minRight = Math.min(minRightI, minRightJ);
                if ((n + m) % 2 == 1) {
                    return maxLeft;
                }
                return (double) (maxLeft + minRight) / 2;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums2 = {2};
        int[] nums1 = {1, 3};

        Solution median = new Solution();
        double res = median.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
