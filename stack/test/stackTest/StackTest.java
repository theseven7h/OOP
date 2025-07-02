package stackTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.MyStack;
import stack.StackUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack(5);
    }

    @Test
    public void testStackIsEmptyAtCreation() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackIsNotEmpty_AfterOnePush() {
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testStackIsEmpty_AfterOnePop_AndOnePop() {
        assertTrue(stack.isEmpty());
        stack.push("Anew");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testElementIsReturned_AfterPushAndPop() {
        stack.push("A");
        assertEquals("A", stack.pop());
    }

    @Test
    public void testLastElementIsReturned_AfterMultiplePushesAndAPop() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
    }

    @Test
    public void testAllElementsAreReturned_AfterMultiplePushesAndMultiplePop() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testPoppingEmptyStack_ThrowsException() {
        assertTrue(stack.isEmpty());
        assertThrows(StackUnderflowException.class, () -> stack.pop());
    }

    @Test
    public void testMessageIsReturned_WhenExceptionIsThrown() {
        assertTrue(stack.isEmpty());
        Exception sue = assertThrows(StackUnderflowException.class, () -> stack.pop());
        assertEquals("Stack is full", sue.getMessage());
    }

    @Test
    public void testStackSizeIsCorrect() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.size());
    }
}
