package selfTest;

public class BinarySearchTarget {

    public static int searchTarget(int arr[], int target){
        if(arr.length==0){ // check base
            return -1;
        }
        if(arr[0]==target){ // check if the first element is the target
            System.out.println("the value is at 0th index");
            return 0;
        }

        if(arr[arr.length-1]==target) {

            System.out.println("value : "+ (arr.length-1));
            return arr.length-1;
        }
        // now go with binary search
        int start = 1;
        int end = arr.length-1;
        while(start<end){
            //Clearly “(end-start)/2” is less than “end” and this formula will not cause integer overflow for large values of start and end.
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
     return -1;
    }

    public static void main(String[] args) {
        int num[] ={-1,0,3,5,9,12};
        System.out.println(searchTarget(num, 12));
    }
}
