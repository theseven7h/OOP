package ProblemPackage;

import java.util.ArrayList;

public class Person {
    ArrayList<Problem> problems = new ArrayList<>();

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public void solveProblem(Problem problem) {
        for (Problem foundProblem : problems) {
            if (foundProblem == problem) {
                problem.setStatus(true);
            }
        }
    }

    public ArrayList<Problem> tellProblems() {
        ArrayList<Problem> unsolvedProblems = new ArrayList<>();
        for(Problem problem : problems) {
            if(!problem.getStatus()) {
                unsolvedProblems.add(problem);
            }
        }
        return unsolvedProblems;
    }

    public ArrayList<Problem> getAllProblems() {
        return this.problems;
    }
}