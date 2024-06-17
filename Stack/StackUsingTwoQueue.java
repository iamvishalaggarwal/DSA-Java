package Stack;

import java.util.LinkedList;
import java.util.Queue;

class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    // Function to push an element into stack using two queues.
    void push(int a) {
        q2.add(a);
        while (q1.size() != 0) {
            q2.add(q1.remove());
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    // Function to pop an element from stack using two queues.
    int pop() {
        // if no elements are there in q1
        if (q1.isEmpty())
            return -1;
        return q1.remove();
    }

}

public class StackUsingTwoQueue {

}
