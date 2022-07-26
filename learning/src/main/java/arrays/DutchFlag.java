package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DutchFlag {
    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {

        int start= 0;
        int end = balls.size()-1;
        int colorCnt =0;
        if(balls.size()<2) return balls;

        if((balls.size()<=2 &&balls.get(0)==balls.get(1))){
            return balls;
        }

        while(colorCnt<=end){

            if(balls.get(colorCnt) =='R'){
                swap(balls,start,colorCnt);
                start++;
                colorCnt++;
            }else if(balls.get(colorCnt) =='B'){
                swap(balls,colorCnt,end);
                end--;
            }else{
                colorCnt++;
            }
        }

        return balls;
    }

    static void swap(ArrayList<Character>arr, int i, int j){
        char ch = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j ,ch);
    }

    public static void main(String[] args) {
       Character[] ch = {'R','B','G','R','B','G','R','B','G'};

       ArrayList<Character> list = new ArrayList<>(Arrays.asList(ch));
        System.out.println(dutch_flag_sort(list));
    }
}
