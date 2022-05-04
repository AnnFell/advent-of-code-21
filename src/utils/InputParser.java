package utils;

import java.util.ArrayList;

public class InputParser {
    public static int[] inputToIntArray(ArrayList<String> input) {
        int[] intArray = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            intArray[i] = Integer.parseInt(input.get(i));
        }
        return intArray;
    }
}
