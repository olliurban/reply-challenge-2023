package io;

import entities.ProblemInstance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class ProblemReader {

    public ProblemInstance readerFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String[] firstLine = br.readLine().split(" ");
            List<Integer> snakes = new ArrayList<Integer>();
            String[] secondLine =  br.readLine().split(" ");
            for (String s : secondLine) {
                snakes.add(Integer.valueOf(s));
            }
            //Feld
            int columns = Integer.valueOf(firstLine[0]);
            int rows = Integer.valueOf(firstLine[1]);


            String[][] matrix = new String[rows][columns];
            String nextLine = br.readLine();
            int colCounter = 0;

            while (nextLine != null) {
                matrix[colCounter] = nextLine.split(" ");
                colCounter++;
                nextLine = br.readLine();
            }
            ProblemInstance instance = new ProblemInstance(rows, columns, matrix, snakes);
            System.out.println(instance);
            return instance;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // TODO return proper problem instance
    }
}
