package dp;

import java.util.HashSet;

public class RodCutting {
/*
1. Initialize the table
2. Set base case
3.Fill in the rest using the recurrence relation
4. Return the value from one cell
 */

    /* Returns the best obtainable price for a rod of
           length n and price[] as prices of different pieces */
    static int rodCut(int len, int prices[]){
       int [] cutTable = new int[len+1]; // Build the table val[] in bottom up manner and return
        // the last entry from the table
       cutTable[0] = 0;
       for(int i=1;i<=len;i++){// need to start one because I already know if the len is zero then max revenue is zero
           int maxRevenue = 0; // intialise the maxRevenue as 0
           for(int j=0;j<i;j++){
               maxRevenue = Math.max(maxRevenue, prices[j]+cutTable[i-j-1] ); // get max revenue by adding price [i] + cuttable[len-1]{i is len over here and j-1 is the length of price array}
               cutTable[i] = maxRevenue;
           }

       }
       return cutTable[len];
    }

    //  another version by using greedy algorithm

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodCut(arr.length,arr));
    }
}
