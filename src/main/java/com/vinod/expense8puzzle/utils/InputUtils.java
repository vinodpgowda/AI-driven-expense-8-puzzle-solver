package com.vinod.expense8puzzle.utils;

public class InputUtils {

    public static void validateInput(String[] args){
        if (args.length < 2){
            throw new IllegalArgumentException("Need 2 arguments, start state and goal state files");
        }

        if (!args[0].endsWith(".txt") || !args[1].endsWith(".txt")){
            throw new IllegalArgumentException("Both files need to be text (.txt) files");
        }
    }

    public static String findAlgorithm(String[] args){

        // Default algorithm is BFS
        String algorithm = "BFS";

        // Check if the input has a 3rd argument
        if (args.length > 2){
            algorithm = args[2].toUpperCase();
        }

        // return the algorithm
        return algorithm;
    }
}
