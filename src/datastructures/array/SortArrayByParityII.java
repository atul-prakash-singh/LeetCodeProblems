package datastructures.array;

import java.util.Arrays;

//https://leetcode.com/problems/sort-array-by-parity-ii/
public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] input = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(input)));
    }

    private static int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[evenIndex] = A[i];
                evenIndex += 2;
            } else {
                result[oddIndex] = A[i];
                oddIndex += 2;
            }
        }
        return result;
    }
}
