package arrays;

public class MaxConsecutiveOnes {

    //Given a binary array, find the maximum number of consecutive 1s in this array.
    /*
    example Input: [1,1,0,1,1,1]
            Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
     */

    private static int maxConsecutive(int arr[], int binarynum){
        int current =0;
        int max = 0;

        for(int i:arr) {
            if (i == binarynum) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                if (max >= arr.length / 2) {
                    return max;
                }
                current = 0;
            }
        }
        return Math.max(max,current);
    }
    public static void main(String arg[]){
        int arr[] = {1,1,0,1,1,1,0,0,0,0,0};
        System.out.println(maxConsecutive(arr,1));
    }
}
