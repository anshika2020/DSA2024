package strings;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveVowelFromStr {

    public static  String getRemoveVowel(final String str) {
            String newString ="";
        String newString1 ="";
            StringBuilder builder = new StringBuilder();

            StringBuilder consonents = new StringBuilder();
            HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','i','o','e','u'));
            char [] chars = str.toCharArray();

            for(char ch: chars){
                if(!vowels.contains(ch)){
                    builder.append(ch);
                }else{
                    consonents.append(ch);
                }
                newString1 = consonents.toString();
                newString = builder.toString();
            }
            System.out.println("newString1:" + newString1);
            return newString;

        }

        public static String removeVowelsFromStr(String str){
          return str.replace("a","").replace("e","").replace("i","").replace("o","").replace("u","");
        }
    public static void main(String[] arr){
       System.out.println("Values:" + getRemoveVowel("leetcodeisacommunityforcoders"));
    }
}
