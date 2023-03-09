package entities;

import java.util.ArrayList;
import java.util.List;

public class SnakeSolution {
    List<String> moves = new ArrayList<String>();

    public void addStart(int x, int y) {
        moves.add(String.valueOf(x));
        moves.add(String.valueOf(y));
    }

    public void moveUp() {
        moves.add("U");
    }

    public void moveRight() {
        moves.add("R");
    }

    public void moveLeft() {
        moves.add("U");
    }

    public void moveDown() {
        moves.add("D");
    }

    @Override
    public String toString() {
        String s = "";
        for (String sol : moves) {
            s = s+ sol + " ";
        }

        return s;
    }
}
