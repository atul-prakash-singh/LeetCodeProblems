package datastructures.bitwise;

//https://leetcode.com/problems/sum-of-two-integers/
public class SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }

    private static int getSum(int a, int b) {
        return a == 0 ? b : getSum((a & b) << 1, a ^ b);
    }

    private static int getSumI(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return getSum((a & b) << 1, a ^ b);
        }
    }
}
