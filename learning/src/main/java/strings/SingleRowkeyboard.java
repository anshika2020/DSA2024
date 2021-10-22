package strings;
import java.util.HashMap;

public class SingleRowkeyboard {
    /*
    Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
Output: 4
Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
Total time = 2 + 1 + 1 = 4.
     */

    public static int calculateTimeToTypeAWordWithOneFinger(final String keyboard,String word){
       char keyChar[] = keyboard.toCharArray();
       HashMap<Character,Integer> keyboards= new HashMap<>(); // hashmap to store the keys of keyboard

       for(int i=0;i<keyboard.length();i++){ // iterate through the length of the keyChar array
           keyboards.put(keyboard.charAt(i), i); // store the char and index of char in the hashmap
       }

       int totalTime=0; // create variable to calculate total time
       int currIndex=0; // create variable to get current index
       int nextLetterIndex = 0; // create variable to get next letter index

       for(int i=0;i<word.length();i++){ // iterate through the given word
           nextLetterIndex = keyboards.get(word.charAt(i)); // get the next letter index of given word
           System.out.println("Next letter index value : "+ nextLetterIndex);
           System.out.println("diff next and current index  : "+ Math.abs(currIndex - nextLetterIndex));
           totalTime += Math.abs(currIndex - nextLetterIndex); // add total time by substracting current index from nextletter index
           System.out.println("Total Time: "+ totalTime);
           currIndex = nextLetterIndex; // store next letter index in current index
           System.out.println("current index :" + currIndex);
       }
        return totalTime;
    }

    public static void main(String arg[]){
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String [] keyboardArr = {"pqrstuvwxyzabcdefghijklmno","abcdefghijklmnopqrstuvwxyz"};
        String [] words ={"leetcode","cba"};
        for(int i =0; i<words.length;i++) {
            System.out.println("Total Time: " + calculateTimeToTypeAWordWithOneFinger(keyboardArr[i], words[i]));
        }
    }

}
