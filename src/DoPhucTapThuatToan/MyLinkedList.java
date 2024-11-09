package DoPhucTapThuatToan;

public class MyLinkedList<T> {

    private Node head = null;

    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addHead(T data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void addTail(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void addTailByRecursion(T data) {
        head = addTailRecursively(head, data);
    }

    private Node addTailRecursively(Node cur, T data) {
        if (cur == null) {
            return new Node(data);
        }
        cur.next = addTailRecursively(cur.next, data);
        return cur;
    }

    public void addMiddle(T data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            addHead(data);
            return;
        }

        Node cur = head;
        Node prev = null;

        int i = 0;
        for ( ; i < index; i++) {
            if (cur == null) {
                System.out.println("Out of linkedList");
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        newNode.next = cur;
        prev.next = newNode;
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }
        Node cur = head;
        Node prev = null;

        int i = 0;
        for ( ; i < index; i++) {
            if (cur == null) {
                System.out.println("Out of linkedList");
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        cur.next = null;
    }

    public void removeFirst(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (cur.data.equals(data)) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public void removeAll(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
        }

        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (cur.data.equals(data)) {
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }
            cur = cur.next;
        }
    }

    public void print() {
        if (head == null) {
            return;
        }

        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public void printByRecursion(Node start) {
        if (start == null) {
            return;
        }
        System.out.println(start.data + " ");
        printByRecursion(start.next);
    }
}
