package com.vinod.expense8puzzle.models;

import com.vinod.expense8puzzle.solver.BFSSolver;
import com.vinod.expense8puzzle.solver.PuzzleSolver;

import java.util.Arrays;

public enum SearchAlgorithm {
    BFS {
        @Override
        public PuzzleSolver createSolver(PuzzleState startState, Grid goal) {
            return new BFSSolver(startState, goal);
        }
    },
    DFS {
        @Override
        public PuzzleSolver createSolver(PuzzleState startState, Grid goal) {
            return new BFSSolver(startState, goal);
        }
    };

    public abstract PuzzleSolver createSolver(PuzzleState startState, Grid goal);

    public static SearchAlgorithm from(String input) {
        return Arrays.stream(values())
                .filter(algorithm -> algorithm.name().equalsIgnoreCase(input.trim()))
                .findFirst()
                .orElse(SearchAlgorithm.BFS);
    }
}
