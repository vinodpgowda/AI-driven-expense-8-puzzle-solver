package com.vinod.expense8puzzle.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.vinod.expense8puzzle.models.PuzzleState;
import static com.vinod.expense8puzzle.utils.StateUtils.getEmptyTileLocation;
import static com.vinod.expense8puzzle.utils.StateUtils.getValidMoves;
import static com.vinod.expense8puzzle.utils.StateUtils.deepCopy;

public abstract class PuzzleSolver {

    protected PuzzleState startPuzzleState;
    protected int[][] goalState;
    protected int nodesPopped;
    protected int nodesExpanded;
    protected int nodesGenerated;

    // Maintain a Set to keep track of serialized visited states
    Set<String> visitedStates = new HashSet<>();

    // PuzzleSolver Constructor - takes start state, goal state
    public PuzzleSolver(int[][] startState, int[][] goalState){
        this.startPuzzleState = new PuzzleState(startState, 0, 0);
        this.goalState = goalState;
    }

    //  Abstract solve() method specific for each subclass
    //      goes through the Fringe, and check if the current state is the goal state or not
    //      if not, explore its neighbours and add to the fringe
    //      continues checking until goal reached (success) or fringe is empty(failure)
    public abstract void solve();


    // Check if the current state is the goal state (goal reached?)
    public boolean isGoalReached(int[][] currentState){
        return Arrays.deepEquals(currentState, goalState);
    }

    // Expand current unexplored state
    public void expandState(PuzzleState currentPuzzleState) {
        int[][] currentState = currentPuzzleState.getState();

        // 1: Locate the position of the empty tile
        int[] emptyTilePosition = getEmptyTileLocation(currentState);

        // 2: Determine valid moves - Up, Right, Down, Left
        List<String> validMoves = getValidMoves(emptyTilePosition);

        // 3: Generate neighboring states with metadata
        List<PuzzleState> successorStates = generateSuccessorStates(currentPuzzleState, emptyTilePosition, validMoves);

        // 4: Add generated states to the fringe
        this.addToFringe(successorStates);
    }

    // Generate successor/neighbour states for current unexplored state
    public static List<PuzzleState> generateSuccessorStates(PuzzleState currentPuzzleState, int[] emptyTilePosition, List<String> validMoves){

        List<PuzzleState>successorStates = new ArrayList<>();

        int i = emptyTilePosition[0];
        int j = emptyTilePosition[1];

        int[][] currentState = currentPuzzleState.getState();
        int depth = currentPuzzleState.getDepth();
        int cost = currentPuzzleState.getCost();

        for (String move : validMoves){
            int[][] newState = deepCopy(currentState);
            switch (move) {
                case "Up" -> {
                    newState[i][j] = currentState[i-1][j];
                    newState[i-1][j] = 0;
                }
                case "Right" -> {
                    newState[i][j] = currentState[i][j+1];
                    newState[i][j+1] = 0;
                }
                case "Down" -> {
                    newState[i][j] = currentState[i+1][j];
                    newState[i+1][j] = 0;
                }
                case "Left" -> {
                    newState[i][j] = currentState[i][j-1];
                    newState[i][j-1] = 0;
                }
            }

            List<String> newPath = new ArrayList<>(currentPuzzleState.getPath());
            newPath.add(move);
            successorStates.add(new PuzzleState(newState, depth + 1, cost+newState[i][j], newPath));
        }
        return successorStates;
    }

    // 8: Abstract method to accommodate adding states to different type of fringe data structure
    public abstract void addToFringe(List<PuzzleState> successorStates);

    // Return results together
    public Map<String, Integer> getResults(){
        Map<String, Integer> results = new HashMap<>();
        results.put("Nodes Popped", nodesPopped);
        results.put("Nodes Expanded", nodesExpanded);
        results.put("Nodes Generated", nodesGenerated);

        return results;
    }
}

