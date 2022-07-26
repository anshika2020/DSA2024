package arrays;

public class EvenNumberOfDigits {

    //Given an array nums of integers, return how many of them contain an even number of digits.
    /*
    Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
     */
    private static int getNumberOfEvenDigits(int [] arr){
   int count =0;
        if(arr.length==0){// check if thee length is zero then return zero
            return 0;
        }
        for(int i:arr){

            if(String.valueOf(i).length()%2==0){ // get the length of integer by converting to String , then divide by 2 if zero remainder then increase the counter by 1;
                count+=1; // or count++
            }
        }
       return count; // return total number of digits with even
    }



    public static void main(String arg[]){
        int num[] = {12,345,2,6,7896,456788};
        System.out.println(getNumberOfEvenDigits(num));
    }

}
