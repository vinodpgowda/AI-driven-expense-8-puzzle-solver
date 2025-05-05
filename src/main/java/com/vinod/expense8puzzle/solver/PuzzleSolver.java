package com.vinod.expense8puzzle.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vinod.expense8puzzle.models.Grid;
import com.vinod.expense8puzzle.models.PuzzleState;

public abstract class PuzzleSolver {

    protected PuzzleState startState;
    protected Grid goal;
    protected PuzzleState solutionState;
    protected int nodesPopped;
    protected int nodesExpanded;
    protected int nodesGenerated;
    protected int maxFringeSize;
    protected Set<String> visitedStates = new HashSet<>();

    // PuzzleSolver Constructor - takes start state, goal state
    public PuzzleSolver(PuzzleState startState, Grid goal){
        this.startState = startState;
        this.goal = goal;
        this.nodesPopped = 0;
        this.nodesExpanded = 0;
        this.nodesGenerated = 0;
    }

    //  Abstract solve() method specific for each subclass
    public abstract void solve();

    // Check if the current state is the goal state (goal reached?)
    public boolean isGoalReached(PuzzleState currentState){
        return Arrays.deepEquals(currentState.grid().toArray(), goal.toArray());
    }

    // implement generate
    public List<PuzzleState> generateSuccessors(PuzzleState currentState) {

        List<PuzzleState> successors = new ArrayList<>();

        Grid currentGrid = currentState.grid();
        int[] emptyTilePosition = currentGrid.getEmptyTileLocation();

        for (Move move : Move.values()) {
            int[] targetTilePosition = move.getTargetPosition(emptyTilePosition);

            if (Grid.isInBounds(targetTilePosition)) {
                Grid newGrid = currentGrid.swap(emptyTilePosition, targetTilePosition);
                String newPath = currentState.path() + "\nMove " + currentGrid.get(targetTilePosition) + " " + move.getLabel();
                PuzzleState nextState = new PuzzleState(newGrid, currentState.cost() + currentGrid.get(targetTilePosition), currentState.depth() + 1, newPath);
                successors.add(nextState);
            }
        }
        return successors;
    }

    @Override
    public String toString() {
        return "\nNodes Popped: " + nodesPopped + "\n" +
                "Nodes Expanded: " + nodesExpanded + "\n" +
                "Nodes Generated: " + nodesGenerated + "\n" +
                "Max Fringe Size: " + maxFringeSize + "\n" +
                "Solution found at depth " + solutionState.depth() + " with cost of " + solutionState.cost() + ".\n" +
                "\nSteps: " + solutionState.path();
    }
}

