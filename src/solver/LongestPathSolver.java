package solver;

import entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestPathSolver implements ISolver {

    @Override
    public SolutionInstance solve(ProblemInstance problem) {
        SolutionInstance solution = new SolutionInstance();

        Grid grid = new Grid(problem.grid, problem.rows, problem.columns);
        solution.grid = problem.grid;
        int totalValue = 0;
        for(Integer snake : problem.snakes) {
            SnakeSolution snakeSolution = new SnakeSolution();
            Path bestPath = null;
            // find good snake position
            Set<Grid.Field> bestSolution = null;
            int solutionValue = Integer.MIN_VALUE;
            for (int row = 0; row < grid.rows; row++) {
                for (int col = 0; col < grid.columns; col++) {
                    List<Set<Grid.Field>> solutions = new ArrayList<Set<Grid.Field>>();
                    grid.getLongestPath(grid.fields[row][col], new HashSet<Grid.Field>(), snake, solutions);
                    for (Set<Grid.Field> sol : solutions) {
                        int solValue = grid.getTotalValue(sol);
                        if (solValue > solutionValue) {
                            bestSolution = sol;
                            solutionValue = solValue;
                        }
                    }
                }
            }

            System.out.println("Value: "+ solutionValue+" length: "+ snake);
            totalValue = totalValue+ solutionValue;
            if(bestSolution != null) {
                for(Grid.Field field: bestSolution) {
                    System.out.println("row: "+ field.row+" column: "+ field.col);
                    field.isVisited = true;
                }
            }
        }

        System.out.println("TotalValue: "+totalValue);
        return solution;
    }
}
