package sortingPgm;

import java.util.Arrays;

public class HeapSorting {


    /*
    function to heapify a subtree and 'i' is the index of root node in array a[] and 'n' is the size of heap
     */
    public static void heapify(int a[], int n, int i){
        int largest = i; // initialize largest as a root
        int left = 2*i+1; // left child
        int right = 2*i+2;// right child

        System.out.println("largest:: "+ largest +" left:: "+ left + " right ::"+ right);

        // check if the left child larger than root
        if(left<n && a[left]>a[largest]){
          largest=left;
            System.out.println(" left child larger: "+ Arrays.toString(a));
        }
        // check if the right child larger than root
        if(right<n && a[right]>a[largest]){
            largest=right;
            System.out.println(" right child larger: "+ Arrays.toString(a));
        }
        //if root is not largest
        if (largest!=i){
            //swap a[i] with a[largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest]=temp;
            heapify(a, n, largest);
            System.out.println(" after heapifying: "+ Arrays.toString(a));
        }

    }
    /*
    function to implement the heap sort
     */
    static void heapSort(int a[], int n){
        for(int i=n/2-1;i>=0;i--){ //
            heapify(a, n, i);
            System.out.println("i : "+i + " Arrays after heapify :"+ Arrays.toString(a)+ "n : "+ n);
        }
        // one by one extract an element from heap
        for(int i=n-1; i>=0; i--){
            /* move current root element to end */
           // swap a[0] with a[i]
            int temp = a[0];
            a[0]= a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

public static void main(String[] str){
        int[] a= {81,89,9,11,14,76,54,22};
        int n = a.length;
        heapSort(a, n);
    System.out.println("sorted arrays :" + Arrays.toString(a));
}
}
