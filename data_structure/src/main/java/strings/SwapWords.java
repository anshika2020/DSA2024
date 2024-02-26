package strings;

public class SwapWords {
    /*
    Given a string s, reverse the words.
Note: You may assume that there are no leading or trailing whitespaces and each word within s is only separated by a single whitespace.

Ex: Given the following string s…

s = "The Daily Byte", return "Byte Daily The".
     */

    public static String swapTheword(String str){
        String[] arr = str.split(" ");
        String newStr ="";

        int start =0; int end=arr.length-1;
        while(start<end){
            String temp=arr[start];
            arr[start] =arr[end];
            arr[end] =temp;
            start++;
            end--;
        }
      for(String s:arr){
          newStr+=" " +s;
      }
        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(swapTheword("The Daily Byte"));
    }
}
