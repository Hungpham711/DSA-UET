package DoPhucTapThuatToan;

public class Bai_1419 {


    private static Pair result(double[][] a, int l, int r) {

        int m = (l + r) / 2;

        if (m == 0 || m == a.length - 1) {
            return new Pair(m, m);
        }

        // Tìm chỉ số phần tử bé nhất trên cột
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][m] < a[idx][m]) {
                idx = i;
            }
        }


        if (m - 1 >= 0 && m + 1 <= a.length - 1 && a[idx][m - 1] > a[idx][m] && a[idx][m] < a[idx][m + 1]) {
            return new Pair(idx, m);
        }

        // Nếu phần tử bên trái nhỏ hơn a[idx][m] -> Tìm kiếm tiếp bên trái
        if (m - 1 >= 0 && a[idx][m - 1] <= a[idx][m]) {
            return result(a, l, m - 1);
        }

        return result(a, m + 1, r);
    }

    public static String solve(double[][] a) {
        Pair answer = result(a, 0, a[0].length - 1);
        return "i = " + answer.getFirst() + ", j = " + answer.getSecond();
    }

    private static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
/*
int[][] a = {
            {10, 8, 10, 10},
            {14, 12, 10, 10},
            {15, 13, 12, 11},
            {16, 17, 19, 20}
        };
 */