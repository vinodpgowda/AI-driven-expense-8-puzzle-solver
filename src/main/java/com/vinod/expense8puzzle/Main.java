package com.vinod.expense8puzzle;

import java.util.*;
import java.io.InputStream;

class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the start.txt and goal.txt files as arguments.");
            return;
        }

        String startFileName = args[0]; // First argument is the start file
        String goalFileName = args[1];  // Second argument is the goal file

        // Load the files from src/main/resources
        InputStream startFile = Main.class.getClassLoader().getResourceAsStream(startFileName);
        InputStream goalFile = Main.class.getClassLoader().getResourceAsStream(goalFileName);

        if (startFile == null || goalFile == null) {
            System.out.println("One or both files not found in resources.");
            return;
        }

        PuzzleSolver puzzleSolver = new PuzzleSolver(startFile, goalFile);

        int nodesPopped = 0;
        int nodesExpanded = 0;
        int nodesGenerated = 0;
        int maxFringeSize = 0;

        while(!puzzleSolver.getFringe().isEmpty()){
            if (puzzleSolver.getFringe().size() > maxFringeSize){
                maxFringeSize = puzzleSolver.getFringe().size();
            }
            int[][] currentState = puzzleSolver.getFringe().poll();
            nodesPopped++;
            if (puzzleSolver.isGoal(currentState)){
                System.out.println("Goal Reached");
                System.out.println("Nodes Popped: " + nodesPopped);
                System.out.println("Nodes Expanded: " + nodesExpanded);
                System.out.println("Nodes Generated: " + nodesGenerated);
                System.out.println("Maximum Fringe Size: " + maxFringeSize);
                    break;
            } else {
                String currentStateString = Arrays.deepToString(currentState);

                if (!puzzleSolver.getVisitedStates().contains(currentStateString)) {
                    puzzleSolver.getVisitedStates().add(currentStateString);
                    nodesExpanded++;
                    int expanded = puzzleSolver.generateSuccessorStates(currentState);
                    nodesGenerated += expanded;
                }
            }
        }
    }
}


class PuzzleSolver {

    private int[][] startState = new int[3][3];
    private int[][] goalState = new int[3][3];
    private Queue<int [][]> fringe = new LinkedList<>();
    private Set<String> visitedStates = new HashSet<>();

    public PuzzleSolver(InputStream startFile, InputStream goalFile) {
        System.out.println("Reading start file:");
        this.startState = loadStateFromFile(startFile);
        this.fringe.offer(startState);

        System.out.println("Reading goal file:");
        this.goalState = loadStateFromFile(goalFile);
    }

    // Getter for fringe
    public Queue<int[][]> getFringe() {
        return this.fringe;
    }

    // Getter for visitedStates
    public Set<String> getVisitedStates() {
        return this.visitedStates;
    }

    private int[][] loadStateFromFile(InputStream file) {
        int[][] state = new int[3][3];
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        state[i][j] = scanner.nextInt();
                    }
                }
            }
        }
        return state;
    }

    public boolean isGoal(int[][] currentState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentState[i][j] != this.goalState[i][j]) {
                    return false;
                }
            }
        }
        printState(currentState);
        return true;
    }

    public int generateSuccessorStates(int[][] currentState) {
        int expanded = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (currentState[i][j] == 0) {
                    if (i>0){
                       generateSuccessor(currentState, i, j, i-1, j);
                       expanded++;
                    }
                    if (i<2){
                        generateSuccessor(currentState, i, j, i+1, j);
                        expanded++;
                    }
                    if (j>0){
                        generateSuccessor(currentState, i, j, i, j-1);
                        expanded++;
                    }
                    if (j<2){
                        generateSuccessor(currentState, i, j, i, j+1);
                        expanded++;
                    }
                }
            }
        }
        return expanded;
    }

    private int[][] copyState(int [][] currentState){
        int[][] newState = new int[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                newState[i][j] = currentState[i][j];
            }
        }
        return newState;
    }

    private void generateSuccessor(int[][] currentState, int emptyRow, int emptyCol, int newRow, int newCol){
        int[][] successorState = copyState(currentState);
        successorState[emptyRow][emptyCol] = currentState[newRow][newCol];
        successorState[newRow][newCol] = currentState[emptyRow][emptyCol];
        this.fringe.add(successorState);
    }

    private void printState(int[][] state) {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(state[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void displayStates(){
        for (int [][] state: this.fringe){
            printState(state);
        }
    }
}

