package arrays;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class TaskId {




        public static void main(String args[] ) throws Exception {
            int[] num = {-3,6,5,1,5,9,5,10,1,2,7};
            ArrayList<Integer> list = new ArrayList<>();
            for(int n : num){
                list.add(n);
            }
            System.out.print(organizePriority(list));

        }


        public static List<List<Integer>> organizePriority(List<Integer> input) {
            List<List<Integer>> result = new ArrayList<>();
            // check edge case
            if(input.size()<1) return result;

            List<Integer> high = new ArrayList<>();
            List<Integer> medium = new ArrayList<>();
            List<Integer> low = new ArrayList<>();

            String str="";
            String [] priority = {"high","medium","low"};
            // iterate through the input list
            for(int i=0; i<input.size();i++){ // 2
                if(input.get(i)>0){
                    str = getPriority(input.get(i));
                    if(str.equalsIgnoreCase(priority[0])){
                        high.add(input.get(i));//0-high (2) ..
                    }else if(str.equalsIgnoreCase(priority[1])){
                        medium.add(input.get(i));
                    }else{
                        low.add(input.get(i));
                    }
                }else{
                    throw new IllegalArgumentException("The number is negative");
                }
            }

            result.add(high);
            result.add(medium);
            result.add(low);
            return result;
        }

        /**
         *
         * Given a taskId, this method determines the task's priority, and returns "high", "medium", or "low".
         * Do not worry about the implementation.
         */
        public static String getPriority(int taskId) {
            if (taskId <= 3) {
                return "high";
            } else if (taskId <= 7) {
                return "medium";
            } else {
                return "low";
            }
        }
    }
