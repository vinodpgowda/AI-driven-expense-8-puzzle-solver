package com.vinod.expense8puzzle.solver;

import com.vinod.expense8puzzle.models.Grid;
import com.vinod.expense8puzzle.models.PuzzleState;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BFSSolver extends PuzzleSolver{

    protected Queue<PuzzleState> fringe = new LinkedList<>();

    public BFSSolver(PuzzleState startState, Grid goal) {
        super(startState, goal);
        fringe.add(startState);
    }

    // Implement abstract method solve()
    @Override
    public void solve() {
        System.out.println("Solving Puzzle using Breadth First Search Algorithm");

        // Step 1: Keep searching until Fringe is empty
        while (!fringe.isEmpty()) {

            // Check for max fringe size
            maxFringeSize = Math.max(fringe.size(), maxFringeSize);

            // Pop the current state and check if goal is reached
            PuzzleState currentState = fringe.poll();

            // increment nodes popped
            nodesPopped++;

            // If goal, return
            if (isGoalReached(currentState)){

                solutionState = currentState;
                System.out.println(this);
                return;
            }

            // If goal is not reached, check if it has been explored or not
            if (visitedStates.add(Arrays.deepToString(currentState.grid().toArray()))) {

                // increment nodes expanded
                nodesExpanded++;

                // if not explored, expand it and get successor states
                List<PuzzleState> successorStates = generateSuccessors(currentState);

                // increment nodes generated
                nodesGenerated += successorStates.size();

                // add the successor states to the queue
                fringe.addAll(successorStates);
            }
        }
    }
}




