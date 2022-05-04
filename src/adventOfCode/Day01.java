package adventOfCode;

import utils.InputParser;

import java.util.ArrayList;

public class Day01 extends PuzzleDay {
    private boolean partOneSolved = true;
    private boolean partTwoSolved = true;
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
        // parse input
        int[] sonarData = InputParser.inputToIntArray(input);

        // count increases
        int measurement = sonarData[0];
        int increases = 0;
        for (int line : sonarData) {
            if (line > measurement) {
                increases++;
            }
            measurement = line;
        }
        return increases;
    }

    @Override
    public long getSolutionPartTwo(ArrayList<String> input) {
        // parse input
        int[] sonarData = InputParser.inputToIntArray(input);

        // count increases in windows of 3 data points
        int increases = 0;
        for (int i = 0; i < (sonarData.length - 3); i++) {
            int firstWindow = sonarData[i] + sonarData[i + 1] + sonarData[i + 2];
            int secondWindow = sonarData[i + 1] + sonarData[i + 2] + sonarData[i + 3];
            if (firstWindow < secondWindow) {
                increases++;
            }
        }

        return increases;
    }
}
