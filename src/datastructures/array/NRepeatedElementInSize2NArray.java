package datastructures.array;

import java.util.HashSet;

//https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
public class NRepeatedElementInSize2NArray {

    public static void main(String[] args) {

    }

    private static int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}
