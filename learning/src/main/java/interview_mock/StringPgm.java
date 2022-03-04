package interview_mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringPgm {

    public static String getFrequencyCharInString(final String line){
        if(line.isEmpty()) return "String is empty";

        Map <Character, Integer> map = new HashMap<>();
        String newStr = "";

        char[] c = line.toLowerCase().toCharArray();
        Arrays.sort(c);
        System.out.println("sorted arrays:" +Arrays.toString(c));

        for(int i=0; i<c.length;i++){
            map.put(c[i], map.getOrDefault(c[i],0)+1);
        }

        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            String str1 = String.valueOf(entry.getKey());
            Integer str2 = entry.getValue();
            newStr = newStr+String.valueOf(entry.getKey())+entry.getValue();
        }
        System.out.println("String :" + newStr);
        return newStr;
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            System.out.println(getFrequencyCharInString(line));
        }
    }
}
