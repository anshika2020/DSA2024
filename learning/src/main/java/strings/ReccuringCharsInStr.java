package strings;

import java.util.*;

public class ReccuringCharsInStr {

    private static char[] sort(final String str){
        char[] chars = str.toLowerCase(Locale.ENGLISH).toCharArray();
        char newChar=0;

      char temp= 0;
        //sort the arrays
        for(int i=0; i<chars.length;i++){
            for(int j=i+1;j<chars.length;j++) {
                if (chars[i] > chars[j]) {
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

      return chars;
    }
public static char getReccurChar(final String str){

    System.out.println("sorted char array:" + Arrays.toString(sort(str)));
        char chars = 0;
        for(int i=0; i<sort(str).length-1;i++){
            if(sort(str)[i]==sort(str)[i+1]){
                chars = sort(str)[i];
                return chars;
            }else{
                chars = '0';
            }
        }
       return chars;
}

//using hashtable or dictionary
    public static char getRecurringCharUsingHash(final String str){
        final Set<Character> set = new HashSet();
        char ch =0;
        char[] chars = str.toCharArray();
        Set<Character> allRecu = new HashSet<>();
        for(char character: chars){
            if(set.contains(character)){
                ch = character;
                allRecu.add(ch);
            }else{
                set.add(character);
                ch='0';
            }

        }
        System.out.println("values in set:"+ allRecu.toString());
       return ch;
    }


    public static void main(String[] args) {
        System.out.println(getRecurringCharUsingHash("Abcbbdc"));
    }
}
