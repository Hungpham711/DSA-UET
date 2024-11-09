package DoPhucTapThuatToan;

public class Bai_1417 {
    public static double solve(double[] a) {
        double max = (double) -1e9;
        double min = (double) 1e9;
        for (int i = 0; i < a.length; i++) {
            max = (double) Math.max(a[i], max);
            min = (double) Math.min(a[i], min);
        }
        return max - min;
    }
}
