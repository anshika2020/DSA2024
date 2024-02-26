package arrays.Jan24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckTwoStringPermuatations {
    /*
check if the second string is permutation of first string
1. will permutation comparasion case sensitive? No
2. what could be the min and max length?
3. Can there be empty string as well?
4. Do I need to consider white spaces as well while cmparaing? yes but with followup
*/


        // apporach 1: I can use map to compare the values in boths strings TC: O(n) and SC: O(n)
/*
1. store the values in map then compare the map
*/
        public static boolean checkPermutation(String s1, String s2){
            if(s1.length()!=s2.length()) return false;

            Map<Character, Integer> s1Map = new HashMap<>();


            for(int i=0; i<s1.length();i++){
                s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
            }
            s1Map.forEach((K,V) -> System.out.println(K + ", values : " + V));
            for(int i=0; i<s2.length();i++){
                if(!s1Map.containsKey(s2.charAt(i))){
                    return false;
                }
            }
            return true;

        }

        //approach 2: sort and compare  TC: O(n log n) SC: O(1)
        public static boolean checkPermutation1(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            char [] ch = s1.toCharArray();
            Arrays.sort(ch);
            char [] ch2 =s2.toCharArray();
            Arrays.sort(ch2);
            for(int i=0; i<s1.length();i++){
                if(ch[i]!=ch2[i]){
                    return false;
                }
            }
            return true;
        }


        public static void main(String[] args) {
            String arr[][] = {{"DOOG" ," DOGA"},{"DOGE" , "DOGY"},{ "DOGO" ,"GOOD"},
                    {"DOOG", "GOOO"},
                    {"gdoo" , "dGoo"}};
//            for(int i =0;i<arr.length;i++) {
//                System.out.println(checkPermutation(arr[i][0],arr[i][1]));
//            }
            System.out.println(checkPermutation1("DOOG" ,"DOGO"));
        }
}
