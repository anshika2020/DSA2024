package stacks_queues;

import java.util.Arrays;
import java.util.Stack;

public class LC316_RemoveDupeLetters {

    /*
    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order
 among all possible results.
Example 1:
Input: s = "bcabc"
Output: "abc"
Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
Constraints:
1 <= s.length <= 104
s consists of lowercase English letters.
     */

    // approach : use stack to keep track of character, store the last occurence of character of s.charAt(i) -'a' =i to maintain the lexicographical order, also have one boolean array back track the visited characters
    public static String removeDuplicateLetters(String str){
        if(str.length()<1) return str;

        // create the array to store the last occrence of character in lexicograpphical order, Note ASCII char set is 128
        int[] lastOcc = new int[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
          lastOcc[ch-'a'] = i;
        }
        System.out.println("arr :" + Arrays.toString(lastOcc));
        boolean [] visited = new boolean[26];
        Stack<Character> st = new Stack<>();
        // now iterate through the string
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            // now check if the character s visited then continue
            if(visited[c-'a']){
                continue;
            }
            // iterate till stack is not empty and current char is less than stack peek(), also check if i is less than stack last elemnt -'a' in lastOCcc
            while(!st.isEmpty() && c < st.peek() && i<lastOcc[st.peek()-'a']){
                visited[st.pop() - 'a'] = false;
            }
            st.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder build = new StringBuilder();
        // now get all elements from the stack
       for(char s : st){
            build.append(s);
        }

        return build.toString();
    }

    public static void main(String[] args) {
        System.out.println(" str : "+ removeDuplicateLetters("bcabc"));
    }
}
