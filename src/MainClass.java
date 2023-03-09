import entities.ProblemInstance;
import io.ProblemReader;
import io.SolutionWriter;
import solver.ISolver;
import solver.Solver;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Test");

        ProblemInstance problem = new ProblemReader().readerFile("");
        ISolver solver = new Solver();
        SolutionWriter writter = new SolutionWriter();
        writter.writeSolution(solver.solve(problem),"");

    }
}
