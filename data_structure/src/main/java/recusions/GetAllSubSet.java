package recusions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GetAllSubSet {
    static String[] generate_all_subsets(String s) {
        List<String> list = new ArrayList<>();
        helperSubsetStrg(s,list,"");
        String[] result = new String[list.size()];
        return list.toArray(new String[0]);
    }

    private static void helperSubsetStrg(String s,List<String> list ,String prefix) {
    //
        if(s.length()==0){
            list.add(prefix);
            return;
        }
        char ch = s.charAt(0);
        String restStr= s.substring(1);
        helperSubsetStrg(restStr, list,prefix); // excluding the char for rest of the string part
        helperSubsetStrg(restStr, list,prefix+ch); // want to include the letter or subset

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate_all_subsets("xyz")));
    }

}
