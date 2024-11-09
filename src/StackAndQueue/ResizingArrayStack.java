package src.StackAndQueue;

public class ResizingArrayStack<T> {
    private T[] a;
    private int num;

    public ResizingArrayStack() {
        a = (T[]) new Object[7];
        num = 0;
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

    public void push(T data) {
        if (size() == a.length) {
            resizeArray(a.length * 2);
        }
        a[num++] = data;
    }

    public T pop() {
        T data = a[num - 1];
        a[num--] = null;

        if (size() > 0 && size() == a.length / 4) {
            resizeArray(a.length / 2);
        }

        return data;
    }

    public T peek() {
        return a[num - 1];
    }


    private void resizeArray(int n) {
        assert n >= size();

        T[] tmpArr = (T[]) new Object[n];
        for (int i = 0; i < size(); i++) {
            tmpArr[i] = a[i];
        }
        a = tmpArr;
    }
}
