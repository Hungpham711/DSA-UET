package src.DoPhucTapThuatToan;

public class Bai_1422 {
    private static int[] fibo;

    private static int fibonaci(int n) {
        fibo = new int[n + 2];
        fibo[0] = fibo[1] = 1;
        if (n < 2) {
            return n;
        }
        int i = 2;
        for (i = 2; i < n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            //System.out.println(i + " " + fibo[i] + "  ddd");
            if (fibo[i] >= n) {
                break;
            }
        }
        return i; // Trả về phần tử mà fibo[i] >= n
    }

    private static int index(int[] a, int x) {
        int offset = -1;
        int current = 0;


        for (int i = fibonaci(a.length); i >= 1; i--) {
            if (a[current] == x) {
                return current;
            }
            if (a[current] > x) {
                offset = current;
            }
            current = Math.min(offset + fibo[i - 1], a.length - 1);
        }
        return -1;
    }

    public static int solve(int[] a, int x) {
        return index(a, x);
    }
}


/*
current = min(offset + fibo[k - 1], n);
 */