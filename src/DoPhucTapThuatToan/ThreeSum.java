package DoPhucTapThuatToan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {

    public static void solve(int[] a, int sum) {
        Set<String> se = new HashSet<>();

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1, r = a.length - 1;
            while (l < r) {
                if (!se.contains(a[i] + " " + a[l] + " " + a[r]) && a[l] + a[r] + a[i] == sum) {
                    System.out.println(a[i] + " + " + a[l] + " + " + a[r] + " = " + sum);
                    se.add(a[i] + " " + a[l] + " " + a[r]);
                    l++;
                    r--;
                }
                else if (a[l] + a[r] + a[i] < sum) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }
    }
}
