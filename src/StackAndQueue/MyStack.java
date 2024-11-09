package StackAndQueue;

public class MyStack<T> {
    private Node first = null;

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

    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
    }

    public T pop() {
        T tmp = first.data;
        first.next = first;
        return tmp;
    }

    public T peek() {
        return first.data;
    }
}
