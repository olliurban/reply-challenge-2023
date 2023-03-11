package io;

import entities.Grid;
import entities.SnakeSolution;
import entities.SolutionInstance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SolutionWriter {

    public void writeSolution(SolutionInstance solution, String path) {
        File file = new File(path);

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file, false));
            for (List<Grid.Field> solList : solution.solutions) {
                String solutionString = solList.get(0).col + " " + solList.get(0).row;
                for (int i = 1; i < solList.size(); i++) {
                    int preCol = solList.get(i - 1).col;
                    int preRow = solList.get(i - 1).row;
                    int currentCol = solList.get(i).col;
                    int currentRow = solList.get(i).row;

                    if (preRow < currentRow) {
                        solutionString += " D";
                        continue;
                    }
                    if (preRow > currentRow) {
                        solutionString += " U";
                        continue;
                    }

                    if (preCol < currentCol) {
                        solutionString += " R";
                        continue;
                    }
                    if (preCol > currentCol) {
                        solutionString += " L";
                        continue;
                    }
                }
                printWriter.println(solutionString);
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
