package src.DoPhucTapThuatToan;

import java.util.Arrays;

public class Bai_1416 {
    public static double solve(double[] a) {
        Arrays.sort(a, 0 ,a.length);
        double res = Math.abs(a[1] - a[0]);
        for (int i = 2; i < a.length; i++) {
            res = Math.min(res, Math.abs(a[i] - a[i-1]));
        }
        return Math.round(1.0 * res * 100) / 100.0;
    }
}
