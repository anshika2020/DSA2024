package recusions;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DistinctSubset {

    // Complete the function below.
    public static List<String> get_distinct_subsets(String str) {
        List<String> result = new ArrayList<String>();
        helper(str, 0, new char[str.length()], result);
        return result;
    }

    static void helper(String input, int idx, char[] slate, List<String> result){
        if(idx >= input.length()){
            result.add(new String (slate));
            return;
        }

        char c = input.charAt(idx);
        slate[idx] = c;
        helper(input, idx+1, slate, result);
        slate[idx] = '\0';
        helper(input, idx+1, slate, result);
    }

    public static void main(String[] args) {
        System.out.println(get_distinct_subsets("aab"));
    }
}
