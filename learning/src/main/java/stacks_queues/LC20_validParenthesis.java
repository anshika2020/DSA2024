package stacks_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20_validParenthesis {
    /*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
     */
    public static boolean isValid(String s){
        // check edge case
        if(s.length()<2) return false;
        // now take one map to have all three types of braces
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        // now take one stack ot keep pushing the char and compare with map
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            char temp = 0;
            // now check if map contains the ch then push the ch in st and pop is not empty
            if(map.containsKey(ch)){
                if(st.empty()){
                    st.push('#');
                }else{
                   temp = st.pop();
                }
                // now check if st top element and map element is not same then return false -- fast fail
                if(map.get(ch) != temp){
                    return false;
                }
            }
            st.push(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}}"));
    }
}
