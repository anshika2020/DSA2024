package patterns.slidingWindow_pattern;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubString {

    /*
    LC: 1763
    A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
   Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
  Input: s = "YazaAay"
  Output: "aAa"
  Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
  "aAa" is the longest nice substring.

     */
    public String longestNiceSubstring(String s) {
        // check the base case
        if(s.length()<2) return "";

        // now convert the s to charArray
        char[] ch = s.toCharArray();
        // now add this char array to set
        Set<Character> set = new HashSet<>();
        for(char c: ch){
            set.add(c);
        }
        // iterate through the string length
        for(int i=0; i<ch.length;i++){
            if(set.contains(Character.toLowerCase(ch[i]))==true && set.contains(Character.toUpperCase(ch[i]))==true) continue;

            String prev = longestNiceSubstring(s.substring(0,i));
            String next = longestNiceSubstring(s.substring(i+1, s.length()));
            return prev.length()>=next.length()?prev:next;
        }
        return s;
    }

    public static void main(String[] args) {
        LongestNiceSubString logest = new LongestNiceSubString();
        System.out.println(logest.longestNiceSubstring("YaAaBbz"));
    }
}
