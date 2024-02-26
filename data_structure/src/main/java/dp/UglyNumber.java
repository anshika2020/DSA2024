package dp;

public class UglyNumber {
/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
Given a number n, the task is to find n’th Ugly number.
input = 7
output = 8
 */


    public static int getUglyNumber(int num){
        int ugly[] = new int[num]; // create array to store all ugly numbers

        //base case : store 1 at the 0th index in ugly array
        ugly[0] = 1;

        // create conter variable to count the position of the asked number
        int count =1;
        int primeFact2=0;
        int primeFact3=0;
        int primeFact5=0;
        while (count<num){
            // get the ugly next number
            int next2 = ugly[primeFact2]*2;
            int next3= ugly[primeFact3]*3;
            int next5= ugly[primeFact5]*5;
            int next = Math.min(next2,Math.min(next3, next5)) ;
           if(next==next2) primeFact2++;
           if(next==next3) primeFact3++;
           if(next==next5) primeFact5++;


           ugly[count++]=next;
        }
     return ugly[num-1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(7));
    }
}
