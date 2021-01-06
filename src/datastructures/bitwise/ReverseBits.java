package datastructures.bitwise;

//https://leetcode.com/problems/reverse-bits/
public class ReverseBits {

    public static void main(String[] args) {
        String n = "00000010100101000001111010011100";

        System.out.println(Integer.toBinaryString(reverseBits(Integer.parseUnsignedInt(n, 2))));
    }

    private static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    private static int reverseBitsI(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int curr = n & 1;
            n >>>= 1;
            result <<= 1;
            result += curr;
        }
        return result;
    }
}
