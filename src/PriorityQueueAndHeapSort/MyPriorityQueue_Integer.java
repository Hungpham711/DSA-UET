package src.PriorityQueueAndHeapSort;

public class MyPriorityQueue_Integer<T> {
    private int[] pq;
    private int num;
    private int maxSize;

    public MyPriorityQueue_Integer(int n) {
        maxSize = n;
        pq = new int[maxSize];
        num = 0; // Ban đầu hàng đợi rỗng
    }

    public void insert(int x) {
        if (num == maxSize) {
            System.out.println("Hàng đợi đã đầy, không thể chèn thêm phần tử.");
            return;
        }

        int i = num - 1;
        while (i >= 0 && pq[i] > x) {
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = x;
        num++;
    }

    public int deleteMin() {
        if (num == 0) {
            System.out.println("Hàng đợi rỗng, không có phần tử nào để xóa.");
            return -1;
        }

        int minValue = pq[0];
        for (int i = 0; i < num - 1; i++) {
            pq[i] = pq[i + 1];
        }
        num--;
        return minValue;
    }
}
