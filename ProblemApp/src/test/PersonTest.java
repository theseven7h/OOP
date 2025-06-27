package test;

import static org.junit.jupiter.api.Assertions.*;

import ProblemPackage.Person;
import ProblemPackage.Problem;
import ProblemPackage.ProblemType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class PersonTest {
    Problem  problem = new Problem("School fees", ProblemType.FINANCIAL);
    Person person = new Person();

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testGetAllProblems() {
        assertEquals(person.getAllProblems().size(), 0 );
    }

    @Test
    public void testAddProblem() {
        person.addProblem(problem);
        assertEquals(person.getAllProblems().size(), 1);
    }

//    @Test
//    public void testTellProblems() {
//        ArrayList<Problem> unsolvedProblems = person.tellProblems();
//        assertEquals(unsolvedProblems, problem);
//    }

//    @Test
//    public void testSolveProblem() {
//        assertFalse(problem.getStatus());
//        person.solveProblem(problem);
//        assertTrue(problem.getStatus());
//    }
}