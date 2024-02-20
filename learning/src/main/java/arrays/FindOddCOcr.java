package arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOddCOcr {

    public static void getOdd(int [] num){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<num.length;i++){
            map.put(num[i] , map.getOrDefault(num[i], 0)+1);
        }
        for(int i=0; i<num.length;i++){
            if(map.get(num[i])%2!=0){
                System.out.print(num[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        getOdd(new int[] {4,4,5,2,2,7,10});
    }
}

