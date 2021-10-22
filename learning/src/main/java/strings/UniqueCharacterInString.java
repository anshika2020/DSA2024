package strings;

import java.util.HashMap;

public class UniqueCharacterInString {
    /*
    Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
     s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
Note: You may assume the string contains only lowercase English letters.
     */

    public static int uniqueIndex(final String str) {
        String newStr = str.toLowerCase();
        String regex = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        if(newStr.contains(regex)){
            System.out.println("String should not contain special characters");
        }
        HashMap<Character,Integer> count = new HashMap<>();
        for(int i=0; i<newStr.length();i++){
            char ch = newStr.charAt(i);
            if(ch==' '){
                System.out.println("String should contain only a to z");
                return -1;
            }
            count.put(ch,count.getOrDefault(ch,0)+1);
        }

        // find the index
        for(int i=0;i<newStr.length();i++){
            if(count.get(newStr.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }

    /*
    The best possible solution here could be of a linear time because to ensure that the character is unique you have to check the whole string anyway.

The idea is to go through the string and save in a hash map the number of times each character appears in the string. That would take \mathcal{O}(N)O(N) time, where N is a number of characters in the string.

And then we go through the string the second time, this time we use the hash map as a reference to check if a character is unique or not.
If the character is unique, one could just return its index. The complexity of the second iteration is \mathcal{O}(N)O(N) as well.
    Time complexity : \mathcal{O}(N)O(N) since we go through the string of length N two times.
Space complexity : \mathcal{O}(1)O(1) because English alphabet contains 26 letters.
     */

}
