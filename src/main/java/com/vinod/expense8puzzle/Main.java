package com.vinod.expense8puzzle;

class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the start.txt and goal.txt files as arguments.");
            return;
        }

        int[][] startArray = {
                {2, 3, 6},
                {1, 7, 0},
                {4, 8, 5}
        };

        int[][] goalArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

//        for (int i=0; i<3; i++){
//            for (int j=0; j<3; j++){
//                if (startArray[i][j] != goalArray[i][j]){
//                    System.out.println("The states are not equal");
//                    break;
//                }
//            }
//        }

        int i = 1;
        int j = 2;

        if (startArray[i][j] == 0){
            if (i>0){
                System.out.println(startArray[i-1][j]);
            }
            if (i<2){
                System.out.println(startArray[i+1][j]);
            }

            if (j>0){
                System.out.println(startArray[i][j-1]);
            }

            if (j<2){
                System.out.println(startArray[i][j+1]);
            }
        }


//        String startFileName = args[0]; // First argument is the start file
//        String goalFileName = args[1];  // Second argument is the goal file
//
//        // Load the files from src/main/resources
//        InputStream startFile = Main.class.getClassLoader().getResourceAsStream(startFileName);
//        InputStream goalFile = Main.class.getClassLoader().getResourceAsStream(goalFileName);
//
//        if (startFile == null || goalFile == null) {
//            System.out.println("One or both files not found in resources.");
//            return;
//        }
//
//        // Pass the InputStreams to the PuzzleSolver class
//        PuzzleSolver puzzleSolver = new PuzzleSolver(startFile, goalFile);
//    }

    }
}

//class PuzzleSolver {
//    public PuzzleSolver(InputStream startFile, InputStream goalFile) {
//        System.out.println("Reading start file:");
//        readFile(startFile);
//
//        System.out.println("Reading goal file:");
//        readFile(goalFile);
//    }
//
//    private void readFile(InputStream file) {
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//        }
//    }
//}
