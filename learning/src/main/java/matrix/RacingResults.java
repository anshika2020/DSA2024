package matrix;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

public class RacingResults {

    public static void printClassifications(List<List<Integer>> raw_data){

        if(raw_data.size()<1) return;
        int racer_name =0; int racerPoint =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<raw_data.size();i++){
            racer_name = raw_data.get(i).get(1);
            racerPoint = getPoints(raw_data.get(i).get(2));
            if(map.containsKey(racer_name)){
                map.put(racer_name, map.get(racer_name) +racerPoint);
            }else{
                map.put(racer_name, racerPoint);
            }
        }
        int winnerPoint = Integer.MIN_VALUE; int winner =0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>winnerPoint){
                winnerPoint = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.println("\n result : "+ winner +" " + winnerPoint );

    }

    private static int getPoints(int position){
        if(position==1){
            return 10;
        }else if(position==2){
            return 6;
        }else if(position==3) {
            return 4;
        }else if(position==4) {
            return 3;
        }else if(position==5) {
            return 2;
        }else if(position==6) {
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
       // List<Integer> val  = new ArrayList<>();
        Integer [][] num = {{2001,1001,3},{2001,1002,2},{2002,1003,1},{2002,1001,2},{2002,1002,3},{2001,1003,1}};
        List<List<Integer>> list = new ArrayList<>();
        for(Integer [] n : num){
            list.add(Arrays.asList(n));
        }
        printClassifications(list);
    }
}
