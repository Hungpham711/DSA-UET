package src.StackAndQueue;

import java.util.Stack;

public class Bai_139 {

    public static String solve(String s) {
        Stack<String> st = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ')') {
                st.push(ch + "");
            }

            else {
                String op2 = st.pop();
                String op = st.pop();
                String op1 = st.pop();

                String res = "(" + op1 + op + op2 + ")";
                st.push(res);
            }
        }

        return st.peek();
    }
}
