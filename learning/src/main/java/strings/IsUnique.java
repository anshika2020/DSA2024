package strings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    /*
    Algo log(n^2)

    ASCII defines 128 characters, which map to the numbers 0–127. Unicode defines (less than) 221 characters, which, similarly, map to numbers 0–221 (though not all numbers are currently assigned, and some are reserved).

Unicode is a superset of ASCII, and the numbers 0–127 have the same meaning in ASCII as they have in Unicode. For example, the number 65 means "Latin capital 'A'".

Because Unicode characters don't generally fit into one 8-bit byte, there are numerous ways of storing Unicode characters in byte sequences, such as UTF-32 and UTF-8.
     */
    public static boolean isUnique(String str){

        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
            if(str.charAt(i) == str.charAt(j)){
                System.out.println("Duplicate char found");
                System.out.println("char occurence at index " + str.charAt(i) + " next char: "+ i + ":"+ j);
                return false;
            }
            }
        }
        System.out.println("All chars are unique");
        return true;
    }
/*
Typically, ASCII characters are 256, so we use our Hash array size as 256. But if we know that our input string will have characters with value from 0 to 127 only, we can limit Hash array size as 128. Similarly, based on extra info known about input string, the Hash array size can be limited to 26.
 */
    private static boolean areAllCharUnique(final String str) {
        if(str.length()>128){ // assuming the max number of chars in string would be 128 as per ASC
            return false;
        }
        boolean charSet[] = new boolean[128];

            for (int i = 0; i < str.length(); i++) {

                if (!charSet[i]) {
                    return true;
                }
               charSet[i] = false;
            }
        return false;
    }

    private static boolean isUniqueChars(final String str){
         if(str.length()<-0||str.length()>128){
             return false;
         }
         char[] chars = new char[str.length()];
         for(int i =0; i<str.length();i++){
             chars[i] +=str.charAt(i);
         }
         for(int i=0;i<chars.length;i++){
             for(int j =i+1;j<chars.length;j++){
                 if(chars[i]==chars[j]){
                     return false;
                 }else{
                     return true;
                 }
             }
         }
         return false;

    }
    private static boolean isUniqueChar(final String str){
        // iterate str then store in array or hashset then validate the length of the str and hashset
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<str.length();i++){
            set.add(str.charAt(i));
            String str1 = "a";

        }
        System.out.println("size of the set :" + set.size() + "str size: "+ str.length());
        if(set.size()==str.length()){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String [] str){
       // isUnique("CABRI");
        System.out.println("\n one way : "+areAllCharUnique("ADAnsd"));
        System.out.println("\n"+isUniqueChars("ADAnsd"));
        System.out.println("\nhashset Use  : "+isUniqueChar("ADAnsd"));
    }
}
