package com.vinod.expense8puzzle.utils;

import com.vinod.expense8puzzle.Main;
import com.vinod.expense8puzzle.models.PuzzleState;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class StateUtils {

    public static int[][] parse(String fileName) throws FileNotFoundException {

        // Step 1: Load the file URL path from resources folder
        URL resource = Main.class.getClassLoader().getResource(fileName);

        // Step 2: Check if URL is valid
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        // Step 3: Get the file from the URL
        File file = new File(resource.getFile());

        // Step 4: Define a 3X3 Integer 2D array
        int[][] state = new int[3][3];

        // Step 5: Read the file and store the content to 2D array subsequently
        Scanner scanner = new Scanner(file);
        for (int i=0; i<3; i++){
            if (scanner.hasNext()){
                for (int j=0; j<3; j++){
                    if (scanner.hasNextInt()){
                        state[i][j] = scanner.nextInt();
                    }
                }
            }
        }

        // Step 6: Return the 2D array state
        return state;
    }

    // to print a 2d array state
    public static void printState(int[][] state){

        for (int i=0; i< state.length; i++){
            for (int j=0; j<state[i].length; j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }


    // to deep copy 2d array states
    public static int[][] deepCopy(int[][] state) {
        return Arrays.stream(state) // Convert 2D state into a stream of rows
                .map(row -> row.clone()) // Clone each row using a lambda
                .toArray(size -> new int[size][]); // Collect back into a new 2D state
    }

    // to find the position of the empty tile
    public static int[] getEmptyTileLocation(int[][] state){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == 0) { // Locate the empty tile
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    // to find the valid moves available around the empty tile
    public static List<String> getValidMoves(int[] emptyTilePosition){

        List<String> validMoves = new ArrayList<>();
        int i = emptyTilePosition[0];
        int j = emptyTilePosition[1];

        if (i > 0) validMoves.add("Up");
        if (j < 2) validMoves.add("Right");
        if (i < 2) validMoves.add("Down");
        if (j > 0) validMoves.add("Left");

        return validMoves;
    }

    // to serialize 2d array to string for better comparison
    public static String serializeState(int[][] state) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : state) {
            for (int cell : row) {
                sb.append(cell);
            }
        }
        return sb.toString();
    }

}
