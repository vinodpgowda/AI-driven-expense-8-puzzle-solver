package com.vinod.expense8puzzle.solver;

import com.vinod.expense8puzzle.models.PuzzleState;
import com.vinod.expense8puzzle.solver.PuzzleSolver;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSSolver extends PuzzleSolver{

    private Queue<int[][]> fringe;

    // 1: constructor, call super class constructor for states and initialize fringe
    public DFSSolver(int[][] startState, int[][] goalState){
        super(startState, goalState);
        this.fringe = new LinkedList<>();
    }

    @Override
    public void solve(){
        System.out.println("this is DFS method");
    }

    @Override
    public void addToFringe(List<PuzzleState> successorStates) {

    }
}
