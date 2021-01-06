package datastructures.array;

import java.util.Arrays;

//https://leetcode.com/problems/sort-array-by-parity/
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] input = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(input)));
    }

    private static int[] sortArrayByParity(int[] A) {
        int index = -1;
        int temp;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) { //alternative (A[i] % 2 == 0)
                index++;

                temp = A[i];
                A[i] = A[index];
                A[index] = temp;
            }
        }
        return A;
    }
}
