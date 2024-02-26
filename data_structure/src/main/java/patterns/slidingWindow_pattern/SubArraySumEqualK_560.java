package patterns.slidingWindow_pattern;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK_560 {

   /*

[1,1,1]--> [1],[1,1], [1,1] ,[1,1,1] k =2,sum of subArray=k
[1,2,3]--> [1], [1,2], [2], [2,3],[3],[1,2,3]

find all sub-ayyays with a fixed length
length 1- [1], [2], [3]
length 2- [1,2], [2,3]
length 3- [1,2,3]

getcountsubarray(array, length, k)
getcountsubarray(array, 1, 3)
getcountsubarray(array, 2, 3)
getcountsubarray(array, array.length, 3)

sum =0;int cnt=0;
add first element in sum
check sum==k
*/


    public static int subarraySum(int[] nums, int k) {
        int cnt =0;
        for(int i=1;i<=nums.length;i++){
            cnt+= getcountsubarray(nums,i,k);
        }

        return cnt;
    }

    public static int getcountsubarray(int[]array, int size,int k){
        int cnt =0;
        for(int i=0;i<=array.length-size;i++){ // This is to get 1st element of a subarray // i=0//i=1
            int sum =0;
            for(int j=i;j<i+size;j++){ // This is to get all elements of the subarray starting i//j=0,. j<0+2// j=1,i<2
                sum+=array[j]; // [1] //1+[2] ==3
            }
            if(sum==k){
                cnt++;
            }
        }
        return cnt;
    }

    public static int getNumberOfSubArrayEqualK(int[] num, int k) {
        int cnt=0;
        // add the first elemnt in the sum
        //then check whether sum-num[i] isin the map of not and sum equal to k, if yes then increase the cnt
        int sum=0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1); // added the sum and numbder of occurence of sum is 1
        for(int i=0;i<num.length;i++) {

            sum += num[i]; // adding the ith value in sum
            System.out.println("sum-k: " + (sum - k));
            // each previous appeared key = (sum - k) will lead to one subarray
            /*
            If the cumulative sum(represented by sum[i]sum[i] for sum up to i^{th}i
th
  index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices,
  say i and j is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.
             */
            /*
            we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs. We store the data in the form: (sum_i, no. of occurrences of sum_i)(sum i
 ,no.ofoccurrencesofsum i). We traverse over the array nums and keep on finding the cumulative sum.
             */
            if (map.containsKey(sum - k)) { // now check if the 1-3=-2
                System.out.println("map:::"+ map.get(sum - k));
                cnt += map.get(sum - k);//get the frequency of the key
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);// storing sum and no.ofoccurrencesofsum
        }
        return cnt;
    }

    public static void main(String[] args) {
       // System.out.println(subarraySum(new int[]{1,2,3},3));
        System.out.println(getNumberOfSubArrayEqualK(new int[]{1,2,3},3));
    }

}


