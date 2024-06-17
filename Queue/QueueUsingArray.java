package Queue;

class MyQueue {

    int front, rear;
    int arr[] = new int[5];
    int count = 0;

    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void queueEnqueue(int x) {
        if (count == arr.length) {
            System.out.println("\nQueue is full.");
            System.exit(1);
        } else {
            int n = arr.length;
            arr[rear % n] = x; // doing modulo because of circular array
            rear++;
            count++;
        }
    }

    // Function to pop an element from queue and return that element.
    int queueDequeue() {
        if (front == rear) {
            System.out.println("\nQueue is empty!");
            return -1; // queue is empty
        }
        int copyData = arr[front % arr.length];
        arr[front % arr.length] = -1;
        front++;
        count--;
        return copyData;
    }

    void display() {
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i % arr.length] + " ");
        }
    }
}

public class QueueUsingArray {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.queueEnqueue(1);
        q.queueEnqueue(2);
        q.queueEnqueue(3);
        q.queueEnqueue(4);
        q.queueEnqueue(5);
        q.queueDequeue();
        q.queueEnqueue(6);

        System.out.println("Queue before deletion = ");
        q.display();
        q.queueEnqueue(9);
        // System.out.println("\nThe first element to be deleted = " +
        // q.queueDequeue());
        // System.out.println("Queue after deletion = ");
        // q.display();
    }
}
