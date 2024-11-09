package src.HashTable;

import com.sun.jdi.Value;

import java.security.Key;

public class LinearProbingHashST<Key, Value> {
    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    LinearProbingHashST(int m) {
        this.n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m-1);
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> tmp = new LinearProbingHashST<Key, Value>(capacity);

        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                tmp.put(keys[i], vals[i]);
            }
        }
        keys = tmp.keys;
        vals = tmp.vals;
        this.m = capacity;
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
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public void put(Key key, Value val) {

        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m / 2) {
            resize(m * 2);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }

        keys[i] = key;
        vals[i] = val;
        n++;
    }



    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                break;
            }
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valueToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valueToRehash);
        }
        n--;

        if (n > 0 && n <= m / 8) {
            resize(m / 2);
        }
    }

 }
