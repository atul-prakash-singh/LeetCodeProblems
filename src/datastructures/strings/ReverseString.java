package datastructures.strings;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("Atul"));
    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        char temp;
        while (i < j) {
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
