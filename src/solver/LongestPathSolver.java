package solver;

import entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class LongestPathSolver implements ISolver {

    @Override
    public SolutionInstance solve(ProblemInstance problem) {
        SolutionInstance solution = new SolutionInstance();

        Grid grid = new Grid(problem.grid, problem.rows, problem.columns);
        solution.grid = problem.grid;

        int totalValue = 0;
        for (Integer snake : problem.snakes) {
            SnakeSolution snakeSolution = new SnakeSolution();
            Path bestPath = null;
            // find good snake position
            List<Grid.Field> bestSolution = null;
            int solutionValue = Integer.MIN_VALUE;

            for (int row = 0; row < grid.rows; row++) {
                for (int col = 0; col < grid.columns; col++) {
                    List<Grid.Field> subPath = new ArrayList<>();
                    if (!grid.fields[row][col].isVisited) {
                        subPath.add(grid.fields[row][col]);
                        int pathLength = snake < 5 ? snake : 5;
                        grid.getLongestPath(grid.fields[row][col], subPath, pathLength);
                        int solValue = grid.getTotalValue(grid.bestPath);
                        if (solValue > solutionValue) {
                            bestSolution = grid.bestPath;
                            solutionValue = solValue;
                        }
                    }
                }
            }



            if (bestSolution != null) {
                System.out.println("Snake Length: " + snake + " Value: " + solutionValue + " length: " + snake + " row: " + bestSolution.get(0).row + " col: " + bestSolution.get(0).col);
                for (Grid.Field field : bestSolution) {
                    grid.fields[field.row][field.col].isVisited = true;
                    field.isVisited = true;
                    int pathConst = 5;
                    int lastSize = bestSolution.size();
                    while (bestSolution.size() != snake) {
                        int leftPathLength = snake - bestSolution.size();
                        int pathLength = leftPathLength < pathConst ? leftPathLength : pathConst;

                        grid.getLongestPath(bestSolution.get(bestSolution.size() - 1), bestSolution, bestSolution.size() + pathLength);
                        bestSolution = grid.bestPath;
                        int newSize = bestSolution.size();
                        //If no way is possible go a step back
                        if(newSize == lastSize) {
                            bestSolution.remove(bestSolution.size()-1);
                        } else {
                            lastSize = newSize;
                        }
                        grid.bestPath.forEach(solField-> {
                            grid.fields[solField.row][solField.col].isVisited = true;
                            solField.isVisited = true;
                        });
                        if(bestSolution.size() > snake) {
                            pathConst = pathConst -1;
                        }
                    }

                }
                totalValue = totalValue + grid.getTotalValue(grid.bestPath);;
                solution.solutions.add(bestSolution);
                System.out.println("SolutionSize:"+bestSolution.size());
                grid.bestPath = new ArrayList<>();
            }
        }

        System.out.println("TotalValue: " + totalValue);
        return solution;
    }


}
