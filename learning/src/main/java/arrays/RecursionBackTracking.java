package arrays;

public class RecursionBackTracking {

    // increasing order sequence

    public static void pringIncreasing(int n){
        if (n <= 0) {
            return;
        }
        pringIncreasing(n-1);
        System.out.println(n);
    }


    // decreasing order

    public static void printDecreasing(int n){

        if(n<=0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printDescIncrease(int n){
        if(n<=0){
            return;
        }

        System.out.println(n);
        printDescIncrease(n-1);
        System.out.println(n);
    }
    public static void printIncreaseDescrease(int n){
        if(n<=0){
            return;
        }

        pringIncreasing(n-1);
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void main(String[] args) {
//        pringIncreasing(5);
//        System.out.println("Decreasing : ");
    //   printDecreasing(5);
        // Expectation : 5,4,3,2,1,1,2,3,4,5
        // 1,2,3,4 (5), 4,3,2,1
        //faith f(4)->1,2,3,4,3,2,1
        System.out.println("Increasing decreasing order: ");
       //printDescIncrease(5);
        printIncreaseDescrease(5);

    }
}
