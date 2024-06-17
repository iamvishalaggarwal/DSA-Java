package Stack;

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

class MyStackCustom {

    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode newNode = new StackNode(a);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    int pop() {
        if (top == null) {
            return -1;
        } else if (top.next == null) {
            int x = top.data;
            top = null;
            return x;
        } else {
            int x = top.data;
            top = top.next;
            return x;
        }
    }

    public void display() {
        while (top != null) {
            System.out.print(top.data + " ");
            top = top.next;
        }
    }
}

public class StackUsingLL {
    public static void main(String[] args) {
        MyStackCustom s = new MyStackCustom();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        s.push(5);
        s.display();
    }
}
