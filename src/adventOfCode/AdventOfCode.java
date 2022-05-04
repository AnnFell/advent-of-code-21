package adventOfCode;

import utils.PuzzleScanner;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdventOfCode {
    public static void main(String[] args) throws FileNotFoundException {
        boolean runAll = true;
        int workingOnDay = 2;

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
            int currentDay = i + 1;
            printResultsOfDay(days, currentDay);
        }
    }

    private static void printResultsOfDay(ArrayList<PuzzleDay> days, int workingDay) throws FileNotFoundException {
        PuzzleDay currentDay = days.get(workingDay - 1);

        if (currentDay.isPartOneSolved() || currentDay.isPartTwoSolved()) {
            System.out.println("\u001B[1mResult for Day " + workingDay + "\u001B[0m");

            ArrayList<String> puzzleInput = PuzzleScanner.getPuzzleInput(workingDay, currentDay.getUseTestInput());
            if (currentDay.isPartOneSolved()) {
                System.out.printf("Part one: " +
                        "the solution is %d%n", currentDay.getSolutionPartOne(puzzleInput));
            }

            if (currentDay.isPartOneSolved()) {
                System.out.printf("Part two: " +
                        "the solution is %d%n", currentDay.getSolutionPartTwo(puzzleInput));
            }
            System.out.println("------");
        }
    }
}
