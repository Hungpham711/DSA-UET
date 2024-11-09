package StackAndQueue;

import java.util.Stack;

public class ExpressionConverter {

    private static int priority(char op) {
        if (op == '^') {
            return 3;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        return 0;
    }

    private static int calculate(char op, int a, int b) {
        if (op == '^') {
            return (int) Math.pow(a, b);
        }

        if (op == '*') {
            return a * b;
        }

        if (op == '/') {
            return a / b;
        }

        if (op == '+') {
            return a + b;
        }

        if (op == '-') {
            return a - b;
        }

        return 0;
    }

    // Tien to -> Trung to
    public static String prefixToInfix(String s) {
        Stack<String> st = new Stack<>();
        String res = "";

        // *+AB-CD -> ((A+B)*(C-D))
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                st.push(ch + "");
            }
            else {
                String op1 = st.pop();
                String op2 = st.pop();

                res = "(" + op1 + ch + op2 + ")";
                st.push(res);
            }
        }
        return res;
    }

    // Trung to -> Tien to
    public static String infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";

        return res;
    }

    // Hau to -> Trung to
    public static String postfixToInfix(String s) {
        Stack<String> st = new Stack<>();
        String res = "";

        // AB+CD-* -> ((A+B)*(C-D))
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                st.push(ch + "");
            }
            else {
                String op1 = st.pop();
                String op2 = st.pop();

                res = "(" + op2 + ch + op1 + ")";
                st.push(res);
            }
        }
        return res;
    }

    // Trung to -> Hau to
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isAlphabetic(ch)) {
                res += ch;
            }

            else if (ch == '(') {
                st.push('(');
            }

            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res += st.pop();
                }
                st.pop();
            }

            else {
                while (!st.isEmpty() && priority(st.peek()) >= priority(ch)) {
                    res += st.pop();
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }

    // Tien to -> Hau to
    public static String prefixToPostfix(String s) {
        Stack<String> st = new Stack<>();
        String res = "";

        // *+AB-CD -> AB+CD-*
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                st.push(ch + "");
            }
            else {
                String op1 = st.pop();
                String op2 = st.pop();

                res = op1 + op2 + ch;
                st.push(res);
            }
        }
        return res;
    }

    // Hau to -> Tien to
    public static String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();
        String res = "";

        // AB+CD-* -> *+AB-CD
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                st.push(ch + "");
            }
            else {
                String op1 = st.pop();
                String op2 = st.pop();

                res = ch + op2 + op1;
                st.push(res);
            }
        }
        return res;
    }

    // Tinh gia tri Tien to
    public static int evaluatePrefix(String s) {
        Stack<Integer> st = new Stack<>();

        // -+8/632 -> 8
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                st.push((ch - '0'));
            }
            else {
                int op1 = st.pop();
                int op2 = st.pop();

                int res = calculate(ch, op1, op2);
                st.push(res);
            }
        }
        return st.peek();
    }

    // Tinh gia tri Hau to
    public static int evaluatePostfix(String s) {
        Stack<Integer> st = new Stack<>();

        // 231*+9– -> -4
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                st.push((ch - '0'));
            }
            else {
                int op1 = st.pop();
                int op2 = st.pop();

                int res = calculate(ch, op1, op2);
                st.push(res);
            }
        }
        return st.peek();
    }
}
