package adventOfCode;

import java.util.ArrayList;

public abstract class PuzzleDay {
    private boolean partOneSolved;
    private boolean partTwoSolved;
    private boolean useTestInput;

    protected boolean isPartOneSolved() {
        return partOneSolved;
    }

    protected void setPartOneSolved(boolean partOneSolved) {
        this.partOneSolved = partOneSolved;
    }

    protected boolean isPartTwoSolved() {
        return partTwoSolved;
    }

    protected void setPartTwoSolved(boolean partTwoSolved) {
        this.partTwoSolved = partTwoSolved;
    }

    protected boolean getUseTestInput() {
        return useTestInput;
    }

    protected void setUseTestInput(boolean useTestInput) {
        this.useTestInput = useTestInput;
    }

    abstract long getSolutionPartOne(ArrayList<String> input);

    abstract long getSolutionPartTwo(ArrayList<String> input);
}
