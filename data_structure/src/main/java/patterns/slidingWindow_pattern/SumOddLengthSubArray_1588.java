package patterns.slidingWindow_pattern;

public class SumOddLengthSubArray_1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        int totalSum=0;
        for(int i=0;i<arr.length;i++){

            int sum=arr[i];  // first is odd subarray then directly in sum
            totalSum+=sum; // total sum is the sum of subarrays element

            int j=i; // start j with i reason we don't go out of bound
            while(j+2<arr.length){
                // as we are getting odd length hence increment by j by 2 because we presereve 1 in beginning
                sum+=arr[j+1]+arr[j+2]; // (0+1)-->4 + (0+2)-->2
                totalSum+=sum;
                j+=2;
            }
        }

        return totalSum;
    }
    public static int sumEvenLengthSubarrays(int[] arr) {
            int totalSum=0;
            for(int i=0;i<arr.length-1;i++){

                int sum=arr[i]+arr[i+1];  // first is odd subarray then directly in sum
                totalSum+=sum; // total sum is the sum of subarrays element

                int j=i+1; // start j with i reason we don't go out of bound
                while(j+2<arr.length){
                    // as we are getting odd length hence increment by j by 2 because we presereve 1 in beginning
                    sum+=arr[j+1]+arr[j+2]; // (0+1)-->4 + (0+2)-->2
                    totalSum+=sum;
                    j+=2;
                }
            }

            return totalSum;
        }

    public static void main(String[] args) {
        int num[] ={1,4,2,5,3};
        // even: 1,4 : 1,4,2,5:4,2:4,2,5,3:2,5:5,3
        System.out.println(sumOddLengthSubarrays(num));
        System.out.println(sumEvenLengthSubarrays(num));
    }
}
