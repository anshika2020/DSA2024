package patterns.slidingWindow_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438_findAllAnagrams {
    /*
    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
     */

    /*
    Apporach:
    1. check case if
        -- if s len is less than p or s.len==0 then return empty list
    2. Create two map of same length p, one for p and one for s
    3. now start the loop with i which is p.legth as I already first p length in smap
        -- now compare if both maps have same values then add the result in the list and result would be i-p.length()
        --now I have to include next char of s
        -- exclude last char of s, get last char by i-p.length()
        -- now check if last char occurenc eis 1 then simply remove else update the map by reducing the occurence
     4. take care of last left over set by checking the both maps

     */

    public static List<Integer> findAnagrams(String s, String p) {
      List<Integer> res = new ArrayList<>();
      if(s.length()<p.length() ||s.length()==0|| p.length()==0) return res;

        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for(char c : p.toCharArray()){
            pmap.put(c, smap.getOrDefault(c, 0)+1);
        }
        for(int i=0; i<p.length();i++){
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0)+1);
        }

        int i=p.length();
        while(i<s.length()){
            if(smap.equals(pmap)){
                res.add(i-p.length());
            }
            // include next char
            char ch  = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0)+1);
            // exlcude last char from string and update the map for occurece of that character
            char c = s.charAt(i-p.length());
            if(smap.get(c)==1){
                smap.remove(c);
            }else{
                smap.put(c, smap.get(c)-1);
            }
            i++;
        }
        // now take care of left overs
        if(smap.equals(pmap)){
            res.add(i-p.length());
        }

      return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

}
