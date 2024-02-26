package stacks_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC716_MaxStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    List<Integer> list = new ArrayList<>();

    public LC716_MaxStack() {

    }

    public String[] minStackOperations(String[] operations, List<int[]> values){
        String[] res = new String[operations.length];
        LC716_MaxStack.MaxStack stack = new LC716_MaxStack.MaxStack();
        for(int i=0;i<operations.length;i++){
            if(operations[i] =="push"){
                stack.push(values.get(i)[0]);
                res[i] = null;
            }else if(operations[i] =="pop"){
                stack.pop();
            }else if(operations[i] =="top"){
                res[i] = String.valueOf(stack.top());
            }else if(operations[i] =="getMin"){
                res[i] = String.valueOf(stack.popMax());
            }
        }
        return res;
    }
    class MaxStack {
        public void push(int x) {
            st.push(x);
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }
        }

        public int pop() {
            if (maxStack.peek().equals(st.peek())) {
                maxStack.pop();
            }
            return st.pop();
        }

        public int top() {
            return st.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        // we need to use pop function to remove from both st and maxStack and put in
        // another stack
        public int popMax() {
            int removeElem = maxStack.peek();
            Stack<Integer> temp = new Stack<>();
            System.out.println(st.peek());
            // now ietrate till st.ppek is not equal to removeElem
            while (removeElem != st.peek()) {
                int res = pop();
                temp.push(res);
            }
            // pop the top element
            pop();
            // now pop from temp and use push method
            while (temp.size() > 0) {
                int res = temp.pop();
                push(res);
            }
            return removeElem;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */