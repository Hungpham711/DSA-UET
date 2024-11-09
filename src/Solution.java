package src;

import java.io.*;
import java.util.*;

public class Solution {
    public static void solve(String s) {
        s = s.replaceAll("[.,!?;']", "");
        String[] a = s.split("\\s+");
        Arrays.sort(a);
        List<Integer> count = new ArrayList<>();
        List<String> words = new ArrayList<>();
        int idx = 0;
        words.add(a[0]);
        count.add(1);
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i].equals(a[i - 1])) {
                count.set(idx, count.get(idx) + 1);
            }
            else {
                idx++;
                words.add(a[i]);
                count.add(1);
            }
        }

        for (int i = 0; i <= idx; i++) {
            System.out.println(words.get(i) + "  " + count.get(i));
        }
    }
}