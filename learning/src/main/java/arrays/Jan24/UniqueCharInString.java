package arrays.Jan24;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharInString {
    /*
FIND all char are unique
Questions:
1. Can string be empty? Yes , null as well
2.what could be the max length of string?
3.Can there be space in as char in string ? No
4. Is string ASCII or unicode? we can assume ACSCII as easy to understand also takes less storage. ASCII character limits 128 to 256. Unicode can hold 11Million characters
*/

        // aporach 1: burte force apporach  : TC : O(n^2) SC: O(1)
        public static boolean findDup1( String str){
            if(str==null) return false;
            if(str.length()==1){
                return true;
            }
            for(int i=0; i<str.length();i++){
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i)==str.charAt(j)){
                        return false;
                    }
                }
            }
            return true;
        }

        // approach 2: using char array to compare with string chars TC: O(n) SC: O(n)
    /*
    we can convert string to char array  then pick one element and compare in the string if finds true else false
    */
        public static boolean findDup2( String str){
            if(str==null) return false;
            if(str.length()==1){
                return true;
            }
            for(int i=1;i<str.length();i++){
                if(str.charAt(i)==str.charAt(i-1)){
                    return false;
                }
            }
            return true;
        }
        // approach 2: Using Data structure TC : O(n) and SC: O(n) but best and avg TC for set is O(1)
    /*
    store all the character in set and then compare the size of set and strng length is equal then unique else dupes
    */
        public static boolean findDup( String str){
            if(str==null) return false;
            if(str.length()>128) return false;
            if(str.length()==1){
                return true;
            }
            Set<Character> set = new HashSet<>();
            for(int i=0; i<str.length();i++){
                set.add(str.charAt(i));
            }
            if(str.length()!=set.size()){
                return false;
            }
            return true;
        }
        // Aporach 4 : use fix char araay if string is ASCII : TC: O(n) SC: O(1) because loop will never iterate more that 128 characters
    public static boolean findDup3( String str){
        if(str==null) return false;
        if(str.length()>128) return false;
        if(str.length()==1){
            return true;
        }

        boolean checkFlag[] =new boolean[128];
        for(int i=0;i<str.length();i++) {
            int val = str.charAt(i);
            if (checkFlag[val]) {
                return false;
            }
            checkFlag[val] = true;
        }
        return true;
    }
        public static void main(String[] args) {
            String arr[] = {"", "aaaa", "acnd", "a"};
            for(String str : arr){
                System.out.println(findDup3("accnd"));
            }
        }
}
