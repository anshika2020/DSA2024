package stacks_queues;

import java.util.Stack;

public class LC_150_EvaluateReversePloishNotation {
    /*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.

Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
     */

    public static int evalRPN(String[] tokens) {
        if (tokens.length < 2) return Integer.parseInt(tokens[0]);

        // now ierate through the tokens and perform operation  and push result to the stack if the ith element is one of the operand else simply add in the stack
        //TC and SC: O(n)
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            } else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (s.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a * b);
            } else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {

        System.out.println("evalRPN :"+ evalRPN(new String[] {"4","13","5","/","+"}) );
    }
}