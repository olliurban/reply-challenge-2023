package io;

import entities.ProblemInstance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProblemReader {

    public ProblemInstance readerFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            //TODO: impl

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null; // TODO return proper problem instance
    }
}
