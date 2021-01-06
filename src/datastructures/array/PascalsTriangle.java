package datastructures.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {

    public static void main(String[] args) {

    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last
            result.add(cur);
            pre = cur;
        }
        return result;
    }
}
