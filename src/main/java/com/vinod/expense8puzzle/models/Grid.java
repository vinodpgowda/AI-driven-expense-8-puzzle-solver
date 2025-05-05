package com.vinod.expense8puzzle.models;

import com.vinod.expense8puzzle.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public final class Grid{

    private final int[][] grid;

    public Grid(int[][] grid) {
        this.grid = Arrays.stream(grid) // Convert 2D state into a stream of rows
                .map(int[]::clone) // Clone each row using a lambda
                .toArray(int[][]::new);
    }

    public static Grid parseTextFileToGrid(String fileName) throws FileNotFoundException {

        // 1. check if the file is a text file or not
        if (!fileName.endsWith(".txt"))  {
            throw new IllegalArgumentException("Invalid file: " + fileName + "\n Please input a valid text file");
        }

        // Step 2: Load the file URL path from resources folder
        URL resource = Main.class.getClassLoader().getResource(fileName);

        // Step 3: Check if URL is valid
        if (resource == null) {
            throw new FileNotFoundException("File not found in resources: " + fileName);
        }

        // Step 4: Get the file from the URL
        File file = new File(resource.getFile());

        // Step 5: Initialize 3X3 integer 2D array
        int[][] grid = new int[3][3];

        // Step 6: Parse file and build state
        Scanner scanner = new Scanner(file);
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (scanner.hasNextInt()){
                    grid[i][j] = scanner.nextInt();
                }
            }
        }
        return new Grid(grid);
    }

    // to get a specific tile
    public int get(int row, int col) {
        return grid[row][col];
    }

    // polymorphism
    public int get(int[] position) {
        return grid[position[0]][position[1]];
    }

    public int[][] toArray() {
        return this.deepCopy();
    }

    // to deep copy 2d array states
    public int[][] deepCopy() {
        return Arrays.stream(grid) // Convert 2D state into a stream of rows
                .map(int[]::clone) // Clone each row using a lambda
                .toArray(int[][]::new); // Collect back into a new 2D state
    }

    // to create a new grid by swapping
    public Grid swap(int[] emptyTilePosition, int[] targetTilePosition) {

        int emptyRow = emptyTilePosition[0], emptyCol = emptyTilePosition[1];
        int targetRow = targetTilePosition[0], targetCol = targetTilePosition[1];

        int[][] newGrid = this.deepCopy();

        newGrid[emptyRow][emptyCol] = newGrid[targetRow][targetCol];
        newGrid[targetRow][targetCol] = 0;

        return new Grid(newGrid);
    }

    // to find the position of the empty tile
    public int[] getEmptyTileLocation(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) return new int[]{i,j};// Locate the empty tile
            }
        }
        return new int[0];
    }

    // to check if a position is in bounds of the 3X3 grid
    public static boolean isInBounds(int[] position) {
        int row = position[0], col = position[1];
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

}
