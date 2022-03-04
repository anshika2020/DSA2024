package matrix;

public class RichestCustomerWealth {

//1672. Richest Customer Wealth
    /*
    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money i the customer has in the j bank. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
     */

    public static int maximumWealth(int[][] accounts) {
         int max =Integer.MIN_VALUE;
        for(int row =0; row<accounts.length;row++){
            int sum =0;
            for(int col=0;col<accounts[row].length;col++){
                     sum += accounts[row][col];
            }
            max =Math.max(sum,max);

        }
        return max;
    }

    // another way to iterate
    public static int maximumWealth1(int[][] accounts) {
        int max =Integer.MIN_VALUE;
        for(int[]num :accounts){
            int sum =0;
            for(int money : num){
                sum += money;
            }
            max =Math.max(sum,max);

        }
        return max;
    }
    public static void main(String[] args) {
        int num[][] ={{1,2,3},{3,2,1}};
        System.out.println("value: "+ maximumWealth(num));
        System.out.println("value 1: "+maximumWealth1(num));
    }
}
