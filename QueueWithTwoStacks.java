import java.util.Stack;
public class QueueWithTwoStacks {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueWithTwoStacks(){
        enqueueStack = new Stack();
        dequeueStack = new Stack();
    }

    public void enqueue(int item){
        enqueueStack.push(item);
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("queue is empty");
        prepareDequeueStack();
        return dequeueStack.pop();
    }


    private void prepareDequeueStack() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("queue is empty");
        prepareDequeueStack();
        return dequeueStack.peek();
    }

    public String toString(){
        while(!dequeueStack.isEmpty()){
            enqueueStack.push(dequeueStack.pop());
        }
        return enqueueStack.toString();
    }

    public boolean isEmpty(){
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}
