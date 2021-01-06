package datastructures.array;

//https://leetcode.com/problems/single-number/
public class SingleNumber {

    public static void main(String[] args) {

    }

    private static int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
