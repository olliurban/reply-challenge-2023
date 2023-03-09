package solver;

import entities.ProblemInstance;
import entities.SolutionInstance;

public interface ISolver {
    public SolutionInstance solve(ProblemInstance problem);
}
