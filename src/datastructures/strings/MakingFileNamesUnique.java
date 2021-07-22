package datastructures.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/making-file-names-unique/
public class MakingFileNamesUnique {

    public static void main(String[] args) {
        String[] input = {"kaido","kaido(1)","kaido","kaido(1)"};
        System.out.println(Arrays.toString(getFolderNames(input)));
    }

    public static String[] getFolderNames(String[] names) {
        Map<String, Integer> nameCount = new HashMap<>(names.length);

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String newName = name;
            int count = nameCount.getOrDefault(newName, 0);

            while (nameCount.containsKey(newName)) {
                newName = name + "(" + count + ")";
                count++;
            }

            names[i] = newName;
            nameCount.put(name, count);
            nameCount.put(newName, 1);
        }

        return names;
    }
}
