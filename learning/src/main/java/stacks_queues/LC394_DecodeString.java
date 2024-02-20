package stacks_queues;

import java.util.Stack;

public class LC394_DecodeString {
    /*
    Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
     */

    /*
    Apporach : use two stacks, one to store numbers and snother to store only String
    take one string to store the result res
    have one index which always increase if we add anything to stack or res
    --check if char is digit  then store in num also ensure that we use base 10 so that we can get all digit rather just digit default increase index by 1
    -- check if char is [ then add the res default increase index by 1
    -- check if the char is ] then
        -- pop the count from num stack
        -- pop the strong and store in string buider from Str stack
        -- now append res to builder n times which is count fetched from num stack
        -- reset the res with builder string and default increase index by 1
    -- if char is char then store the char in res and default increase index by 1

     */
    public static String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        // strng to store results
        String res="";
        int index =0;

        while(index<s.length()){
            // check if char is digit  then store in num also ensure that we use base 10 so that we can get all digit rather just digit default increase index by 1
            if(Character.isDigit(s.charAt(index))){
                int cnt =0;
                while(Character.isDigit(s.charAt(index))){
                    cnt = 10*cnt+(s.charAt(index)-'0');
                    index++;
                }
                num.push(cnt);
            } else if (s.charAt(index)=='[') {//check if char is [ then add the res default increase index by 1
                str.push(res); // we don't need to add braces otherwise unnecessary operation needs to be performed to remove opening braces
                res = "";
                index++;
            }else if(s.charAt(index)==']'){
             /*
             -- check if the char is ] then
        -- pop the count from num stack
        -- pop the strong and store in string buider from Str stack
        -- now append res to builder n times which is count fetched from num stack
        -- reset the res with builder string and default increase index by 1
              */
                int rep = num.pop();
                StringBuilder build = new StringBuilder(str.pop()); // pop the str stack values and store in the builder
                for(int i=0;i<rep;i++){
                    build.append(res);
                }
                res = build.toString();
                index++;
            }else{
                res +=s.charAt(index);
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
