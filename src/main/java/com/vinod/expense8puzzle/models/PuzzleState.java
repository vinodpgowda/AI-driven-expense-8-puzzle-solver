package com.vinod.expense8puzzle.models;

import java.util.Arrays;

public record PuzzleState(Grid grid, int cost, int depth, String path) {

    // method to create start state to encapsulate and abstract
    public static PuzzleState start(Grid grid) {
        return new PuzzleState(grid, 0, 0, "");
    }

    //
    @Override
    public String toString() {
        return "grid=" + Arrays.deepToString(grid.toArray()) +
                ", cost=" + cost +
                ", depth=" + depth +
                ", path=" + path +
                '}';
    }
}
