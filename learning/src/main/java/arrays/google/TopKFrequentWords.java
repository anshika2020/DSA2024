package arrays.google;

import java.util.*;

public class TopKFrequentWords {
    /*
    Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
     */

    // create a method which takes two parameter arr[] and int k to fetch how many top elements we want to get
    public static String[] topKWords(String[] words, int k) {
        // create an new array to store the top frequent values
        String[] str = new String[k];
        //iterate through the array and add them to map where value is the keySet and no. of occurence is the keyValue
        Map<String, Integer> map = new HashMap<>();
         for(int i=0; i<words.length;i++){
             map.put(words[i], map.getOrDefault(words[i],0)+1);
         }
        // add the map to priorityqueue and sort as well using comparator
        PriorityQueue<String> queue = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
         for(String s: map.keySet()){
             queue.add(s);
             if(queue.size()>k){
                 queue.poll();
             }
         }
        // fetch the top values from queue and store in the new array
        for (int i=0; i<k;i++){
            str[i] = queue.poll();
        }
        return str;
    }

    // comparator need to be using the object comparision like str1.compareTo(str2)
    public static List<String> topKFrequent(String[] words, int k) {

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        // now add the map to priorityqueue and sort the values in map using comparator
        // less frequent will come top,
        // if same frequency then lexicographical order, 2nd element will come on top.
        PriorityQueue<String> pq = new PriorityQueue<>((str1, str2)->
        {
            if(map.get(str1) != map.get(str2))
                return map.get(str1) - map.get(str2);
            return str2.compareTo(str1);
        });

        // now add the map values to pq
        for(String str:map.keySet()){
            pq.add(str);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=k-1;i>=0;i--){
            list.add(pq.poll());
        }
        Collections.reverse(list);

        return list;
    }
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"}; //Output: ["i","love"]
        System.out.println(Arrays.toString(topKWords(words,2)));

        String words1[]={"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words1,4));

    }

}
