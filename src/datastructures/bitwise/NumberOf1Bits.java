package datastructures.bitwise;

//https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int result = 0;
        for (int i = 1; i <= Integer.SIZE; i++) {
            result += (n & 1);
            n = n >> 1;
        }
        return result;
    }

    private static int hammingWeightI(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
