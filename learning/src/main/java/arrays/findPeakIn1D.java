package arrays;

public class findPeakIn1D {

    /*
     Find a peak element(Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours. For corner elements, we need to consider only one neighbour.)
     "Input: array[]= {5, 10, 20, 15}
     Output: 20
     The element 20 has neighbours 10 and 15,
     both of them are less than 20.

     Input: array[] = {10, 20, 15, 2, 23, 90, 67}
     Output: 20 or 90
     The element 20 has neighbours 10 and 15,
     both of them are less than 20, similarly 90 has neighbors 23 and 67."
    */

    private static int findPeakElementLinearScan(int arr[]){
        if(arr.length==0){
            return 0;
        }
            for(int i=0; i<arr.length-1; i++){
                if(arr[i]>arr[i+1]){
                    return arr[i];
                }
            }
            return arr.length-1;
    }
    // this approach can happen only if the array is sorted either in descending or ascending
    private static int findPeakRecursive(int[] nums){
        return searchPeakRecursively(nums, 0, nums.length-1);

    }

    private static int searchPeakRecursively(int[] nums ,int start,int end){
        if (start == end)
            return start;
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1])
            return searchPeakRecursively(nums, start, mid);
        return searchPeakRecursively(nums, mid + 1, end);
    }

    //iterative approach
    private static int searchPeakWIthIteration(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;

    }

    public static void main(String arg[]){
       //Linear approach

        int arr[] = {4,3,2,1};// in linear scan approach, case 1 where array is in descending order then first element would the the peak element and return
        System.out.println("Linear approach case1 : "+ findPeakElementLinearScan(arr));
        int arr1[] = {1,2,3,4};// in linear scan approach, case 2 where all the element are in ascending order then it would traverse all the element in the array and never satisfy the condition of arr[i]>arr[i+1] hence return arr.length-1 element but if the array size is very big then it will slow down the performance.
        System.out.println("Linear approach case2 : "+ findPeakElementLinearScan(arr1));
        int arr2[] = {1,2,3,2,1}; // in linear scan approach case 3,  where element is found it will return
        System.out.println("Linear approach case 3 : "+ findPeakElementLinearScan(arr2));

        // recursive binary search
        int arr3[] = {1,4,3,2};
        System.out.println("recursive binary search: at index "+findPeakRecursive(arr3));

        //iterative binary search

        System.out.println("iterative :" +searchPeakWIthIteration(arr3));
    }
}

