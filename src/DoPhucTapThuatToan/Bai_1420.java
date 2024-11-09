package src.DoPhucTapThuatToan;

public class Bai_1420 {
    private static int findPeak(int[] a, int l, int r) {
        if (l == r) {
            return l;
        }
        int m = (l + r) / 2;

        if (a[m - 1] < a[m] && a[m] > a[m + 1]) {
            return m;
        }
        if (a[m - 1] > a[m]) {
            return findPeak(a, l, m - 1);
        }
        return findPeak(a, m + 1, r);
    }

    private static int binary_search(int[] a, int l, int r, int x, boolean left) {
        if (left) {
            if (l >= r) {
                return -1;
            }

            int m = (l + r) / 2;

            if (a[m] == x) {
                return m;
            }

            if (a[m] > x) {
                return binary_search(a, l, m - 1, x, true);
            }
            return binary_search(a, m + 1, r, x, true);
        }
        else {
            if (l >= r) {
                return -1;
            }

            int m = (l + r) / 2;

            if (a[m] == x) {
                return m;
            }

            if (a[m] > x) {
                return binary_search(a, m + 1, r, x, false);
            }
            return binary_search(a, l, m - 1, x, false);
        }
    }

    public static int solve(int[] a, int x) {
        int idx = findPeak(a, 0, a.length - 1);
        int result = binary_search(a, 0, idx, x, true);
        if (result != -1) {
            return result;
        }
        return binary_search(a, idx, a.length - 1, x, false);
    }
}
