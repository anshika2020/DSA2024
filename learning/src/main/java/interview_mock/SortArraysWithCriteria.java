package interview_mock;
import java.util.*;

public class SortArraysWithCriteria {
    /*

Given an array of integers, sort them based on the following criteria:

1) First, use the number of occurrences in the array DESC
2) Should multiple integers have the same # of occurrences, the
   tie-breaker should be the index of first occurrence (within the original input) ASC

For example, given the array:
[6, 7, 5, 3, 3, 5, 7, 7, 8]

The function should return:
[7, 7, 7, 5, 5, 3, 3, 6, 8]

1) return array
2) if the length input empty
3) like [7,7,7,7]

*/

        public static int[] sortArrayDesc(int num[]){
            int [] result = new int[num.length];

            // check the edge case
            if(num.length<1) return num;

            // use the map in which num[i] is the key and frequency : value
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<num.length;i++){
                map.put(num[i], map.getOrDefault(num[i],0)+1);
            }
            Queue<HashMap.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
            int count =0;

            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println("Size of queue: "+ queue.size());
                queue.add(entry);
            }

            while(queue.size()>0){
                Map.Entry<Integer,Integer> entry = queue.poll();
                for(int i=0; i< entry.getValue();i++){
                    result[count] = entry.getKey();
                    count++;
                }
            }
//
//            for(int n:map.keySet()){
//                System.out.println("value:" +map.get(n));
//                queue.add(n);
//
//            }
//
//            for(int i=0; i< map.size();i++){
//                int n1= queue.poll();
//                result[i] = n1;
//            }
            return result;
        }

        public static void main(String[] args) {
            int [] num= {6, 7, 5, 3, 3, 5, 7, 7, 8};
            System.out.println(Arrays.toString(sortArrayDesc(num)));
        }
    }

