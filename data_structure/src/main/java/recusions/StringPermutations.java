package recusions;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

        // ABC


    private static void getPermutaion(String input){
        helper(input, "");

    }

    private static void helper(String input, String prefix) {

        if(input.length()==0){
            System.out.println(prefix);
            return;
        }
        // recursion logic
        for(int i = 0;i<input.length();i++ ){
            char ch = input.charAt(i);
            String res = input.substring(0, i)+ input.substring(i+1);// i+1 means i+1 to length
            helper(res, prefix+ch);
        }
    }


    public static List<String> getAllPerm(String str){
        List<String> result = new ArrayList<>();
        sthelper(str, 0, result);
        return result;

    }
    static void sthelper(String input, int index, List<String> result) {
        // base case
        if (index == input.length()) {
            result.add(input);
            return;
        }

        // recursive call ; iterate 0-->input len then swap the input
        for (int i = index; i < input.length(); i++) {

            input = swap(input, i, index);
            sthelper(input, index + 1, result);
            input = swap(input, index, i);

        }
    }

    public static String swap(String str, int i, int j){
        char temp= '0';
        char[] ch = str.toCharArray();
        temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return String.valueOf(ch);
    }




    public static void main(String[] args) {
        getPermutaion("ABC");
        System.out.println(getAllPerm("XYZS"));
    }

}
