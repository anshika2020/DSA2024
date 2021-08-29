package recusions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicateCharacter {
    /*
    Subsets With Duplicate Characters
Given a string that might contain duplicate characters, find all the possible distinct subsets of that string.
Example One:
Input: “aab”
Output: [“”, “a”, “aa”, “aab”, “ab”, “b”]
Example Two:
Input: “dc”
Output: [“”, “c”, “cd”, “d”]
Notes:

All the subset strings should be individually sorted.
The order of the output strings does not matter.
Constraints:

1 <= String Length <= 15.
Any character in the string lies in ‘a’...’z’.
Custom Input:

Input Format:

First and the only line contains the input string.
Input from “Example One” above would look like this:

aab

Output Format:

First line of output contains the total number of subsets.
All the subsets are then printed in separate lines.
     */

    private static List<String> getAllSubset(final String input){
        List<String> results = new ArrayList<>();
        String sorted = input.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("after sorting " + sorted);
        helper(sorted, 0,"", results);
        return results;
    }

    private static void helper(String input, int index,String prefix, List<String> results) {
        // base case
        if(index>=input.length()){
            results.add(prefix);
            return;
        }
        char ch = input.charAt(index);
        String remainingStr = input.substring(index+1);
        helper(remainingStr, index+1,prefix+ch, results);
        helper(remainingStr,index+1, prefix, results);
    }

    public static void main(String[] args) {
        System.out.println(getAllSubset("dc"));
    }
}
