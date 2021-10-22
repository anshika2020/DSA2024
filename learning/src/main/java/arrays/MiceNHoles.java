package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MiceNHoles {
    public static int miceTravel(ArrayList<Integer> A, ArrayList<Integer> B) {
        int minTime =0;
        // base check
        if(A.size()!=B.size()){
            return -1;
        }
        // sort the mice and holes list
        Collections.sort(A);
        Collections.sort(B);

        // calculate min time
        for(int i=0; i<A.size();i++){
            int temp = Math.abs(A.get(i)-B.get(i));
            if(minTime<temp){
                minTime = Math.abs(A.get(i)-B.get(i));
            }
        }
        return minTime;
    }

    public static void main(String[] args) {

        ArrayList<Integer> mice = new ArrayList<>(Arrays.asList(-4, 2, 3));
        ArrayList<Integer> holes = new ArrayList<>(Arrays.asList(0, -2, 4));

        System.out.println(miceTravel(mice, holes));

       }
}
