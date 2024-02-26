package recusions;

public class ReverseStringRecurs {

    private static String reverseString(String input){
          String temp = "";
        // logic for recursion
        for(int i = input.length()-1; i>=0; i--){
            char ch = input.charAt(i);
            temp+=ch;
        }
        return temp;
    }
    private static void reverseStringRecur(String input){
        if(input.length()<1||input==null){
            System.out.println(input);
            return;
        }
            System.out.print(input.charAt(input.length()-1));
            reverseStringRecur(input.substring(0, input.length() - 1));

    }


    public static void main(String[] args) {
        System.out.println(reverseString("mini"));
        reverseStringRecur("cool");
    }
}
