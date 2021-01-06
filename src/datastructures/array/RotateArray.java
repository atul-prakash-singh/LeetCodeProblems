package datastructures.array;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(input, k);
    }

    private static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
