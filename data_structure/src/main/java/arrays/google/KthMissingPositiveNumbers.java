package arrays.google;

public class KthMissingPositiveNumbers {

    /*
    We can use binary search to find the index i such that the number of missing positive integers before index i is equal to k. If the number of missing positive integers before index i is less than k, we need to search the right half of the array. If the number of missing positive integers before index i is greater than or equal to k, we need to search the left half of the array.

To find the number of missing positive integers before index i, we can use the formula arr[i] - i - 1, which represents the difference between the actual value of the element at index i and the expected value of the element at index i in a complete array of all positive integers.

Once we find the index i, we can return the kth missing positive integer, which is equal to arr[i] + k - (arr[i] - i - 1).

Complexity:
Time complexity: O(logn)O(log n)O(logn), where n is the length of the input array. We are using binary search to find the index of the kth missing positive integer, which takes logarithmic time.
Space complexity: O(1)O(1)O(1). We are using constant extra space to store the left and right pointers in binary search.


     */
    public static int findKthPositive(int[] arr, int k) {

        /*
    we can use binary search as the array is sorted,
    */
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
                // Otherwise, go left.
            } else {
                right = mid - 1;
            }
        }

        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }
    // O(n)

    public int findKthPositive1(int[] arr, int k) {
        boolean[] present = new boolean[arr[arr.length - 1] + 1];

        for (int val : arr) {
            present[val] = true;
        }
        int missing = 0;
        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                missing++;
                if (missing == k) {
                    return i;
                }
            }
        }

        return arr[arr.length - 1] + (k - missing);
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int[] arr1 = {1, 2, 3, 4};
        int k1 = 2;
        System.out.printf(" number : " + findKthPositive(arr, k));
        System.out.printf(" number : " + findKthPositive(arr1, k1));

    }
}
