package recusions;

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

    public static void main(String[] args) {
        getPermutaion("ABC");
    }

}
