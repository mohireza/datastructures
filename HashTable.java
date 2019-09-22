import java.util.LinkedList;

public class HashTable {
    private class Entry{
        int key;
        String value;
        Entry(int key, String value){
            this.key=key;
            this.value = value;
        }
        @Override
        public String toString(){
            return key+"="+value;
        }

    }
    private final int LENGTH = 10;
    LinkedList<Entry>[] items;

    public HashTable(){
        items = new LinkedList[LENGTH];
    }

    public void put(int key, String value){
        var index = getHashCode(key);
        if(items[index] == null)
            items[index] = new LinkedList();
        for(var entry: items[index]){
            if(entry.key == key){
                entry.value = value;
                return;
            }
        }
        items[index].addLast(new Entry(key,value));
    }

    public String get(int key){
        var bucket = items[getHashCode(key)];
        if(bucket != null){
            for(Entry entry:bucket){
                if(entry.key == key) return entry.value;
            }
        }
        throw new IllegalArgumentException("Item does not exist.");
    }

    public void remove(int key){
        var bucket = items[getHashCode(key)];
        if(bucket != null){
            for(Entry entry:bucket){
                if(entry.key == key){
                    bucket.remove(entry);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Item does not exist.");
    }

    private int getHashCode(int key) {
        return key%LENGTH;
    }

    @Override
    public String toString(){
        var output = new StringBuilder();
        for(var bucket: items){
            if(bucket != null){
                for(var entry: bucket){
                    output.append(entry.toString()+'\n');
                }
            }
        }
        return output.toString();
    }

}