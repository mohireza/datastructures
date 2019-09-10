import java.util.Stack;
public class MinStack{
    private final Stack<Integer> items;
    private final Stack<Integer> minHistory;

    public MinStack(){
        items = new Stack<Integer>();
        minHistory = new Stack<Integer>();
    }

    public void push(Integer item){
        if(items.isEmpty()) minHistory.push(item);
        items.push(item);
        if(item < minHistory.peek()) minHistory.push(item);
    }

    public void pop(){
        Integer item = items.pop();
        if(item.equals(minHistory.peek()))minHistory.pop();
    }

    public Integer min(){
        return minHistory.peek();
    }

    public String toString(){
        return items.toString();
    }

}