package datastructures.array;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(search(input, target));
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}