package com.vinod.expense8puzzle.models;

import com.vinod.expense8puzzle.solver.PuzzleSolver;

import java.io.FileNotFoundException;
import java.util.Arrays;

public record PuzzleInput(PuzzleState startState, Grid goal, SearchAlgorithm searchAlgorithm) {

    // to parse and validate input arguments
    public static PuzzleInput parseArgs(String[] args) throws FileNotFoundException {

        // 1. Check if there are at least 2 input arguments
        if (args.length < 2){
            throw new IllegalArgumentException("Need 2 arguments, start state and goal state files");
        }

        // 2. Assigning arguments to variables for further computing
        String startFile = args[0];
        String goalFile = args[1];

        // if args[2] is not present, default to BFS
        String algorithm = args.length > 2 ? args[2] : "BFS";

        // 3. Validate and parse files into 2D array puzzle states
        PuzzleState startState = PuzzleState.start(Grid.parseTextFileToGrid(startFile));
        Grid goal = Grid.parseTextFileToGrid(goalFile);

        // 4. validate algorithm argument using Search Algorithm enum (pre defined constants)
        SearchAlgorithm searchAlgorithm = SearchAlgorithm.from(algorithm);

        // return the immutable input object
        return new PuzzleInput(startState, goal, searchAlgorithm);
    }

    // Method to create the right solver according to input
    public PuzzleSolver createSolver() {
        return searchAlgorithm.createSolver(startState, goal);
    }

    @Override
    public String toString() {
        return "PuzzleInput{" +
                "startState=" + startState +
                ", goal=" + Arrays.deepToString(goal.toArray()) +
                ", searchAlgorithm=" + searchAlgorithm +
                '}';
    }
}
