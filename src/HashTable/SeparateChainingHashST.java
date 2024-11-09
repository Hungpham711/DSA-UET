package HashTable;
import SymbleTable.*;
import com.sun.jdi.Value;

import java.security.Key;

public class SeparateChainingHashST<Key, Value> {
    private int n;
    private int m;
    private MySequentialSearch<Key, Value>[] st;

    SeparateChainingHashST(int m) {
        this.m = m;
        st = new MySequentialSearch[m];
        for (int i = 0; i < m; i++) {
            st[i] = new MySequentialSearch();
        }
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = chains;
        this.n = temp.n;
        this.st = temp.st;
    }


    private int hash(Key key) {
        int h = key.hashCode();
        h = h ^ (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m - 1);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }

        if (n / m >= 10) {
            resize(2 * m);
        }

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, value);
    }

    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        if (m * 2 >= n) {
            resize(m / 2);
        }
    }
}
