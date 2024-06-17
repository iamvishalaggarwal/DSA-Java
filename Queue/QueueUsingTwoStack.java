package Queue;

import java.util.Stack;

/*
 * TC: O(N) push 
 * SC: O(2N)
 */
// class QueueUsingStack {
//     Stack<Integer> stack1 = new Stack<>();
//     Stack<Integer> stack2 = new Stack<>();

//     public void push(int x) {
//         while (!stack1.empty()) {
//             stack2.add(stack1.pop());
//         }
//         stack1.add(x);
//         while (!stack2.empty()) {
//             stack1.add(stack2.pop());
//         }
//     }

//     public int pop() {
//         return stack1.pop();
//     }

//     public int peek() {
//         return stack1.peek();
//     }

//     public boolean empty() {
//         return stack1.empty();
//     }
// }

/*
 * TC: O(1) amortized
 * SC: O(2N)
 */
class Queue {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    /* The method pop which return the element poped out of the stack */
    int dequeue() {
        if (!output.empty()) {
            return output.pop();
        } else {
            while (!input.empty()) {
                output.add(input.pop());
            }
            return output.pop();
        }
    }

    /* The method push to push element into the stack */
    void enqueue(int x) {
        input.add(x);
    }
}

public class QueueUsingTwoStack {

}