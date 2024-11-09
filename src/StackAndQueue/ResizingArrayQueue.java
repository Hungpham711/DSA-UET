package StackAndQueue;

public class ResizingArrayQueue<T> {
    private T[] a;
    private int num;

    private int front;
    private int back;

    public ResizingArrayQueue() {
        a = (T[]) new Object[7];
        num = 0;

        front = back = -1;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean isFull() {
        return num == a.length;
    }

    public int size() {
        return num;
    }

    public void enqueue(T data) {
        if (isFull()) {
            resizeArray(a.length * 2);
        }
        else if (isEmpty()) {
            front++;
        }

        back = (back+ 1) % a.length;
        a[back] = data;
        num++;
    }

    public T dequeue() {
        T data = a[front];
        a[front] = null;
        front = (front + 1) % a.length;
        num--;

        if (size() > 0 && size() == a.length / 4) {
            resizeArray(a.length / 2);
        }

        return data;
    }

    public T front() {
        return a[front];
    }

    private void resizeArray(int n) {
        assert n >= a.length;

        T[] tmpArr = (T[]) new Object[n];
        for (int i = 0; i < size(); i++) {
            tmpArr[i] = a[(front + i) % a.length];
        }

        front = 0;
        back = num - 1;
        a = tmpArr;
    }
}
