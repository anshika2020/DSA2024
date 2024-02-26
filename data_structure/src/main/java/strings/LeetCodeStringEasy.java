package strings;

import java.util.HashMap;

public class LeetCodeStringEasy {

    public static String convertToLowrCase(final String str){
        HashMap<Character,Character> letters = new HashMap<>();
        final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        char[] upperCaseLetter = upperCase.toCharArray();
        char[] lowerCaseLetter = lowerCase.toCharArray();
        StringBuilder builder = new StringBuilder();

        // first add small and capital letter to hashmap
        for(int j =0; j<26;j++){
            letters.put(upperCaseLetter[j],lowerCaseLetter[j]);
        }
        // the convert str to char array and then get char from array to compare and append to string builder
        for(char ch : str.toCharArray()){
      // this ? operator return one of two values. condition ? value1:value2 or simple way (a>b) ? a:b
              builder.append(letters.containsKey(ch) ? letters.get(ch):ch);
        }

        System.out.println("LowerCase :" + builder.toString());
       return builder.toString();

    }




    public static void main(String str[]){
        convertToLowrCase("AbhecL");
    }
}
