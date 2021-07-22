package datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AscendingBinarySorting {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(3);
        input.add(7);
        input.add(10);
        input.add(14);

        System.out.println(rearrange(input));
    }

    public static List<Integer> rearrange(List<Integer> elements) {
        int[] elementsArray = new int[elements.size()];
        for (int i = 0; i < elementsArray.length; i++) {
            elementsArray[i] = elements.get(i);
        }
        Integer[] outputArray = new Integer[elements.size()];
        for (int i = 0; i < outputArray.length; ++i) {
            outputArray[i] = elementsArray[i];
        }
        Arrays.sort(outputArray, Comparator.comparing(i -> Integer.bitCount(i) * 10000 + i));
        for (int i = 0; i < outputArray.length; ++i) {
            elementsArray[i] = outputArray[i];
        }
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < outputArray.length; ++i) {
            output.add(elementsArray[i]);
        }
        return output;
    }
}
