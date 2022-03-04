package patterns.slidingWindow_pattern;
//TODO : could not solve yet
public class LongestSubStringWithKDistintcChar {

    /*
    340. Longest Substring with At Most K Distinct Characters
    Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

     */
    /*
   1. Given the s string
   2. need to find the longest substring which has k for example 2 distinct chars
   3. Question : if that there more than one long substring with same dinctinct character then?
   */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        int start=0; int maxlen=Integer.MIN_VALUE;

        String subStr ="";
        //iterate through the lenght of the string
        for(int i=0; i<s.length();i++){
            // store the substring in substr
            subStr+=s.charAt(i);
            int cnt= countDistinctChar(subStr);
            // check until substring contains k distinct character
            while(cnt==k){
                // get the MaxLength of subarray by shrinking the window with startpoint
                maxlen= Math.max(maxlen, i-start+1);
                // remove start char from substring
                String newS = String.valueOf(subStr.charAt(start));
                subStr.replace(newS,"");
                //increment start by one point
                start++;
            }
        }
        return maxlen;
    }

    public static int countDistinctChar(String str){
        return  Math.toIntExact(str.chars().distinct().count());
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba",2));
    }

}

