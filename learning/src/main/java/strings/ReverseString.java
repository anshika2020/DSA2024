package strings;

public class ReverseString {

    /*
    How to reverse a String in java? Can you write a program without using any java inbuilt methods?
     */
    public String reveseString(final String str){
        String reverse="";
       if(!str.contains("") || str!=null){
           for(int i=str.length()-1;i>=0;i--){
               reverse+=str.charAt(i);
           }
       }
       System.out.print("\nreversed string ::"+ reverse);
       return reverse;
    }

    // reverse the String but not the place of the string

//    public String reverseStringNotPlace(final String str){
//
//
//    }
}
