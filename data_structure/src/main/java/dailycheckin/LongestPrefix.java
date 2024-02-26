package dailycheckin;

public class LongestPrefix {

    public static String findLongestPrefixBrute(String [] arr){
        if(arr.length<=1) return "";
        int start =0;
        String prefix = "";

        for(int i=1; i<arr.length;i++){
            if(arr[i].contains(String.valueOf(arr[start].charAt(start)))){
                prefix += arr[start].charAt(start);
                start++;
            }else{
                return "no prefix found";
            }
        }
        return prefix;

    }

    public static void main(String[] args) {
        String [] arr = {"cow", "could", "couch"};
        //findLongestPrefixBrute(arr);
        System.out.println(" prefix:  "+ findLongestPrefixBrute(arr));
    }
}
