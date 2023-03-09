package solver;

import entities.*;

import java.util.List;

public class Solver implements ISolver {

    @Override
    public SolutionInstance solve(ProblemInstance problem) {
        SolutionInstance solution = new SolutionInstance();

        Grid grid = new Grid(problem.grid, problem.rows, problem.columns);
        solution.grid = problem.grid;

        problem.snakes.forEach(snake -> {
            SnakeSolution snakeSolution = new SnakeSolution();

            // find good snake position
            Grid.Field startField = grid.getFieldWithMaxValue();
            Path path = new Path();
            int startRow = startField.row;
            int startColumn = startField.col;
            snakeSolution.addStart(startColumn,startRow);

            path.addField(startField);
            //iteration über das grid max value field als start

            // get neighbour //max value next step

            Grid.Field curField = grid.fields[startRow][startColumn];
            int step = 0;
            while (step < snake) {
                List<Grid.Field> neighbors = grid.getImmediateNeighbors(curField.row, curField.col);

                // direction to neighbor?


                // get immediate neighbor maximum
                var fieldWithMaxValue = grid.getNeighbourWithMaxValue(neighbors);
                switch (grid.getDirection(curField.row, curField.col, fieldWithMaxValue.row, fieldWithMaxValue.col)) {
                    case 'L': snakeSolution.moveLeft(); break;
                    case 'R': snakeSolution.moveRight(); break;
                    case 'U': snakeSolution.moveUp(); break;
                    case 'D': snakeSolution.moveDown(); break;
                    default: throw new RuntimeException("Invalid direction O.o");
                }

                step++;
                fieldWithMaxValue.isVisited = true;
                curField = fieldWithMaxValue;
            }



            // can we improve based on wormholes?
            /*for (Grid.Field n : neighbors) {
                if (n.value == Grid.Field.WORMHOLE) {
                    List<Grid.Field> wormholeNeighbors = grid.getImmediateNeighbors(n.row, n.col);

                }
            }*/
            solution.solutions.add(snakeSolution);
        });


        return solution;
    }
}
