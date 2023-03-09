import entities.ProblemInstance;
import io.ProblemReader;
import io.SolutionWriter;
import solver.ISolver;
import solver.Solver;

public class MainClass {
    public static final String PROBLEM_EXAMPLE = "../problem/00-example.txt";
    public static final String PROBLEM_01 = "../problem/01-chilling-cat.txt";
    public static final String PROBLEM_02 = "../problem/02-swarming-ant.txt";
    public static final String PROBLEM_03 = "../problem/03-input-anti-greedy.txt";
    public static final String PROBLEM_04 = "../problem/04-input-low-points.txt";
    public static final String PROBLEM_05 = "../problem/05-input-opposite-points-holes.txt";
    public static void main(String[] args) {
        System.out.println("Test");

        ProblemInstance problem = new ProblemReader().readerFile("");
        ISolver solver = new Solver();
        SolutionWriter solutionWriter = new SolutionWriter();
        solutionWriter.writeSolution(solver.solve(problem),"");

    }
}
