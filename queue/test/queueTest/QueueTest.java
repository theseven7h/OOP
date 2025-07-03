package queueTest;

import org.junit.jupiter.api.BeforeEach;
import queue.MyQueue;
import org.junit.jupiter.api.Test;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    MyQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue(5);
    }

    @Test
    public void testInitialQueueIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueIsNotEmpty_WhenElementIsAdded_WithAdd() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testQueueIsEmpty_WhenElementIsAdded_AndRemoved_WithRemove() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueIsNotEmpty_WhenElementIsAdded_WithOffer() {
        assertTrue(queue.isEmpty());
        queue.offer("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testQueueIsEmpty_WhenElementIsAdded_AndRemoved_WithPoll() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueIsEmpty_WhenTheOnlyElementIsRemoved_WithPoll() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueIsEmpty_WhenOnlyElementIsRemoved_WithRemove() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueSizeReturns3_When3ElementsAreAdded() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        assertEquals(3, queue.size());
    }

    @Test
    public void testAddThrowsException_WhenQueueIsFull() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        assertEquals(5, queue.size());
        assertThrows(QueueOverflowException.class, () -> queue.add("F"));
    }

    @Test
    public void testExceptionMessage_IfAddingWhenQueueIsFull() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        assertEquals(5, queue.size());
        Exception qoe = assertThrows(QueueOverflowException.class, () -> queue.add("F"));
        assertEquals("Queue is full", qoe.getMessage());
    }

    @Test
    public void testOfferReturnsFalse_WhenQueueIsFull() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        assertEquals(5, queue.size());
        assertFalse(queue.offer("F"));
    }

    @Test
    public void testRemoveThrowsException_WhenQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertThrows(QueueUnderflowException.class, () -> queue.remove());
    }

    @Test
    public void testExceptionMessage_IfRemoving_WhenQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        Exception que = assertThrows(QueueUnderflowException.class, () -> queue.remove());
        assertEquals("Queue is empty", que.getMessage());
    }

    @Test
    public void testPollReturnsNull_WhenQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertNull(queue.poll());
    }

    @Test
    public void testQueueReturnsHeadElement_WhenElementMethod_IsUsedOnQueue() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        assertFalse(queue.isEmpty());
        assertEquals("B", queue.element());
    }

    @Test
    public void testQueueReturnsHeadElement_WhenPeekMethod_IsUsedOnQueue() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        assertFalse(queue.isEmpty());
        assertEquals("B", queue.peek());
    }

    @Test
    public void testElementMethodThrowsException_WhenQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
        queue.remove();
        assertThrows(QueueUnderflowException.class, () -> queue.element());
    }

    @Test
    public void testPeekMethodReturnsNull_WhenQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        assertFalse(queue.isEmpty());
        queue.remove();
        assertNull(queue.peek());
    }

    @Test
    public void testConsecutiveHeadElementsReturned_IfAddThenRemoveElementsWithRemove() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        assertEquals("A", queue.remove());
        assertEquals("B", queue.remove());
        assertEquals("C", queue.remove());
    }

    @Test
    public void testConsecutiveHeadElementsReturned_IfAddThenRemoveElementsWithPoll() {
        assertTrue(queue.isEmpty());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        assertEquals("A", queue.poll());
        assertEquals("B", queue.poll());
        assertEquals("C", queue.poll());
    }





}
