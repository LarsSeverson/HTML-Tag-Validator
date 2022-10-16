public class Stack<T> {

    // Creating two queue variable to use to form our stack
    private final Queue<String> q1 = new Queue<>();
    private final Queue<String> q2 = new Queue<>();

    // To maintain current number of
    // elements
    private static int curr_size = 0;

    // Push an item onto the stack using push which is used by queue as enqueue and dequeue operations
    public void push(String x)
    {
        if(q1.isEmpty()){
            q1.enqueue(x);
            curr_size++;
            return;
        }
        // This is such a waste of time
        // Queue is not needed for this problem
        while(!q1.isEmpty()){
            q2.enqueue(q1.dequeue());
        }
        q1.enqueue(x);
        while(!q2.isEmpty()){
            q1.enqueue(q2.dequeue());
        }
        curr_size++;
    }

    // Remove top element on stack using dequeue as long as it's not empty
    public String pop(){
        return q1.dequeue();
    }

    // Showing the top element of the stack using custom peek operation
    public String top() {
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }


    public int size() {
        return q1.getSize();
    }
    public void show(){
        System.out.println("Q1");
        q1.display();
        System.out.println("Q2");
        q2.display();
    }

}