package SymbleTable;

import StackAndQueue.MyQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MySequentialSearch<Key,Value> {
    private int n = 0;
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        for (Node i = first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }

        for (Node i = first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value);
        newNode.next = first;
        first = newNode;

        n++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        for (Node i = first; i != null; i = i.next) {
            q.add(i.key);
        }
        return q;
    }

    private Node delete(Node first, Key key) {
        if (first.key.equals(key)) {
            n--;
            return first.next;
        }
        first.next = delete(first.next, key);
        return first;
    }
}
