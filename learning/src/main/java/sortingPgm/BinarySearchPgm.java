package sortingPgm;

public class BinarySearchPgm {

    // q1. find the given element in a sorted array

    public static int searchElem(int x, int[] arr) {
        // mid = low + (high - low) / 2

        int low = 0;
        int high = arr.length - 1;
        int mid = 0; // get the low and high
        while (low <= high) {
            mid = low + (high - low) / 2; // get the middle element

            if (arr[mid] < x) { // mid elem is less than given element
                low = mid + 1;
            } else if (arr[mid] > x) {// mid elem is greater than given element
                high = mid - 1;
            } else {
                return mid; // mid elem is the given elem
            }
        }
        return -1;
    }


    //Given a sorted array of String and a String x, find index of x if it is present in the array.

    public static int searchStr(String[] str, String searchKey) {
        int low = 0;
        int high = str.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = searchKey.compareToIgnoreCase(str[mid]);
            if (res > 0) {
                low = mid + 1;
                System.out.println("The value is ::" + str[low]);

            } else if (res < 0) {
                high = mid - 1;
                System.out.println("The value is ::" + str[high]);
            } else {
                System.out.println("The value is ::" + str[mid]);
                return mid;
            }
        }
        return -1;
    }

    //Search an element in a sorted and rotated array
    /*
        Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
        Output : Found at index 8
     */




    public static void main(String arg[]) {
        int arr[] = {-1, 12, 34, 45, 46, 67, 68, 79};
        int result = searchElem(0, arr);
        ;
        if (result == -1) {
            System.out.println("elem not found in the array " + result);
        } else {
            System.out.println("The elem's position is @ " + result);

        }


        //String test
        String str[] = {"contribute", "geeks", "ide", "practice"};
        int result1 = searchStr(str, "geeks");
        ;
        if (result1 == -1) {
            System.out.println("elem not found in the array " + result1);
        } else {
            System.out.println("The elem's position is @ " + result1);
        }
    }


}
