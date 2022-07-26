package dailycheckin;

public class ReduceNonNegativeToZero_DailyByte {
    /*
    Given a non-negative integer, num, return the number of operations it takes to reduce it to zero. If num is even, divide it by two. If num is odd, subtract one from it. Continue this process until num is zero.

Ex: Given the following num…

num = 5, return 4 (subtract 1, divide by 2, divide by 2, subtract 1).
Ex: Given the following num…

num = 16, return 5.(16/2=8, 8/2=4, 4/2=2,2/2=1, 1-1=0)
     */

    public static int reduceToZero(int num){
         int cnt=0; int ans=0;
        if(num%2==0){
            int val =num/2;
            while(val!=0){
                val= val/2;
              cnt++;
            }

        }else{
            int val =num-1;
            while(val!=0){
                val= val/2;
                cnt++;
            }
        }
        return cnt+1;
    }

    public static void main(String[] args) {
        System.out.println(reduceToZero(5));
        System.out.println(reduceToZero(8));
    }
}
