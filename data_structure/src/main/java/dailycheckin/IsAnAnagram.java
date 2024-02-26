package dailycheckin;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class IsAnAnagram {
    /*
    algodaily: https://algodaily.com/challenges/is-an-anagram
    Here's the definition of an anagram: a word, phrase, or name formed by rearranging the letters of another: such as cinema, formed from iceman.
We are given two strings like "cinema" and "iceman" as inputs. Can you write a method isAnagram(str1, str2) that will return true or false depending on whether the strings are anagrams of each other?
Constraints
Length of both the strings <= 100000
The strings will contain only alphanumeric characters (a-z , A-Z, 0-9)
The strings can be empty
Expected time complexity : O(nlogn)
Expected space complexity : O(n)
     */
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false; // check edge case that both strings have same length
        String newStr = sortString(str1.toLowerCase(Locale.ROOT).toCharArray(), str1.length()); // sort the first string
        String newStr1 = sortString(str2.toLowerCase(Locale.ROOT).toCharArray(), str2.length()); // sort the second string
        System.out.println("str1 : " + newStr + "\nstr2 :" + newStr1);
        if (newStr.equals(newStr1)) { // check if both strings are same after sorting
            return true;
        } else {
            return false;
        }
    }


    // TC and SC: log (n)
    /*
    Appraoch to use map and get occurece of character of both string which can help to compare for each char occurence in both maps , if same then true else false
     */
    public static boolean isAnagram1(String str1, String str2) {
        Map<Character, Integer> s1map = new HashMap<>();
        Map<Character, Integer> s2map = new HashMap<>();
        for(char c : str1.toCharArray()){
            s1map.put(c, s1map.getOrDefault(c, 0)+1);
        }
        for(char c : str2.toCharArray()){
            s2map.put(c, s2map.getOrDefault(c, 0)+1);
        }
        if(s1map.equals(s2map)){
            return true;
        }
        return false;
    }

    private static String sortString(char[] ch, int len) {

        String sortedStr = "";
        if (len < 2) { // check edge case if the length of the string is 1 then just return empty string or error out that not valid string for sorting
            return "";
        }
        int mid = ch.length / 2;   // get the mid len of the string as we are doing sorting using merge sort
        char left[] = new char[mid]; // char array to store the first half chars of the string
        char right[] = new char[ch.length - mid]; // char array to store the second half chars of the string
        // put first half in left array
        for (int i = 0; i < mid; i++) { //O(n)
            left[i] += ch[i];
        }
        // put first half in  array
        for (int i = mid; i < ch.length; i++) { //O(n)
            right[i - mid] += ch[i];
        }
        sortString(left, mid);//O(n) recursively call to sort the left
        sortString(right, len - mid); //O(n) recursively call to sort right half
        // merge these two subarrays
        sortedStr += String.valueOf(mergeSubArrays(ch, left, right, mid, len - mid)); //O(n log n) combine the sorted array

        return sortedStr;
    }

    // total calculation : TC: O(n)+O(n)+ O(n)+ O(n log n) --> O(n log n)

    private static char[] mergeSubArrays(char[] ch, char[] left, char[] right, int mid, int len) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < mid && j < len) {// loop till i and j are less than mid and len //O(n log n)
            if (left[i] <= right[j]) {
                ch[k++] = left[i];
                i++;
            } else {
                ch[k++] = right[j];
                j++;
            }
        }
        // put remaining left to left
        while (i < mid) {
            ch[k++] = left[i];
            i++;
        }
        // put remaining right to right half
        while (j < len) {
            ch[k++] = right[j];
            j++;
        }
        // System.out.println("sortedchar array : "+ Arrays.toString(ch));
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("cinema", "icemanb"));
    }
}
