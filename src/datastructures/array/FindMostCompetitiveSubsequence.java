package datastructures.array;

//https://leetcode.com/problems/find-the-most-competitive-subsequence/
public class FindMostCompetitiveSubsequence {

    public static void main(String[] args) {

    }

    private static int[] mostCompetitive(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int length = nums.length;
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < length; i++) {
            while (index > 0 && res[index-1] > nums[i] && (index+length-i) > k) {
                index--;
            }
            if (index < k) res[index++]= nums[i];
        }
        return res;
    }
}
