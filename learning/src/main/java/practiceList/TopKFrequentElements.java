package practiceList;

import java.util.*;

public class TopKFrequentElements {
    /*
    Top K Frequent Elements
Given an integer array and a number k, find the k most frequent elements in the array.
Example One
Input: [1, 2, 3, 2, 4, 3, 1], 2
Output: [3, 1]
     */

    // Looking for thoughts to improve TC O(nlogn) to O(n)?

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        HashMap<Integer, Integer> temp = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< arr.size();i++){ //TC: O(n)
            //get the count for the element if already present in map or get default value which is 0
           temp.put(arr.get(i),temp.getOrDefault(arr.get(i),0)+1);
        }

       // to sort the hashmap we need to convert to list with entry set of the list so set map in arraylist as enteryset
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(temp.entrySet()); // TC: O(n)

        // tc: it uses iterative merge sort hence it is O(nlogn)
      //  list.sort(Map.Entry.comparingByValue());// sort the list by value, this will sort with the ascending order

        list.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;// sort in escending order
            }
        }));

        for(int i =0; i<k; i++){
            result.add(list.get(i).getKey());
        }
//        for(Map.Entry<Integer, Integer> entry :  list.subList(list.size()-k, list.size())){//TC: O(n)
//            result.add(entry.getKey()); // TC: O(1)
//        }

        // calculate total TC: O(n)+ O(n)+O(nlogn)+O(n) == O(nlogn)
        // Space complexity is O(n) because we are using hashmap to store which takes extra space
        return result;
    }
     // priority queue approach
     static ArrayList<Integer> find_top_k_frequent_elements1(ArrayList<Integer> arr, Integer k) {
         HashMap<Integer, Integer> map = new HashMap<>();
         ArrayList<Integer> result = new ArrayList<>();
         for(int i=0; i< arr.size();i++){ //TC: O(n)
             //get the count for the element if already present in map or get default value which is 0
             map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
         }
         // create a priority queue and using min heap
         /*
         min heap : the key present at root node must be less than or equal the key present of all of its children
         Reason of using minimum heap?max heap: in both case we will keep checking the min or max frequent element by shuffling the queue
         Time complexity:
         1. to build a heap of size k using n elements, add the first k elements take linear O(k) in the average case and O(log1+log2+..logk= O(logK!)= O(klogk) in the worst case
          After the first k element we start to push and pop at each step, which is n-k steps in total. That why the complexity of heap push/pop is O(nlogk)
         Time complexity of both heap is O(nlogk)
          */
         PriorityQueue<Integer> pqueue = new PriorityQueue<>((num1, num2)->map.get(num1)-map.get(num2)); // initialize the heap with less frequent element first but in max heap it would just opposite
         // now iterate map and put all in heap
         for(int num: map.keySet()){
             pqueue.add(num); // adding the values in priority queue ; TC: O(logk)
             if(pqueue.size()>k){
                pqueue.poll(); //TC: O(logk)
             }
         }
         // now add the values in result list
         for(int i=k-1;i>=0;--i){
             result.add(pqueue.poll());
         }
        return result;
     }
    public static void main(String[] args) {
        Integer [] arr = {1, 2, 3, 1,2, 4, 3,4, 4,1};
        ArrayList list= new ArrayList<>(Arrays.asList(arr));
        System.out.println(find_top_k_frequent_elements( list,2));
        System.out.println(find_top_k_frequent_elements1( list,2));
    }
}
