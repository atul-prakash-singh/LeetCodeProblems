package datastructures.array;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public static void main(String[] args) {
        int[] input = {3, 0, 1};
        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return N * (N + 1) / 2 - sum;
    }
}
