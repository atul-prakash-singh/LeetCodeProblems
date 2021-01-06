package datastructures.array;

//https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] input = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(input));
    }

    private static int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    private static int pivotIndexI(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int totalsum = 0, leftsum = 0;

        for (int i : nums) {
            totalsum += i;
        }

        for (int i = 0; i < n; i++) {
            if (leftsum == (totalsum - nums[i])) {
                return i;
            } else {
                leftsum += nums[i];
                totalsum -= nums[i];
            }
        }
        return -1;
    }
}
