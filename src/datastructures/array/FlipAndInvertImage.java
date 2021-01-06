package datastructures.array;

//https://leetcode.com/problems/flipping-an-image/
public class FlipAndInvertImage {

    public static void main(String[] args) {

    }

    private static int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][col - j - 1] = A[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] ^= 1;
            }
        }
        return result;
    }
}
