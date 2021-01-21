package datastructures.array;

//https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveInteger {

    public static void main(String[] args) {
        int[] input = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(input, k));
    }

    private static int findKthPositive(int[] arr, int k) {
        for(int i : arr) {
            if(i <= k) {
                k++;
            }
        }
        return k;
    }
}
