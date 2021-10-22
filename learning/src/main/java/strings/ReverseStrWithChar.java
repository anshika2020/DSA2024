package strings;

public class ReverseStrWithChar {
/*
Algorithm

Set pointer left at index 0, and pointer right at index n - 1, where n is a number of elements in the array.

While left < right:

Swap s[left] and s[right].

Move left pointer one step right, and right pointer one step left.
 */
    public static char[] reverseString(char[] s) {
        int right = s.length-1; int left =0;
       while(left<right){
           char temp = s[left];
           s[left++] = s[right];
           s[right--] = temp;
       }
        System.out.print("[");
       for(char ch: s) {
           System.out.print("\""+ch +"\",");

       }
        System.out.print("]");
        return s;
    }

    public static void main(String arg[]){
        char[] s = {'h','e','l','l','o'};
        System.out.println(reverseString(s));
    }
}
