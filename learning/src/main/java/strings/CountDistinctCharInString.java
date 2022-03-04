package strings;

public class CountDistinctCharInString {

    public static int countDistinctChar(String str){
        return Math.toIntExact(str.chars().distinct().count());
    }

    public static void main(String[] args) {
        System.out.println(countDistinctChar("Abcered"));
    }
}
