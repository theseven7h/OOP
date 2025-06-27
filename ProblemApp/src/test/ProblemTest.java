package test;

import ProblemPackage.Problem;
import ProblemPackage.ProblemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {
    Problem problem = new Problem("School fees", ProblemType.FINANCIAL);

    @Test
    public void testGetType() {
        Assertions.assertEquals(ProblemType.FINANCIAL, problem.getType());
    }

    @Test
    public void testGetName() {
        assertEquals("School fees", problem.getName());
    }

    @Test
    public void testGetStatus() {
        assertEquals(false, problem.getStatus());
    }

    @Test
    public void testSetStatus() {
        problem.setStatus(true);
        assertEquals(true, problem.getStatus());
    }
}