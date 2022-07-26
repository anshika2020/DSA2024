package arrays;

public class MaxProductsOfThree {
    /*
    Given an unsorted array of integers, can you write a method maxProductOfThree(unsorted: array) to find the largest product from three of the numbers? For example, given the following array:

[-1, 9, 22, 3, -15, -7]

[-1,3,-2,5] 5 , -1*-2==2,-1*3=-3
The largest product of three numbers is 2310. This results from -15 * -7 * 22.
Constraints
Length of the array <= 100000
The array will contain values between -1000 and 1000
The final answer would always fit in the integer range
Expected time complexity : O(n)
Expected space complexity : O(1)
     */


    private static int getMax(int arr[]){
        int max =Integer.MIN_VALUE;
        for(int n:arr){
            if(max<n){
                max=n;
            }
        }
        System.out.println("maxNumber:" + max);
        return max;
    }
    public static int getMaxOfThree(int arr[]){
// Now we can do in linear as well
        // lets do it in linear way
        int maxNum=getMax(arr);

            // take two max and two min variable to get two max and two min integer
            int max1= arr[0];  // assume the first element is the max element
            int max2 = Integer.MIN_VALUE;// now get the second max
            int min1 = arr[0]; // assume the first element is the min element
            int min2 = Integer.MAX_VALUE;// now get the second min

            // iterate through the array to get two min and max integers in array
            for(int i=1; i<arr.length;i++) {
                if (arr[i] != maxNum) { //already got the maximun number
                    if (arr[i] > max1) { // if arr[i] is greater than
                        max2 = max1;
                        max1 = arr[i];
                    }
                    else if (arr[i] > max2) {
                        max2 = arr[i];

                    }

                    if (arr[i] < min1) {
                        min2 = min1;
                        min1 = arr[i];
                    }
                    else if (arr[i] < min2) {
                        min2 = arr[i];
                    }
                }
            }
            // now check the maxproduct
            if(max1*max2>min1*min2){
                return max1*max2*maxNum;

            }else{
                return min1*min2*maxNum;
            }
    }

    public static void main(String[] args) {
        System.out.println(getMaxOfThree(new int[]{-1, 9, 22, 3, -15, -7}));
    }
}
