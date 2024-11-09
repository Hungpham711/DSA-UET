package src.PriorityQueueAndHeapSort;

public class Heapsort {


    public static void sortByHeapify(Object[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }

        for (int n = a.length - 1; n >= 0; n--) {
            swap(a, n, 0);
            heapify(a, n,0);
        }
    }

    public static void sortBySink(Object[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }

        for (int n = a.length - 1; n >= 0; n--) {
            swap(a, n, 0);
            heapify(a, n,0);
        }
    }

    private static void heapify(Object[] a, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n && compare(a[largest], a[l]) < 0) {
            largest = l;
        }
        if (r < n  && compare(a[largest], a[r]) < 0) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            heapify(a, n, largest);
        }
    }

    private static void sink(Object[] a, int n, int i) {
        while (2 * i + 1 < n) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int largest = l;
            if (r < n && compare(a[l], a[r]) < 0) {
                largest = r;
            }
            if (compare(a[largest], a[i]) < 0) {
                break;
            }
            swap(a, largest, i);
            i = largest;
        }
    }

    private static int compare(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return Integer.compare((int) a, (int) b);
        }

        if (a instanceof Double && b instanceof Double) {
            return Double.compare((double) a, (double) b);
        }

        return ((String) a).compareTo((String)b);
    }

    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
