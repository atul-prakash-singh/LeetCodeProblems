package datastructures.array;

//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleNonDuplicateElementInSortedArray {

    public static void main(String[] args) {

        int[] input = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(input));
    }

    //Time - O(N), Space - O(1)
    public static int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    //Time - O(logN), Space - O(1)
    public int singleNonDuplicateBinarySearch(int[] nums) {
        int low = 0;
        int high = nums.length / 2;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[2 * low];
    }
}
