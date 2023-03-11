import entities.ProblemInstance;
import io.ProblemReader;
import io.SolutionWriter;
import solver.ISolver;
import solver.LongestPathSolver;
import solver.Solver;

public class MainClass {
    public static final String PROBLEM_EXAMPLE = "problem//00-example";
    public static final String PROBLEM_01 = "problem/01-chilling-cat";
    public static final String PROBLEM_02 = "problem/02-swarming-ant";
    public static final String PROBLEM_03 = "problem/03-input-anti-greedy";
    public static final String PROBLEM_04 = "problem/04-input-low-points";
    public static final String PROBLEM_05 = "problem/05-input-opposite-points-holes";

    public static void main(String[] args) {
        System.out.println("LETS FUCKING GO");
        ProblemInstance problem = new ProblemReader().readerFile(PROBLEM_EXAMPLE+".txt");
        ISolver solver = new LongestPathSolver();
        SolutionWriter solutionWriter = new SolutionWriter();
        solutionWriter.writeSolution(solver.solve(problem),PROBLEM_EXAMPLE+"_solution.txt");
    }
}
