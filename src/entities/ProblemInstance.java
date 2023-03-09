package entities;

import java.util.List;

public class ProblemInstance {
    public int rows;
    public int columns;
    public String[][] grid;
    public List<Integer> snakes;

    public ProblemInstance(int rows, int columns, String[][] grid, List<Integer> snakes) {
        this.rows = rows;
        this.columns = columns;
        this.grid = grid;
        this.snakes = snakes;
    }

    public void print() {
        System.out.print(this.toString());
    }
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for(Integer snake: snakes) {
            buf.append(snake).append(" ");
        }
        buf.append("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                buf.append(grid[i][j]).append(" ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }



}
