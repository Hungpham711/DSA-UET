package src.StackAndQueue;

public class MyQueue<T> {
    private Node first, last;

    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue (T data) {
        Node newNode = new Node(data);


        if (isEmpty()) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            last = last.next;
        }
    }

    public T front() {
        return first.data;
    }

    public T dequeue() {
        T data = first.data;
        first = first.next;
        return data;
    }
}
