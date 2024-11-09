package SymbleTable;

public class MyBinarySearch<Key, Value> {
     private Key[] keys;
     private Value[] vals;
     private int n = 0;


     public MyBinarySearch(int capacity) {
         keys = (Key[]) new Comparable[capacity];
         vals = (Value[]) new Object[capacity];
     }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < n && keys[i].equals(key)) {
            return vals[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
         if (value == null) {
             delete(key);
             return;
         }

         for (int i = 0; i < n; i++) {
             if (keys[i].equals(key)) {
                 vals[i] = value;
                 return;
             }
         }

         if (n == keys.length) {
             resize(2 * n);
         }

         int i = rank(key);
         for (int j = n; j > i; j--) {
             keys[j] = keys[j - 1];
             vals[j] = vals[j - 1];
         }
         keys[i] = key;
         vals[i] = value;
         n++;
    }

    public void delete(Key key) {
         int i = rank(key);
         for (int j = i; j < n - 1; j++) {
             keys[j] = keys[j + 1];
             vals[j] = vals[j + 1];
         }
         n--;
         keys[n] = null;
         vals[n] = null;

         if (n > 0 && n == keys.length / 4) {
             resize(keys.length / 2);
         }
    }

    private int rank(Key key) {
         int l = 0, r = n - 1;
         while (l <= r) {
             int m = (l + r) / 2;
             int cmp = compare(key, keys[m]);
             if (cmp == 0) {
                 return m;
             }
             else if (cmp < 0) {
                 r = m - 1;
             }
             else {
                 l = m + 1;
             }
         }
         return l;
    }

    private int compare(Key key, Key otherKey) {
         int cmp = key.toString().compareTo(otherKey.toString());
         if (cmp < 0) {
             return  - 1;
         }
         if (cmp > 0) {
             return 1;
         }
         return 0;
    }

    private void resize(int capacity) {
        Key[] tmpK = (Key[]) new Comparable[capacity];
        Value[] tmpV = (Value[]) new Object[capacity];

        for (int i = 0; i < n; i++) {
            tmpK[i] = keys[i];
            tmpV[i] = vals[i];
        }

        keys = tmpK;
        vals = tmpV;
    }
}
