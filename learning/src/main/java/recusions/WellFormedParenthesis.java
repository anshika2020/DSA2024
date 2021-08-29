package recusions;

import org.w3c.dom.css.CSSUnknownRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WellFormedParenthesis {

     static int loopcnt = 0;
    static List<String> getWellFormParent(int k){
        List<String> results = new ArrayList<>();
        helper(k, k, String.valueOf(new char[2*k]), results);
        return results;
    }
    static String[] find_all_well_formed_brackets(int n) {
       List<String> results = new ArrayList<>();
        helper(n, n, String.valueOf(new char[2*n]), results);
        return results.toArray(new String[0]);
    }
    // parameter passed are #left and #right braces , slate to store partial solution and result to store the final soltution
    static void helper(int left, int right, String slate, List<String> results) {

        //check the backtracking base case, this base is take care of invalid execution
        if (left > right || left < 0 || right < 0) {// left >right : number of left opening braces is greater than right is not ballanced parenthesis
            return;
        }
        // base case
        if (left == 0 && right == 0) { // this base case is to add the complete solution to results once condition is met
            results.add(slate.trim());
            System.out.println("loopcnt: "+ loopcnt++ + " : left : " + left+ " : right : "+ right +" : slate :" + slate);
            return;
        }
        System.out.println("loopcnt: "+ loopcnt++ + " : left : " + left+ " : right : "+ right +" : slate :" + slate);
        //recursive calls happens here
        helper(left - 1, right, slate + "(", results);// this is design the left bracket
        helper(left, right-1, slate + ")", results);// right bracket

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find_all_well_formed_brackets(2)));
    }
}
