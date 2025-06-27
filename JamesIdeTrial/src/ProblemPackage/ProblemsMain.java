package ProblemPackage;

import java.util.ArrayList;
import java.util.Scanner;


public class ProblemsMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person person = new Person();
        Problem problem;

        while (true) {
            System.out.println("""
                Welcome to Nigeria!
                1. Add problem
                2. Solve a problem
                3. View all problems
                4. View unsolved problems
                0. Exit
                """);
            String menuChoice = sc.next().trim();

            switch (menuChoice) {
                case "1" -> {
                    while (true) {
                        System.out.print("Enter the problem name: ");
                        String problemName = sc.nextLine();
                        sc.nextLine();

                        System.out.println("Enter the problem type\n1. FINANCIAL\n2. EDUCATIONAL\n3. BUSINESS\n4. TECHNICAL\n5. SPIRITUAL\n6. MENTAL");
                        String type = sc.nextLine().trim();
                        ProblemType problemType = getProblemType(type);

                        problem = new Problem(problemName, problemType);
                        person.addProblem(problem);

                        System.out.println("Do you want to add another problem? (Yes or No)");
                        String choice = sc.next().toLowerCase().trim();
                        if (willStopAddingProblem(choice)) break;
                    }
                    while (true) {
                        System.out.println("O. Back");
                        String backChoice = sc.next().trim();
                        if (willGoBack(backChoice)) break;
                        System.out.println("Invalid choice. Try again!\n");
                    }
                }

                case "2" -> {
                    while (true) {
                        displayProblems(person.getAllProblems());
                        System.out.println("Enter the exact problem number you wish to solve: ");
                        String problemNumber = sc.next().trim();

                        if(entryChoiceIsValid(problemNumber, person.getAllProblems())) {
                            Problem unsolvedProblem = person.getAllProblems().get(Integer.parseInt(problemNumber) - 1);
                            person.solveProblem(unsolvedProblem);
                            System.out.println("ProblemPackage.Problem solved successfully!\n");

                            while (true) {
                                System.out.println("O. Back");
                                String backChoice = sc.next().trim();
                                if (willGoBack(backChoice)) break;
                                System.out.println("Invalid choice. Try again!\n");
                            }
                            break;
                        }
                        System.out.println("Invalid Choice...");
                    }
                }

                case "3" -> {
                    displayProblems(person.getAllProblems());
                    while (true) {
                        System.out.println("O. Back");
                        String backChoice = sc.next().trim();
                        if (willGoBack(backChoice)) break;
                        System.out.println("Invalid choice. Try again!\n");
                    }
                }

                case "4" -> {
                    ArrayList<Problem> unsolvedProblems = person.tellProblems();
                    displayProblems(unsolvedProblems);
                    while (true) {
                        System.out.println("O. Back");
                        String backChoice = sc.next().trim();
                        if (willGoBack(backChoice)) break;
                        System.out.println("Invalid choice. Try again!\n");
                    }
                }

                case "0" -> System.exit(0);

                default -> throw new IllegalStateException("Invalid choice: " + menuChoice);
            }
        }
    }

    public static ProblemType getProblemType(String type) {
        ProblemType problemType;
        switch (type) {
            case "1": problemType = ProblemType.FINANCIAL; break;
            case "2": problemType = ProblemType.EDUCATIONAL; break;
            case "3": problemType = ProblemType.BUSINESS; break;
            case "4": problemType = ProblemType.TECHNICAL; break;
            case "5": problemType = ProblemType.SPIRITUAL; break;
            case "6": problemType = ProblemType.MENTAL; break;
            default:
                throw new IllegalArgumentException("Invalid problem type");
        }
        return problemType;
    }

    public static boolean willStopAddingProblem(String choice) {
        if (choice.equals("yes")) return false;
        else if (choice.equals("no")) return true;
        else throw new IllegalArgumentException("Invalid choice");
    }

    public static void displayProblems(ArrayList<Problem> problems) {
        for (int i = 0; i < problems.size(); i++) {
			System.out.printf("%n(%d)%nProblem Name: %s%nProblem Type: %s%nProblem Status(Solved?): %s%n", (i+1), problems.get(i).getName(), problems.get(i).getType(), problems.get(i).getStatus());
		}
    }

    public static boolean entryChoiceIsValid(String choice, ArrayList<Problem> problems) {
        return Integer.parseInt(choice) - 1 <= problems.size() && Integer.parseInt(choice) - 1 >= 0;
    }

    public static boolean willGoBack(String backChoice) {
        return backChoice.equals("0");
    }
}