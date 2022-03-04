package dailycheckin;

import java.util.Arrays;
import java.util.Locale;

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
    public static boolean isAnagram(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        String newStr = sortString(str1.toLowerCase(Locale.ROOT).toCharArray(),str1.length());
        String newStr1 = sortString(str2.toLowerCase(Locale.ROOT).toCharArray(),str2.length());
        System.out.println("str1 : "+newStr+ "\nstr2 :"+ newStr1 ) ;
        if(newStr.equals(newStr1)){
            return true;
        }else{
            return false;
        }
    }

    private static String sortString(char[] ch, int len) {

         String sortedStr="";
        if(len<2){
            return "";
        }
         int mid=ch.length/2;
         char left[] = new char[mid];
         char right[] = new char[ch.length-mid];
         // put first half inleft array
        for(int i=0; i<mid;i++){ //O(n)
            left[i] +=ch[i];
        }
        // put first half in  array
        for(int i=mid; i<ch.length;i++){ //O(n)
            right[i-mid] +=ch[i];
        }
        sortString(left,mid);//O(n)
        sortString(right,len-mid); //O(n)
        // merge these two subarrays
        sortedStr +=String.valueOf(mergeSubArrays(ch,left,right,mid, len-mid)); //O(n log n)

      return sortedStr;
    }

    // total calculation : TC: O(n)+O(n)+ O(n)+ O(n log n) --> O(n log n)

    private static char[] mergeSubArrays(char[] ch, char[] left, char[] right, int mid, int len) {
        int i=0; int j=0;int k=0;
        while(i<mid&&j<len){// loop till i and j are less than mid and len //O(n log n)
            if(left[i]<=right[j]){
                ch[k++] = left[i];
                i++;
            }else{
                ch[k++] = right[j];
                j++;
            }
        }
        // put remaining left to left
        while(i<mid){
            ch[k++] =left[i];
            i++;
        }
        // put remaining right to right half
        while(j<len){
            ch[k++] = right[j];
            j++;
        }
       // System.out.println("sortedchar array : "+ Arrays.toString(ch));
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cinema","iceman"));
    }
}
