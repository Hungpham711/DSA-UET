package src.QuicksortAndMergesort;

public class Mergesort {

    private static final int CUTOFF = 10;

    public static void sort(Object[] a) {
        Object[] tmp = new Object[a.length];
        mergesort(a, tmp, 0, a.length - 1);
    }

    private static void merge(Object[] a, Object[] tmp, int l, int m, int r) {
        for (int i = l; i <= r; i++) {
            tmp[i] = a[i];
        }

        int idx1 = l, idx2 = m + 1;
        for (int i = l; i <= r; i++) {
            if (idx1 > m) {
                a[i] = tmp[idx2++];
            }
            else if (idx2 > r) {
                a[i] = tmp[idx1++];
            }
            else if (compare(tmp[idx1], tmp[idx2]) <= 0) {
                a[i] = tmp[idx1++];
            }
            else {
                a[i] = tmp[idx2++];
            }
        }
    }


    private static void mergesort(Object[] a, Object[] tmp, int l, int r) {
        if (l >= r) {
            return;
        }

//        // Improvement 1
//        if (r - l + 1 <= CUTOFF) {
//            InsertionSort.sort(a, l, r);
//            return;
//        }

        int m = (l + r) / 2;
        mergesort(a, tmp, l, m);
        mergesort(a, tmp, m + 1, r);

//        // Improvement 2
//        if (compare(a[m], a[m + 1]) < 0) {
//            return;
//        }

        merge(a, tmp, l, m, r);
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
}
