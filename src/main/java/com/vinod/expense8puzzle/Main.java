package com.vinod.expense8puzzle;

import com.vinod.expense8puzzle.solver.BFSSolver;
import com.vinod.expense8puzzle.solver.DFSSolver;
import com.vinod.expense8puzzle.solver.UCSSolver;
import com.vinod.expense8puzzle.solver.PuzzleSolver;
import com.vinod.expense8puzzle.utils.StateUtils;
import static com.vinod.expense8puzzle.utils.InputUtils.validateInput;
import static com.vinod.expense8puzzle.utils.InputUtils.findAlgorithm;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {
            // Step 1: Validate input arguments
            validateInput(args);

            // Step 2: Parse text files into 2D array start and goal states
            int[][] startState = StateUtils.parse(args[0]);
            int[][] goalState = StateUtils.parse(args[1]);

            // Step 3: Find the right algorithm
            String algorithm = findAlgorithm(args);

            // Step 4: Instantiate Right Algorithm PuzzleSolver
            PuzzleSolver puzzleSolver = switch (algorithm) {
                case "DFS" -> new DFSSolver(startState, goalState);
                case "UCS" -> new UCSSolver(startState, goalState);
                default -> new BFSSolver(startState, goalState);
            };

            // Step 5: Solve the puzzle - solve()
            puzzleSolver.solve();

            // Step 6: Print the results
            System.out.println(puzzleSolver.getResults());

        } catch (IllegalArgumentException e){
            System.out.println("Input Validation Error: " + e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("File Not Found Error: " + e.getMessage());
        }
    }
}
