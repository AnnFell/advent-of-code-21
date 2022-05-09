package adventOfCode;

import utils.InputParser;

import java.util.ArrayList;
import java.util.Arrays;

public class Day03 extends PuzzleDay {
    public Day03() {
        setPartOneSolved(true);
        setPartTwoSolved(true);
    }

    @Override
    public long getSolutionPartOne(ArrayList<String> input) {
        ArrayList<int[]> diagnostics = InputParser.inputToListOfIntArrays(input);

        StringBuilder gammaString = new StringBuilder();

        // for every column
        for (int i = 0; i < diagnostics.get(0).length; i++) {

            // find most common value in each column
            int count1 = 0;
            int count0 = 0;
            for (int[] dataLine : diagnostics) {
                if (dataLine[i] == 1) {
                    count1++;
                } else {
                    count0++;
                }
            }
            int mostCommonValue = count1 > count0 ? 1 : 0;

            // set corresponding value in gamma
            gammaString.append(mostCommonValue);
        }

        // get epsilon value (inverted gamma value)
        StringBuilder epsilonString = new StringBuilder();
        for (int i = 0; i < gammaString.length(); i++) {
            epsilonString.append(gammaString.charAt(i) == '1' ? 0 : 1);
        }

        // convert binary string to value
        long gammaValue = Long.parseLong(gammaString.toString(), 2);
        long epsilonValue = Long.parseLong(epsilonString.toString(), 2);

        return gammaValue * epsilonValue;
    }

    @Override
    public long getSolutionPartTwo(ArrayList<String> input) {
        ArrayList<int[]> diagnostics = InputParser.inputToListOfIntArrays(input);

        int[] oxygenGeneratorArray = filterMyList(diagnostics, 0, true);
        int[] co2ScrubberArray = filterMyList(diagnostics, 0, false);

        // convert array to string
        StringBuilder oxy = new StringBuilder();
        for (int value : oxygenGeneratorArray) {
            oxy.append(value);
        }
        StringBuilder co2 = new StringBuilder();
        for (int value : co2ScrubberArray) {
            co2.append(value);
        }

        // convert binary string to value
        long oxygenGeneratorValue = Long.parseLong(oxy.toString(), 2);
        long co2ScrubberValue = Long.parseLong(co2.toString(), 2);

        return oxygenGeneratorValue * co2ScrubberValue;
    }

    private int[] filterMyList(ArrayList<int[]> input, int index, boolean greaterThan) {
        // find most common value in column corresponding to index
        int count1 = 0;
        int count0 = 0;
        for (int[] dataLine : input) {
            if (dataLine[index] == 1) {
                count1++;
            } else {
                count0++;
            }
        }

        // use value to determine filter
        int filter;
        if (greaterThan) {
            filter = count1 >= count0 ? 1 : 0;
        } else {
            filter = count1 < count0 ? 1 : 0;
        }

        // keep only the arrays that have filter value at index
        ArrayList<int[]> filteredList = new ArrayList<>();
        for (int[] dataLine : input) {
            if (dataLine[index] == filter) {
                filteredList.add(dataLine);
            }
        }

        // repeat process until only one value remains
        if (filteredList.size() > 1) {
            int newIndex = index + 1;
            return filterMyList(filteredList, newIndex, greaterThan);
        } else {
            return filteredList.get(0);
        }
    }
}
