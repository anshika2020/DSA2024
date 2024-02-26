package recusions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutions {

/*
recursion class question
TC: O(N.2^N) == O(n^2)
SC: what contributes to space complexity : list object (2^n.N), index = (N) char array(N)
  so O(2^n.N+N+N)=O(n^2)
patten is : decrease and conquer by using faith and expectation
 */

    // ietrative approach
    private static List<String> getLetterPermutationNoRecur(String input){
        final LinkedList<String> results = new LinkedList<>();
        results.add(input);
        int n = input.length();
        for(int i=n-1;i>=0;i--){
            char ch = input.charAt(i);
            if(Character.isLetter(ch)){
               int size = results.size();
               while(size-->0){
                   String newString = results.poll();
                   String left = newString.substring(0,i);
                   String right = newString.substring(i+1, n);
                   results.add(left+Character.toLowerCase(ch)+right);
                   results.add(left+Character.toUpperCase(ch)+right);
               }

            }
        }
        return results;

    }

    static List<String> getPer(final String input){
        List<String> result = new ArrayList<>(); // need list to store all permutation
        /*this method will take following
        1. input string
        2. starting index to check length and recurse the
        3. empty character array to store the letters of string
        4. List result to store the generated string from original
         */
        helper(input, 0, new char[input.length()],result); // recursive call
        return result;
    }

    static List<String> getPermutaionOfString(final String input){
        List<String> results = new ArrayList<>();
        helperMutableSolution(input, 0, "", results);
        return results;
    }

    static void helper(String input, int index, char[] slate,List<String> result){
       // base case
        if(index>=input.length()){ // check if the index which is 0 initially is greater than given string length
            result.add(new String(slate)); // if condition is true then add the result which will be character array
            return;
        }
        char preview = slate[index]; // to reset the state
        char ch = input.charAt(index);
        if(Character.isLetter(ch)){
            slate[index] = Character.toLowerCase(ch);
            helper(input, index+1, slate, result);
            slate[index] = Character.toUpperCase(ch);
            helper(input, index+1, slate, result);
        }else{
            slate[index] = ch; // if it is not letter
            helper(input, index+1, slate, result);
        }
        slate[index] = preview; //reset shared state but not neccessary in this case but good to add handle some edge case
    }

    private static void helperMutableSolution(String input, int index, String prefix, List<String> results){
        // base case : Tc: O(1)
        if(index==input.length()){
            results.add(prefix);
            return;
        }
        //now make recusive call to pick choices for each
        /*
        Note: There is downside of using String because everytime it will create creat a new copy and add the character to it.
        If the garabage collector does not run even after completing the one path then possibility this String can take the space of more that all actual space taken by other attributes
         */
        char ch = input.charAt(index);
        if(Character.isDigit(ch)){
            helperMutableSolution(input, index+1, prefix+ch, results); // TC: O(
        }else{
            helperMutableSolution(input, index+1, prefix+Character.toUpperCase(ch), results);
            helperMutableSolution(input, index+1, prefix+Character.toLowerCase(ch), results);
        }

    }

    public static void main(String[] args) {
      //  System.out.println(getPer("a2b"));
      //  System.out.println(getLetterPermutationNoRecur("a2b"));
        System.out.println(getPermutaionOfString("a1z"));
    }
}
//[a2b, a2B, A2b, A2B]