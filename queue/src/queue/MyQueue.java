package queue;

public class MyQueue {
    private int insertCount;
    private int removeCount;
    private String[] queue;
    private int queueSize;

    public MyQueue(int queueSize) {
        queue = new String[queueSize];
    }

    public boolean isEmpty() {
        return insertCount == 0;
    }

    public void add(String string) {
        if (insertCount == queue.length) throw new QueueOverflowException("Queue is full");
        queue[insertCount++] = string;
    }

    public String remove() {
        if (insertCount == 0) throw new QueueUnderflowException("Queue is empty");
        insertCount--;
        return queue[removeCount++];
    }

    public boolean offer(String string) {
        if(insertCount == queue.length) return false;
        queue[insertCount++] = string;
        return true;
    }

    public String poll() {
        if (insertCount == 0) return null;
        insertCount--;
        return queue[removeCount++];
    }

    public int size() {
        return insertCount;
    }

    public String element() {
        if(insertCount == 0) throw new QueueUnderflowException("Queue is empty");
        return queue[insertCount-1];
    }

    public String peek() {
        if(insertCount == 0) return null;
        return queue[insertCount-1];
    }
}
