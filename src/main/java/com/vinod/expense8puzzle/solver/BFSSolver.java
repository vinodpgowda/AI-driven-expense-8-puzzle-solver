package com.vinod.expense8puzzle.solver;

import com.vinod.expense8puzzle.models.PuzzleState;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import static com.vinod.expense8puzzle.utils.StateUtils.serializeState;

public class BFSSolver extends PuzzleSolver{

    // Queue fringe for BFS -> traversal level wise, breadth wise
    private Queue<PuzzleState> fringe;

    // constructor, call super class constructor for states and initialize fringe
    public BFSSolver(int[][] startState, int[][] goalState){
        super(startState, goalState);
        this.fringe = new LinkedList<>();
        this.fringe.add(startPuzzleState);
    }

    // Implement abstract method solve()
    // goes through the Fringe, and check if the current state is the goal state or not
    // if not, explore its neighbours and add to the fringe
    // continues checking until goal reached (success) or fringe is empty(failure)

    @Override
    public void solve(){

        while(!fringe.isEmpty()){

            // Pop the current state from the fringe
            PuzzleState currentPuzzleState = fringe.poll();

            // Increment nodesPopped counter
            nodesPopped++;

            // Check if current Puzzle State is the goal state
            if (isGoalReached(currentPuzzleState.getState())){

                // Yes -> goal reached - End of while loop
                System.out.println("The goal has reached at the depth "
                        + currentPuzzleState.getDepth() + " with cost " + currentPuzzleState.getCost());
                System.out.println(currentPuzzleState.getPath());
                return;

            } else { // If goal is not reached

                // serialize the 2d array state to string for better comparison
                String serializedCurrentState = serializeState(currentPuzzleState.getState());

                // Check if current serialized state is unexplored - not in the visitedStates set
                if (!visitedStates.contains(serializedCurrentState)){

                    // Not visited -> add current serialized state to the visitedStates
                    visitedStates.add(serializedCurrentState);

                    // Expand current state and add its neighbours to Fringe
                    expandState(currentPuzzleState);

                    // Increment the nodes expanded counter
                    nodesExpanded++;
                }
            }
            // If no states left in the fringe - no solution, end of solve()
        }
    }

    @Override
    public void addToFringe(List<PuzzleState> successorStates){

        // Increment the nodes generated counter by number of successor states
        nodesGenerated += successorStates.size();
        fringe.addAll(successorStates);
    }
}




