import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack{
    private final int DEFAULT_SIZE = 10;
    int[] items;
    int count = 0;
    public Stack(){
        items = new int[DEFAULT_SIZE];
    }
    public Stack(int capacity){
        items = new int[capacity];
    }

    public void push(int item){
        if(isFull()) throw new StackOverflowError();
        items[count++] = item;
    }

    public int pop(){
        if(isEmpty()) throw new EmptyStackException();
        return items[--count];
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return items[count - 1];
    }

    public int[] toArray(){
        return Arrays.copyOfRange(items,0, count);
    }

    @Override
    public String toString(){
        return Arrays.toString(toArray());
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

}