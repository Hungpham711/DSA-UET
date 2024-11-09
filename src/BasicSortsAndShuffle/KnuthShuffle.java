package src.BasicSortsAndShuffle;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle {
    public static void shuffle(Object[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            int r = StdRandom.uniformInt(i + 1); // random chi so tu 0 -> i

            Object tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
}
