package arrays;

import java.util.*;

public class findDouble {

    public static void find_doubles_in_list(int[] values) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // add the values and no. oc in map
        for(int i=0;i<values.length;i++){
            if(values[i]==0 || values[i]%2==0){
                map.put(values[i], map.getOrDefault(values[i], 0) + 1);
            }
        }

        for(int i =0; i<values.length;i++) {
            if(map.containsKey(values[i]*2) ){
                //System.out.println(n);
                if(map.get(values[i]*2)==1) {
                    list.add(values[i]);
                }
            }
        }
        Collections.sort(list);
        for(int n : list){
            System.out.printf(n + " ");
        }
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6,7,8,9,0,8};
        find_doubles_in_list(n);
    }
}
