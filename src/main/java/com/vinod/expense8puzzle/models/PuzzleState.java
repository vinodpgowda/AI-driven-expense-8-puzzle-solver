package com.vinod.expense8puzzle.models;

import java.util.ArrayList;
import java.util.List;

import static com.vinod.expense8puzzle.utils.StateUtils.deepCopy;

public class PuzzleState {

    public int[][] getState() {
        return state;
    }

    public int getDepth() {
        return depth;
    }

    public int getCost() {
        return cost;
    }

    public List<String> getPath(){
        return path;
    }


    private final int[][] state;
    private final int depth;
    private final int cost;
    private final List<String> path;

    // constructor 1
    public PuzzleState(int[][] state, int depth, int cost){
        this.state = deepCopy(state);
        this.depth = depth;
        this.cost = cost;
        this.path = new ArrayList<>();
    }

    // constructor 2
    public PuzzleState(int[][] state, int depth, int cost, List<String> path){
        this.state = deepCopy(state);
        this.depth = depth;
        this.cost = cost;
        this.path = new ArrayList<>(path);
    }
}
