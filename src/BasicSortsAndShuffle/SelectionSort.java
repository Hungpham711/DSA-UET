package src.BasicSortsAndShuffle;

public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    public static void sort(double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            double tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    public static void sort(String[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            String tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
