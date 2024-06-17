package Stack;

class MyStack {
    // LIFO
    // Note - TC in push and pop is O(1)
    int size = 100;
    int arr[] = new int[size];
    int top = -1;

    public void push(int data) {
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (top == -1) { // when stack is empty
            return top;
        }
        int x = arr[top];
        top--;
        return x;
    }

    public int top() {
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean empty() {
        return top == -1 ? true : false;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}
