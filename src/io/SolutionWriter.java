package io;

import entities.SnakeSolution;
import entities.SolutionInstance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SolutionWriter {

    public void writeSolution(SolutionInstance solution, String path) {
        File file = new File(path);

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file, false));
            for (SnakeSolution snakeSolution : solution.solutions) {
                printWriter.println(snakeSolution.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
