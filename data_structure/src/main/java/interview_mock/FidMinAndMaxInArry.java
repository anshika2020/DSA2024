package interview_mock;

public class FidMinAndMaxInArry {
    // [2,3,4,5,6,7,1]
// sort: nlog(n)
// scan: find min: O(n)

// find min value// find max

    // this is nlog(n)
    public static Integer findMinValue(int [] arr){
        if(arr.length==0){
            return null;
        }
        Integer min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    // use O(n) // b
    public static Integer findMinValue2(int[] arr){
     int start = 0;
     int end = arr.length-1;
     while(start<end){
         int mid = start+(end-start)/2;
         if(arr[mid]<arr[end]){
             // end is sorted
             end = mid;
         }else{ // find in right half
             start = mid+1;

         }
     }
     return arr[start];
    }

    // use O(n) // b
    public static Integer findMaxValue2(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]<arr[end]){
                // end is sorted
                end = mid;
            }else{ // find in right half
                start = mid+1;

            }
        }
        System.out.println("value "+ arr[(start-1+arr.length)% arr.length] + " start :"+ start + " arr len: "+ arr.length);
        return arr[(start-1+arr.length)% arr.length];
    }

    public static Integer findMax(int [] arr){
        int i = 0;
        int j = arr.length -1;

        while(i < j) {
            int m = i + (j-i)/2;
            if (arr[m] < arr[j]) {
                //[m...j] is sorted
                // ans is on the left
                j = m;
            } else {
                i = m + 1;
            }

        }
        //i==j:
        return arr[(i-1+arr.length)%arr.length];
    }
    public static void main(String[] args) {
        int num[] = {2,3,4,5,6,1};
        System.out.println(findMinValue2(num));
        System.out.println(findMax(num));
        System.out.println(findMaxValue2(num));
    }
}
