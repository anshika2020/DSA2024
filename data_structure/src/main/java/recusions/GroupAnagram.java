package recusions;

import java.util.*;

public class GroupAnagram {
    /*
   49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res= new ArrayList<>();

        if(strs==null || strs.length==0){
            return res;
        }
        Map<String, List<String>> map= new HashMap<>();
        for(String s: strs){
            String sortedString= sort(s);
            if(map.containsKey(sortedString)){
                List<String> list=map.get(sortedString);
                list.add(s);
                map.put(sortedString, list);
            }else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(sortedString, list);
            }
        }

        for(List<String> values: map.values()){
            res.add(values);
        }


        return res;

    }

    public String sort(String s){
        char[] chars=s.toCharArray();
        Arrays.sort(chars);


        return new String(chars);
    }
}
