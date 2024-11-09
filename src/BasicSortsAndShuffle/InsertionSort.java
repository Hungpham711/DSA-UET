package BasicSortsAndShuffle;

public class InsertionSort {

    public static void sort(Object[] a) {
        for (int  i = 1; i < a.length; i++) {
            Object tmp = a[i];
            int j = i - 1;
            while (j >= 0 && compare(tmp, a[j]) < 0){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }

    public static void sort(Object[] a, int l, int r) {
        for (int  i = l + 1; i <= r; i++) {
            Object tmp = a[i];
            int j = i - 1;
            while (j >= l && compare(tmp, a[j]) < 0){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
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
}
