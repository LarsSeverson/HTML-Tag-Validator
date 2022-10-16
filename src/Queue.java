import java.util.NoSuchElementException;

public class Queue<T> {

    // Method to show first element in queue
    public String peek() {
        if (first == null)
        {

        }
        else
        {
            return (String) first.item;
        }
        return null;
    }

    // Node class for list items and next item
    private class Node{
        T item;
        Node next;

        Node(T t){
            item = t;
            next = null;
        }
    }

    private Node first, last;

    Queue (){
        first = null;
        last = null;
    }

    // If it's empty then return null
    public boolean isEmpty(){
        return first == null;
    }

    // Adding items to queue
    public void enqueue(T t){
        Node oldLast = last;
        last = new Node(t);
        if (isEmpty()) first = last;
        else   oldLast.next = last;
    }

    // Removing items from queue
    public T dequeue(){
        if (isEmpty())
            return  null;

        if (first == last){
            T t = (T) first.item;
            first = last = null;
            return  t;
        }

        T t = (T) first.item;
        first = first.next;
        return t;
    }
}
