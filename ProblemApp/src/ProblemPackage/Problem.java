package ProblemPackage;

public class Problem {
    private String name;
    private ProblemType type;
    private boolean isSolved;

    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
    }

    public ProblemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setStatus(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public boolean getStatus() {
        return isSolved;
    }
}