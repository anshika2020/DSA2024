package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

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
        char ch =0; char[] chars = new char[str.length()];
        chars = str.toCharArray();
//        if(str.contains("[^A-Za-z0-9]")||str.contains("^[^<>{}\"/|;:.,~!?@#$%^=&*\\]\\()\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$")){
//
//             chars = str.toCharArray();
//        }else{
//            System.out.println("no array");
//        }
        for(char character: chars){
            if(set.contains(character)){
                ch = character;
            }else{
                set.add(character);
                ch='0';
            }
        }
        System.out.println("values in set:"+ set.toString());
       return ch;
    }

}
