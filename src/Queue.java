public class Queue<T> {
    private Node front;
    private Node back;
    private int size;
    Queue(){
        front = null;
        size = 0;
    }
    public void enqueue(T value){
        Node newNode = new Node(value);
        if (front == null){
            front = newNode;
            back = newNode;
            size++;
            return;
        }
        Node current = front;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        back = newNode;
        size++;
    }
    public T dequeue(){
        T temp = front.value;
        front = front.next;
        return temp;
    }
    public T peek(){
      if (!isEmpty()){
          return front.value;
      }
      return null;
    }

    public T peekBack(){
        if (back != null){
            return back.value;
        }
        return null;
    }

    public boolean isEmpty(){
        return (front == null);
    }
    public int getSize() {
        return size;
    }

    private class Node {
        T value;
        Node next;
        Node(T value){
            this.value = value;
            this.next = null;
        }
    }
    public void display(){
        Node temp = front;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}