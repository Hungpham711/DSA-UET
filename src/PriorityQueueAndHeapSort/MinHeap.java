package src.PriorityQueueAndHeapSort;

public class MinHeap {
    private int[] pq;
    private int n;

    public MinHeap(int n) {
        pq = new int[n];
        this.n = 0;
    }

    public MinHeap(int[] pq) {
        this.pq = new int[pq.length];
        for (int i = 0; i < pq.length; i++) {
            this.pq[i] = pq[i];
        }
        this.n = pq.length;
        for (int i = n / 2; i >= 0; i--)
            sink(i);
    }

    public int min() {
        return pq[0];
    }

    public void insert(int x) {
        if (n == pq.length) {
            resize(2 * pq.length);
        }
        pq[n] = x;
        swim(n);
        n++;
    }

    public int delMin() {
        int min = pq[0];
        swap(pq, n - 1, 0);
        n--;
        pq[n] = 0;
        sink(0);
        if (n > 0 && n == pq.length / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    private void swim(int i) {
        while (i > 0 && pq[(i - 1) / 2] > pq[i]) {
            swap(pq, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private void sink(int i) {
        while (2 * i + 1 < n) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int smallest = l;

            if (r < n && pq[r] < pq[smallest]) {
                smallest = r;
            }
            if (pq[i] <= pq[smallest]) {
                break;
            }
            swap(pq, i, smallest);
            i = smallest;
        }
    }

    private void resize(int capacity) {
        int[] tmp = new int[capacity];

        for (int i = 0; i < n; i++) {
            tmp[i] = pq[i];
        }
        pq = tmp;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
