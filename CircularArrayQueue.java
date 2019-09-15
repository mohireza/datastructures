import java.util.Arrays;

public class CircularArrayQueue {
    //Implementation of a Queue of integers using a circular array
    private final int DEFAULT_SIZE = 10;
    private int front = 0;
    private int back = -1;
    private int[] items;
    private int count;

    public CircularArrayQueue(int capacity){
        items = new int[capacity];
    }
    public CircularArrayQueue(){
        items = new int[DEFAULT_SIZE];
    }

    public void enqueue(int item){
        if(isFull()) throw new IllegalStateException("The queue is full.");
        back = (back + 1) % items.length;
        items[back] = item;
        count++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("The queue is empty.");
        count--;
        int item = items[front];
        front = (front + 1) % items.length;
        return item;
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("The queue is empty.");
        return front;
    }

    public boolean isFull(){
        return count==items.length;
    }

    public boolean isEmpty(){
        return count==0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        int index = front;
        for (int i = 1; i <= count; i++) {
            output.append(items[index]);
            if (i != count) output.append(",");
            index = (index + 1) % items.length;
        }
        output.append("]");
        return output.toString();
    }
}

