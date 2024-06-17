package Queue;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int a) {
        data = a;
        next = null;
    }
}

class MyQueueCustom {
    QueueNode front, rear;

    // Function to push an element into the queue.
    void push(int a) {
        QueueNode newNode = new QueueNode(a);
        if (front == null) {
            front = newNode;
            rear = front;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    // Function to pop front element from the queue.
    int pop() {
        if (front == null) {
            return -1;
        }
        int data = front.data;
        front = front.next;
        return data;
    }

    public void display() {
        while (front != null) {
            System.out.print(front.data + " ");
            front = front.next;
        }
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
        MyQueueCustom q = new MyQueueCustom();
        q.push(78);
        System.out.println("delete data = " + q.pop());
        System.out.println("delete data = " + q.pop());
        System.out.println("delete data = " + q.pop());
        q.push(93);
        System.out.println("delete data = " + q.pop());
        System.out.println("delete data = " + q.pop());
        q.push(28);
        q.display();
    }
}
