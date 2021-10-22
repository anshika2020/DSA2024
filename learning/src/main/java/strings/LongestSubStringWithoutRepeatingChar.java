package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
    /*
    3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

     */

    public int lengthOfLongestSubstring(String s) {

        int i=0, j=0;

        int maxLength=0;
        Set<Character> set= new HashSet<>();

        while(i<s.length() && j<s.length()){

            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            else{
                set.add(s.charAt(j));
                maxLength=Math.max(maxLength, j-i+1);
                j++;

            }

        }

        return maxLength;
    }
}
