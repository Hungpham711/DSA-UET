package src.DoPhucTapThuatToan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bai_1414 {

    public static void solve(int[] a, int sum) {
        Set<String> se = new HashSet<>();

        Arrays.sort(a);

        for (int i = 0; i < a.length - 3; i++) {
            for (int j = i + 1; j < a.length - 2; j++) {
                int l = j + 1, r = a.length - 1;
                while (l < r) {
                    if (!se.contains(a[i] + " " + a[j] + " " + a[l] + " " + a[r]) && a[l] + a[r] + a[i] + a[j] == sum) {
                        System.out.println(a[i] + " + " + a[l] + " + " + a[r] + " = " + sum);
                        se.add(a[i] + " " + a[j] + " " + a[l] + " " + a[r]);
                        l++;
                        r--;
                    }
                    else if (a[l] + a[r] + a[i] + a[j] < sum) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
    }
}
