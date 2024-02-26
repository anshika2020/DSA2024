package patterns.slidingWindow_pattern.medium;

import java.util.HashMap;

public class LC3_LogestSubstringWithoutRepeatingChar {
    /*
    Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
     */

    /*
    Approach: 1: sliding window
    1. get three vars start and end for window and max is to get the max length of unique chars substring
    2. Hashmap to store the char and index, the operation is constant hence using map is better choice , also easy to update the index if seen in map
    3. run while loop from end to s.length
            -- check if ch exist in the map then get the max of the indexes from start and map.get(c)+1, whatever the max, would update the start
            -- else put the char in the map
            -- get the max of substring from end-start+1, max
            -- increment end by 1

    4. return max
     */
    public static int lengthOfLongestSubstring(String s) {
         int start =0, end=0, max=0;
        HashMap<Character, Integer> map = new HashMap<>();
         while(end<s.length()){
             char c = s.charAt(end);
             if(map.containsKey(c)){
                 start = Math.max(start, map.get(c)+1);
             }
             map.put(c, end);
             max = Math.max(end-start+1, max);
             end++;
         }
         return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
