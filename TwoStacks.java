import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

public class TwoStacks{
    private final int DEFAULT_SIZE = 10;
    int[] items;
    int top1;
    int top2;
    public TwoStacks(){
        items = new int[DEFAULT_SIZE];
        top1 = -1;
        top2 = items.length;
    }
    public TwoStacks(int capacity){
        items = new int[capacity];
        top1 = -1;
        top2 = items.length;
    }

    public void push1(int item){
        if(isFull()) throw new StackOverflowError();
        items[++top1] = item;
    }
    public void push2(int item){
        if(isFull()) throw new StackOverflowError();
        items[--top2] = item;
    }

    public int pop1(){
        if(isEmpty1()) throw new EmptyStackException();
        return items[top1--];
    }
    public int pop2(){
        if(isEmpty2()) throw new EmptyStackException();
        return items[top2++];
    }

    public int peek1(){
        if(isEmpty1()) throw new EmptyStackException();
        return items[top1];
    }
    public int peek2(){
        if(isEmpty2()) throw new EmptyStackException();
        return items[top2];
    }


    public int[] toArray1(){
        return Arrays.copyOfRange(items,0, top1 + 1);
    }

    public int[] toArray2(){
        return reverse(Arrays.copyOfRange(this.items,top2, this.items.length));
    }

    public String toString1(){
        return Arrays.toString(toArray1());
    }

    public String toString2(){
        return Arrays.toString(toArray2());
    }

    public boolean isEmpty1(){
        return top1 == -1;
    }

    public boolean isEmpty2(){
        return top1 == items.length;
    }

    public boolean isFull(){
        return top1 == top2-1;
    }

    private static int[] reverse(int[] input){
        int[] output = new int[input.length];
        for(int i = 0; i < input.length; i++){
            output[i] = input[input.length- i - 1];
        }
        return output;
    }

}