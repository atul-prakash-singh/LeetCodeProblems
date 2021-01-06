package datastructures.array;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class PlusOne {

    public static void main(String[] args) {
        int[] input = {9,9,9};
        System.out.println(Arrays.toString(plusOne(input)));
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else if (digits[i] == 9) {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}
