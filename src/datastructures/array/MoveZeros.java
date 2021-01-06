package datastructures.array;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeros {

    public static void main(String[] args) {
        int[] input = {0, 0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes(input)));
    }

    private static int[] moveZeroes(int[] nums) {
        int indexNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[indexNonZero++] = nums[i];
            }
        }

        while (indexNonZero < nums.length) {
            nums[indexNonZero++] = 0;
        }

        return nums;
    }
}
