package adventOfCode;

import java.util.ArrayList;

public abstract class PuzzleDay {
    abstract boolean isPartOneSolved();

    abstract boolean isPartTwoSolved();

    abstract boolean getUseTestInput();

    abstract long getSolutionPartOne(ArrayList<String> input);

    abstract long getSolutionPartTwo(ArrayList<String> input);
}
