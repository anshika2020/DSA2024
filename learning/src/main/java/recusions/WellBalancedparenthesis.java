package recusions;

import java.util.ArrayList;
import java.util.List;

public class WellBalancedparenthesis {

    // Return well balanced parenthesis

    private static List<String> wellBalancedParenthesis(int k){
        List<String> results = new ArrayList<>();
        helper(k, k, new String(), results);
        return results;
    }

    private static void helper(int openingBraces, int closingBraces, String slate, List<String> results) {
        // base case for backtracking
        if(openingBraces>closingBraces||openingBraces<0||closingBraces<0){
            return;
        }

        // base case
        if(openingBraces==0&&closingBraces==0){
            results.add(slate);
            return;
        }
        helper(openingBraces-1, closingBraces, slate+"{", results );
        helper(openingBraces,closingBraces-1, slate+"}", results);
    }

    public static void main(String[] args) {
        System.out.println(wellBalancedParenthesis(2));
    }
}
