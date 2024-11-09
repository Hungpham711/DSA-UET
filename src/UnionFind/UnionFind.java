package src.UnionFind;

public class UnionFind {
    private static int[] parent;
    private static int[] size;
    private static int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    public static int numbersOfComponents() {
        return count;
    }

    public static boolean isConnected(int a, int b) {
        return findParent(a) == findParent(b);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a != b) {
            if (size[a] < size[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
            size[a]++;
            count--;
        }
    }

}
