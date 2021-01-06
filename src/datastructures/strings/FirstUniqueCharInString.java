package datastructures.strings;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharInString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqueChar(s));
    }

    private static int firstUniqueChar(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for( char c : chars ) {
            charCount[c-'a']++;
        }
        for( int i=0; i<chars.length; i++ ) {
            if( charCount[chars[i]-'a']==1 ) {
                return i;
            }
        }
        return -1;
    }
}
