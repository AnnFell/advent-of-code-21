package adventOfCode;

import java.util.ArrayList;

public class Day02 extends PuzzleDay {
    public Day02(){
        setPartOneSolved(true);
        setPartTwoSolved(true);
    }

    @Override
    public long getSolutionPartOne(ArrayList<String> input) {
        int horizontal = 0;
        int depth = 0;

        for (String direction : input) {
            int value = Integer.parseInt(direction.substring(direction.length() - 1));

            if (direction.contains("forward")) {
                horizontal += value;
            } else if (direction.contains("down")) {
                depth += value;
            } else if (direction.contains("up")) {
                depth -= value;
            }
        }

        return (long) horizontal * depth;
    }

    @Override
    public long getSolutionPartTwo(ArrayList<String> input) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String direction : input) {
            int value = Integer.parseInt(direction.substring(direction.length() - 1));

            if (direction.contains("forward")) {
                horizontal += value;
                depth += (aim * value);
            } else if (direction.contains("down")) {
                aim += value;
            } else if (direction.contains("up")) {
                aim -= value;
            }
        }

        return (long) horizontal * depth;
    }
}
