package com.vinod.expense8puzzle;

import com.vinod.expense8puzzle.models.PuzzleInput;


import com.vinod.expense8puzzle.solver.PuzzleSolver;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Step 1: Validate and parse input arguments
        PuzzleInput input = PuzzleInput.parseArgs(args);

       // Step 2: Solve the puzzle - solve()
       PuzzleSolver solver = input.createSolver();

       // Step 3: solve
       solver.solve();

    }
}
