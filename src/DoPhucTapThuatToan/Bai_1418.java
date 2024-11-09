package DoPhucTapThuatToan;

public class Bai_1418 {
    private static int result(double[] a, int l, int r) {
        if (l == r) {
            return l;
        }

        int m = (l + r) / 2;

        System.out.println(l + "  " + r + "  " + a[m]);

        // Nếu dãy tăng dần -> trả về phần tủ đầu tiên. Nếu dãy giảm dần -> trả về phần tử cuối cùng
        if ((m == 0 && a[m] < a[m+1]) || (m == a.length - 1 && a[m] < a[m-1])) {
            return m;
        }


        if (a[m-1] > a[m] && a[m] < a[m+1]) {
            return m;
        }

        // Nếu phần tử mid - 1 nhỏ hơn mid -> Rút ngắn thời gian tìm kiếm
        if (a[m-1] < a[m]) {
            return result(a, l, m - 1);
        }

        // Nếu không tìm thấy bên trái thì tìm tiếp bên phải
        return result(a, m + 1, r);
    }

    public static int solve(double[] a) {
        return result(a, 0, a.length - 1);
    }
}
