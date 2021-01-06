package datastructures.array;

//https://leetcode.com/problems/transpose-matrix/
public class TransposeMatrix {

    public static void main(String[] args) {

    }

    private static int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
