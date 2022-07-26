package strings;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        String [] strs = {"cair", "car", "cahar"};
        System.out.println(longestCommonPrefix(strs));
    }
    // ["","",""]


    public static String longestCommonPrefix(String[] strs) {
        String prefix="";
        // check edge case
        if(strs.length==0) {
            return prefix;
        }


        return helper(strs ,prefix,0);
    }

    public static String helper(String[] arr, String str, int index){
        if(arr.length==1) return arr[0];
        for(int i=0;i<arr.length-1;i++){
            if((arr[i].charAt(index)!=arr[i+1].charAt(index)) || index >= arr[i].length() || index >= arr[i+1].length() ){
                return str;
            }

        }
        str+=arr[0].charAt(index);
        return helper(arr, str,index+1);
    }

    public static String getLongestPrefixs(String[] arr){

        String prefix = "";
        // iterate through the first String length
        for(int i=0; i<arr[0].length();i++){
            char c = arr[0].charAt(i);
            for(int k=1; k<arr.length;i++){
                if(arr[i].charAt(i)!=c) {
                    return prefix;
                }
            }
            prefix+=c;
        }
    return prefix;
    }
}
