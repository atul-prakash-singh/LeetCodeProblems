package datastructures.bitwise;

public class ComputeSquareRoot {

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

    private static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
