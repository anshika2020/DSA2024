package arrays;

public class Factorial {

    // 3! = 3*2*1

    /*
    Expection fact(5) : 5*4*3*2*1
    faith : 4! fact(4) : 4*3*2*1
    combine : 5 *fact(4)
    */

    public static long fact(int n){
        long factorialValue =0;
        if(n<=1){
            return 1;
        }
        factorialValue = n*fact(n-1);
        return factorialValue;
    }


    public static long divide(long num1, long num2){
        return num1/num2;
    }
    public static void main(String[] args) {
        System.out.println(fact(9));
       // System.out.println(divide(/87178291200));
    }

}