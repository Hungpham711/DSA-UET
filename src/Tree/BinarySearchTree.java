package src.Tree;

public class BinarySearchTree<Key,Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        public int size;

        Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {

        if (node == null) {
            return null;
        }
        int cmp = compare(key, node.key);
        if (cmp > 0) {
            return get(node.right, key);
        }
        else if (cmp < 0) {
            return get(node.left, key);
        }
        else {
            return node.value;
        }
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key,value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = compare(key, node.key);
        if (cmp > 0) {
            node.right =  put(node.right, key, value);
        }
        else if (cmp < 0) {
            node.left =  put(node.left, key, value);
        }
        else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.right) + size(node.left);
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.right) + size(node.left);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        
        int cmp = compare(key, node.key);
        if (cmp > 0) {
            return delete(node.right, key);
        }
        else if (cmp < 0) {
            return delete(node.left, key);
        }
        else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            Node tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;

        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return min(x.right);
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
}
