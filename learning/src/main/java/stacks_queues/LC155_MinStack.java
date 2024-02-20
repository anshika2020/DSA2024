package stacks_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC155_MinStack {

    /*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
     */

    public String[] minStackOperations(String[] operations, List<int[]> values){
        String[] res = new String[operations.length];
        MinStack stack = new MinStack();
        for(int i=0;i<operations.length;i++){
            if(operations[i] =="push"){
                 stack.push(values.get(i)[0]);
                res[i] = null;
            }else if(operations[i] =="pop"){
                stack.pop();
            }else if(operations[i] =="top"){
                res[i] = String.valueOf(stack.top());
            }else if(operations[i] =="getMin"){
                res[i] = String.valueOf(stack.getMin());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] operartion = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        List<int[]> val = new ArrayList<>();
        val.add(new int[]{});
        val.add(new int[]{-2});
        val.add(new int[]{0});
        val.add(new int[]{-3});
        val.add(new int[]{});
        val.add(new int[]{});
        val.add(new int[]{});
        val.add(new int[]{});
        LC155_MinStack obj = new LC155_MinStack();
        System.out.printf(" Values: " + Arrays.toString(obj.minStackOperations(operartion, val)));


    }

    class MinStack {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> minSt = new Stack<>();
        public MinStack() {

        }

        public void push(int val) {
            st.push(val);
            if(minSt.isEmpty() || val<=minSt.peek()){
                minSt.push(val);
            }
        }

        public void pop() {
            if(st.peek().equals(minSt.peek())){
                minSt.pop();
            }
            st.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return minSt.peek();
        }
    }
}
