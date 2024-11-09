package src.QuicksortAndMergesort;

public class Quicksort {
    private static final int CUTOFF = 10;

    private static int compare(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return Integer.compare((int) a, (int) b);
        }

        if (a instanceof Double && b instanceof Double) {
            return Double.compare((double) a, (double) b);
        }

        return ((String) a).compareTo((String)b);
    }

    private static int medianOf3(Object[] a, int i, int j, int k) {
        if (compare(a[i], a[j]) < 0) {
            if (compare(a[j], a[k]) < 0) return j; // a[i] < a[j] < a[k]
            else if (compare(a[i], a[k]) < 0) return k; // a[i] < a[k] < a[j]
            else return i; // a[k] < a[i] < a[j]
        }
        else {
            if (compare(a[j], a[k]) > 0) return j; // a[i] > a[j] > a[k]
            else if (compare(a[i], a[k]) > 0) return k;  // a[i] > a[k] > a[j]
            else return i; // a[k] > a[i] > a[j]
        }
    }

    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partitionByLomuto(Object[] a, int l, int r) {
        Object pivot = a[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (compare(a[j], pivot) <= 0) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }


    private static int partitionByHoare(Object[] a, int l, int r) {
        Object pivot = a[l];
        while (true) {
            while (compare(a[l], pivot) < 0) {
                l++;
            }
            while (compare(a[r], pivot) > 0) {
                r--;
            }
            if (l >= r) {
                return r;
            }
            swap(a, l, r);
            l++;
            r--;
        }
    }


    private static void quicksortByHoare(Object[] a, int l, int r) {
        if (l >= r) {
            return;
        }
//        // Improvement 1
//        if (r - l + 1 <= CUTOFF)
//        {
//            InsertionSort.sort(a, l, r);
//            return;
//        }

        int median = medianOf3(a, l, (l + r) / 2, r);
        swap(a, l, median);

        int p = partitionByHoare(a, l, r);
        quicksortByHoare(a, l, p);
        quicksortByHoare(a, p + 1, r);
    }


    private static void quicksortByLomuto(Object[] a, int l, int r) {
        if (l >= r) {
            return;
        }
//        if (r - l + 1 <= CUTOFF)
//        {
//            InsertionSort.sort(a, l, r);
//            return;
//        }

        int p = partitionByLomuto(a, l, r);
        quicksortByLomuto(a, l, p - 1);
        quicksortByLomuto(a, p + 1, r);
    }

    public static void sortbyLomuto(Object[] a) {
        quicksortByLomuto(a, 0, a.length - 1);
    }

    public static void sortByHoare(Object[] a) {
        quicksortByHoare(a, 0, a.length - 1);
    }

    public static void sortBy3Ways(Object[] a, int l, int r)
    {
        if (r <= l) return;
        int lower = l, higher = r;
        Object pivot = a[l];
        int i = l;
        while (i <= higher)
        {
            int cmp = compare(a[i], pivot);
            if      (cmp < 0) swap(a, lower++, i++);
            else if (cmp > 0) swap(a, i, higher--);
            else              i++;
        }
        sortBy3Ways(a, l, lower - 1);
        sortBy3Ways(a, higher + 1, r);
    }
}

/*

 */