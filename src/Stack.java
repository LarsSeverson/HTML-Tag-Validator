public class Stack {

    // Creating two queue variable to use to form our stack
    static Queue<String> q1 = new Queue<String>();
    static Queue<String> q2 = new Queue<String>();

    // To maintain current number of
    // elements
    static int curr_size;

    // Push an item onto the stack using push which is used by queue as enqueue and dequeue operations
    static void push(String x)
    {
        // Push x first in empty q2
        q2.enqueue(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.enqueue(q1.peek());
            q1.dequeue();
        }

        // swap the names of two queues
        Queue<String> q = q1;
        q1 = q2;
        q2 = q;
    }

    // Remove top element on stack using dequeue as long as it's not empty
    static void pop()
    {

        // if no elements are there in q1
        if (q1.isEmpty())
            return;
        q1.dequeue();
    }

    // Showing the top element of the stack using custom peek operation
    static String top()
    {
        return q1.peek();
    }
}
