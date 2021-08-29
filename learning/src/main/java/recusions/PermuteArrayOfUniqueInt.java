package recusions;

import java.util.*;

public class PermuteArrayOfUniqueInt {

    static int count=0;
    /*
    Permute Array Of Unique Integers
Given an array of unique numbers, return in any order all its permutations.
Example One
Input: [1, 2, 3] == Output: [[1, 2, 3], [1, 3, 2],[2, 1, 3], [2, 3, 1],[3, 2, 1], [3, 1, 2]]
Notes
Input is an array of integers.
Return a two-dimensional integer array.
Constraints:
0 <= n <= 9
0 <= any array element <= 99
Custom Input
Input Format:
First line: length of the array, n.
Next n lines, the input numbers.
Example:
3
1
2
3
Output Format:
Each permutation gets its own line in the output. Numbers in each permutation are separated by one space character. Example:
1 2 3
1 3 2
2 1 3
2 3 1
3 2 1
*/


    static List<List<Integer>> get_permutations(List<Integer> arr) {
     List<List<Integer>> results = new ArrayList<>();
     // create a helper
        helper(arr,0,results);
       // dfs(arr,new ArrayList<Integer>(arr),results);
        // return result
        return results;
    }
    private static void helper(List<Integer> input, int index, List<List<Integer>> results){
        // base case: if index>=slate then add slate value in the list

        if(index==input.size()){
            // to handle uniqueness
           // if(!results.contains(input)) {
                results.add(new ArrayList<>(input));
          //  }
            return;
        }

        // recursive call
        for(int i = index; i< input.size();i++) {
                swap(input, i, index); // keeping track of
                helper(input, index + 1, results);
                swap(input, index, i);
            }
        }




    static void swap(List<Integer> arr, int i, int j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
    }


    //another approach


    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.size() == 0) {
            return results;
        }
        helper1(nums, new ArrayList<>(nums.size()),results);
        return results;
    }

    public static void helper1(List<Integer> arr, List<Integer> slate, List<List<Integer>> results) {
        if (arr.size() == slate.size()) {
            List<Integer> temp = new ArrayList<>(slate);
            results.add(temp);
        }
        for (int i=0; i<arr.size(); i++) {
            if (!slate.contains(arr.get(i))) {
                slate.add(arr.get(i));
                helper1(arr , slate,results);
                slate.remove(slate.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {98, 84, 70, 65 ,54 ,43 ,37 ,28 ,18};
       // Integer[] arr = {1,2,3};

        int[] arr1 = {1,2,3};
        System.out.println(get_permutations(Arrays.asList(arr)));
        //System.out.println(permute(Arrays.asList(arr)));
    }

    public static class DutchNationalFlag {
        /*
        Dutch National Flag
    Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
    Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
    This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).
    Example
    Input: [G, B, G, G, R, B, R, G]
    Output: [R, R, G, G, G, G, B, B]
         */
        private static char[] dutchFlagForTwo(char[] balls){
            int start =0;
            int end = balls.length-1;
            int temp = 0; // for middle color
            while(start<=end) {
                if (balls[start] == 'R') {
                    start++;
                }
                else if (balls[end] == 'B') {
                    end--;
                }
                 else {
                    swap(balls, start, end);
                    start++;
                    end--;


                }
                temp++;
            }
            System.out.println(Arrays.toString(balls));
            return balls;
        }

        // now try to solve problem by extending existing solution
        private static void dutchFlagThreeColor(char[] ball){
           //[G, B, G, G, R, B, R, G]
            //{'G','G','G','R','R','B','B','B' }
            int start =0;
            int end = ball.length-1;
            int colorCounter = 0; // like any tmp variable
            int loopCount=0;
            //{'R','G','B' }
            if((ball.length<=2 && ball[0]==ball[1])||(ball.length<2)){
                return;
            }
            while(colorCounter<=end){ // run the loop from colorCounter where colorCounter is set to 0 in begining
                if(ball[colorCounter]=='R'&&start>colorCounter){
                    //  ball[0] ==R : F
                    //ball[1] : F
                    //ball[2] : F
                    //ball[3] : T
                    //ball[4] : T and start =1;
                    swap(ball, start,colorCounter); // ball[3], start = 'G' colorCnt ='R' , swap
                    //ball[3] : R,G,G,G,R','B','B','B'
                    //swap : start =G colorCnt= R
                    //ball[3]: R,R,G,G,G,B,B,B
                    start++;
                    // start =1
                }else if(ball[colorCounter]=='B'){
                    //ball[0]==B : F
                    //ball[1]==B : F
                    //ball[1]==B : F
                    swap(ball,colorCounter,end);
                    end--;
                }else {
                    //ball[0] : true
                    //ball[1] : true
                    //ball[2] : True
                    colorCounter++;
                }
                loopCount++;
                System.out.println("loopCount: "+ loopCount + " ColorCounter: "+colorCounter+ " Arrays :" + Arrays.toString(ball));

            }
            System.out.println(Arrays.toString(ball));
        }
        static void swap(char[] balls, int i, int j){
            char temp = balls[i];
            balls[i] = balls[j];
            balls[j] = temp;
        }

        public static void main(String[] args) {
            char[] ch = {'R','G','B' };
            char[] balls = {'B','R','B','R' };

            // first try to solve the problem for two
           // dutchFlagForTwo(balls);
            System.out.println(Arrays.toString(ch));
            dutchFlagThreeColor(ch);
        }
    }
}
