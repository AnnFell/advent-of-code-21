package adventOfCode;

import utils.InputParser;

import java.util.ArrayList;

public class Day03 extends PuzzleDay {
    private boolean partOneSolved = true;
    private boolean partTwoSolved;
    private boolean useTestInput;

    @Override
    public boolean isPartOneSolved() {
        return partOneSolved;
    }

    @Override
    public boolean isPartTwoSolved() {
        return partTwoSolved;
    }

    @Override
    boolean getUseTestInput() {
        return useTestInput;
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
        return 0;
    }
}
