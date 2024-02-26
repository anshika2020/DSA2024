package recusions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sequentialDigits {
    /*
    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
Example 1:

Input: low = 100, high = 300
Output: [123,234]
     */

    public static List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();
         for(int i=1; i<=9;i++){ // aiterating from 1 to 9 assuming sample digit would be 1 to 9, that is starting digit
             System.out.println("Starting Digit "+ i);
             StringBuilder sb = new StringBuilder(); // create string builder to append the digit of given number one nby one
             for(int j=i; j<=9;j++){ // try to find all sequence first
                 // append value in the sb
                 sb.append(j); // store the digit in sb
                 System.out.println("Actual Seq Number "+ sb);
                 int num = Integer.parseInt(sb.toString()); // convert sb to int num
                 System.out.println("num :" + num);
                 if(num>=low&&num<=high){ // now check the condition based on the given range
                     result.add(num); // add the num in the list
                 }
             }
         }
        Collections.sort(result);
          return result;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 3000));
    }
}
