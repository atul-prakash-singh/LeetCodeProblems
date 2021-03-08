package datastructures.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(input));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0) {
            return list;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j ++) {
                list.add(matrix[rowStart][j]);
            }
            rowStart++;

            for (int j = rowStart; j <= rowEnd; j ++) {
                list.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j --) {
                    list.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int j = rowEnd; j >= rowStart; j --) {
                    list.add(matrix[j][colStart]);
                }
            }
            colStart ++;
        }
        return list;
    }
}

