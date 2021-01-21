package datastructures.array;

import java.util.Arrays;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/
public class MaxNumberKSumPairs {

    public static void main(String[] args) {

    }

    private static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0; int r = nums.length - 1;
        int res = 0;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                res ++;
                l ++;
                r --;
            } else if (nums[l] + nums[r] < k) {
                l++;
            } else {
                r --;
            }
        }
        return res;
    }
}
