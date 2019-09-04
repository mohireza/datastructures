package com.datastructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size = 0;

    public void addFirst(int value){
        Node node = new Node(value);
        if(size==0)
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }
    //addLast
    public void addLast(int value){
        Node node = new Node(value);
        if(size==0)
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void removeFirst(){
        if(size==0){
            throw new NoSuchElementException();
        }
        else if(size==1)
            first=last=null;
        else{
            Node old = first;
            first = first.next;
            old.next = null; //to enable garbage collection
        }
        size--;
    }

    public void removeLast(){
        if(size==0){
            throw new NoSuchElementException();
        }
        else if(size==1)
            first=last=null;
        else{
            last = getPrevious(last);
            last.next = null; //to enable garbage collection
        }
        size--;
    }
    //contains
    public boolean contains(int value){
        return indexOf(value) >= 0;
    }

    //indexOf
    public int indexOf(int value){
        Node current = first;
        int counter = 0;
        while(current !=null){
            if(current.value == value)
                return counter;
            current = current.next;
            counter++;
        }
        return -1;
    }

    public String toString(){
        StringBuilder list = new StringBuilder();
        list.append("[");
        Node current = first;
        while(current != null){
            list.append(current.value);
            if(current.next!=null)
                list.append(", ");
            current = current.next;
        }
        list.append("]");
        return list.toString();
    }

    public int[] toArray(){
        int[] list = new int[size];
        Node current = first;
        int index=0;
        while(current != null){
            list[index++]=current.value;
            current = current.next;
        }
        return list;
    }

    public int getSize(){
        return size;
    }
    
    public void reverse(){
        if(size <= 1){
            return;
        }else{
            Node pointer1 = first;
            Node pointer2 = pointer1.next;
            while(pointer2 != null){
                Node pointer3 = pointer2.next;
                pointer2.next = pointer1;
                pointer1 = pointer2;
                pointer2 = pointer3;
            }
            
            first.next = null;
            last = first;
            first = pointer1;
        }
    }

    private Node getPrevious(Node node){
        Node current = first;
        while(current!=null){
            if(current.next==node)
                return current;
            current = current.next;
        }
        return null;
    }
}
