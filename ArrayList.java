import java.util.Arrays;

public class ArrayList {
     private final int DEFAULT_SIZE = 10;
     private final int DEFAULT_RESIZE_FACTOR = 2;
     private int[] array;
     private int size = 0;

    public ArrayList(){
        array = new int[DEFAULT_SIZE];
    }

    public ArrayList(int length){
        array = new int[length];
    }
    public  void insert(int number){
        resizeIfRequired();
        array[size] = number;
        size++;
    }

    public void insertAt(int item, int index){
        if(index >= 0 && index < array.length){
            resizeIfRequired();
            for(int i = size; i > index; i--)
                array[i]= array[i-1];
            array[index] = item;
            size++;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void removeAt(int index){
        if(index >= 0 && index < array.length){
            for(int i = index; i < size-1; i++){
                array[i] = array[i+1];
            }
            size--;
            resizeIfRequired();
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int indexOf(int number){
        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                return i;
            }
        }
        return -1;
    }

    public int max(){
        int max = array[0];

        for(int i = 1; i < size; i++)
            if(max < array[i]) max = array[i];

        return max;
    }

    public int[] intersect(int[] array){
        int[] intersection = new int[size];
        int count = 0;
        for(int item: array)
            if(indexOf(item)>=0)
                intersection[count++] = item;

        return intersection;
    }

    public int[] reverse(){
        int[] reverse = new int[size];
        for(int i = 0; i < size; i++){
            reverse[i] = array[size-1-i];
        }
        return reverse;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void expand(){
        int[] temp = Arrays.copyOf(array, array.length * DEFAULT_RESIZE_FACTOR);
        array = temp;
    }

    private void contract(){
        int[] temp = Arrays.copyOf(array, array.length / DEFAULT_RESIZE_FACTOR);
        array = temp;
    }

    private void resizeIfRequired(){
        if(size <= array.length/2){
            contract();
        }
        if(size >= array.length){
            expand();
        }
    }
}
