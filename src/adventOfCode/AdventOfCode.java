package adventOfCode;

import utils.PuzzleScanner;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdventOfCode {
    public static void main(String[] args) throws FileNotFoundException {
        boolean runAll = false;
        int workingOnDay = 1;

        // ArrayList of days
        ArrayList<PuzzleDay> days = new ArrayList<>();
        days.add(new Day01());
        days.add(new Day02());
        days.add(new Day03());

        if (runAll) {
            printAllResults(days);
        } else {
            printResultsOfDay(days, workingOnDay);
        }
    }

    private static void printAllResults(ArrayList<PuzzleDay> days) throws FileNotFoundException {
        for (int i = 0; i < days.size(); i++) {
            PuzzleDay currentDay = days.get(i);

            if (currentDay.isPartOneSolved() || currentDay.isPartTwoSolved()) {
                ArrayList<String> puzzleInput = PuzzleScanner.getPuzzleInput(i + 1, currentDay.getUseTestInput());
                System.out.println("Result for Day " + i);

                if (currentDay.isPartOneSolved()) {
                    System.out.printf("Part one:" +
                            "\nThe solution is: %d%n", currentDay.getSolutionPartOne(puzzleInput));
                }

                if (currentDay.isPartOneSolved()) {
                    System.out.printf("Part two:" +
                            "\nThe solution is: %d%n", currentDay.getSolutionPartTwo(puzzleInput));
                }
            }
        }
    }

    private static void printResultsOfDay(ArrayList<PuzzleDay> days, int workingDay) throws FileNotFoundException {
        PuzzleDay currentDay = days.get(workingDay - 1);
        ArrayList<String> puzzleInput = PuzzleScanner.getPuzzleInput(workingDay, currentDay.getUseTestInput());

        if (currentDay.isPartOneSolved() || currentDay.isPartTwoSolved()) {
            System.out.println("Result for Day " + workingDay);

            if (currentDay.isPartOneSolved()) {
                System.out.printf("Part one:" +
                        "\nThe solution is: %d%n", currentDay.getSolutionPartOne(puzzleInput));
            }

            if (currentDay.isPartOneSolved()) {
                System.out.printf("Part two:" +
                        "\nThe solution is: %d%n", currentDay.getSolutionPartTwo(puzzleInput));
            }
        }
    }
}
