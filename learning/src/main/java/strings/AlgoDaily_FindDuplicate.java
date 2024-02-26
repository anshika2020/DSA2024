package strings;

import java.util.*;

public class AlgoDaily_FindDuplicate {
    public static String[] findDuplicates(String input) {
        // fill in
        Map<String, Integer> map = new HashMap<>();
        String[] str = input.toLowerCase().split(" ");
        String[] result = new String[str.length / 2];
        int index = 0;
        System.out.println(Arrays.toString(str));
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }

    // another aporach
    public static String[] findDuplicates1(String input) {
    /*
    1. Using map
    2. keep adding in result array if the cnt is 2 or more and if already exist in result array then skip
    */

        String[] str = input.toLowerCase().split(" ");
        Set<String> set = new HashSet<>();
        String newStr = str[0];
        Arrays.sort(str);
        for (int i = 1; i < str.length; i++) {
            if (newStr.equalsIgnoreCase(str[i])) {
                set.add(newStr);
            }
        }
        String result[] = set.toArray(new String[set.size()]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicates1("The dog is is the Dog best best")));
    }
}
