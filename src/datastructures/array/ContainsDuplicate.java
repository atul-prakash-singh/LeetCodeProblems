package datastructures.array;

import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println(containsDuplicate(input));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }
}
