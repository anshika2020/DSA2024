package strings;

import java.util.Locale;

public class TwoStringSubsequenceS1S2 {
    /*
    Given str s1 and s2
    Find if s2 is a substring
     If so reverse s2 and change it in place in str s1
     */

    // approach 1: get all subset of the string s1
    // simple check whether s1 contains s2 if so return true

    private static boolean checkSubString(String s1, String s2) {
        if (s1.toLowerCase().contains(s2.toLowerCase(Locale.ROOT))) {
            // solve second question : reverse s2 and change it inplace in s1
            reverseAndReplace(s1,s2);
            return true;
        }
        return false;
    }

    private static String reverseAndReplace(String s1, String s2) {
        String newString ="";
        // reverse S2
        for(int i=s2.length()-1; i>=0;i--){
             newString += s2.charAt(i);
        }
        System.out.println("reversed Sub String " + newString);
        String finalStr = s1.replace(s2, newString);
        System.out.println("new final String :" + finalStr);
        return finalStr;
    }

    public static void main(String[] args) {
        System.out.println(checkSubString("anshika", "shi"));
    }
}
