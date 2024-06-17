package Stack;

import java.util.Stack;

/* Approach 
 * TC: O(1) for all operations
 * SC: O(2N) 
 */
class MinStack {
    int arr[] = new int[2];
    Stack<int[]> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if (stack.empty()) {
            int pair[] = { val, val };
            stack.push(pair);
        } else {
            int min = Math.min(stack.peek()[0], val);
            int pair[] = { val, min };
            stack.add(pair);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/*
 * Optimal Approach
 * TC: O(1) for all operations
 * SC: O(1N)
 */
// class MinStack {
// Stack < Long > st = new Stack < Long > ();
// Long mini;

// /** initialize your data structure here. */
// public MinStack() {
// mini = Long.MAX_VALUE;
// }

// public void push(int value) {
// Long val = Long.valueOf(value);
// if (st.isEmpty()) {
// mini = val;
// st.push(val);
// } else {
// if (val < mini) {
// st.push(2 * val - mini);
// mini = val;
// } else {
// st.push(val);
// }
// }
// }

// public void pop() {
// if (st.isEmpty()) return;

// Long val = st.pop();
// if (val < mini) {
// mini = 2 * mini - val;
// }
// }

// public int top() {
// Long val = st.peek();
// if (val < mini) {
// return mini.intValue();
// }
// return val.intValue();
// }

// public int getMin() {
// return mini.intValue();
// }
// }
public class MinStackMain {

}
