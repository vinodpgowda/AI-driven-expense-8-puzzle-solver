package com.vinod.expense8puzzle.solver;

public enum Move {

    Up(-1, 0, "Down"),
    Down(1, 0, "Up"),
    Left(0, -1, "Right"),
    Right(0, 1, "Left");

    private final int row;
    private final int col;
    private final String label;

    public String getLabel() {
        return label;
    }

    Move(int row, int col, String label) {
        this.row = row;
        this.col = col;
        this.label = label;
    }

    public int[] getTargetPosition(int[] emptyTilePosition) {
        return new int[]{emptyTilePosition[0] + row, emptyTilePosition[1] + col};
    }
}
