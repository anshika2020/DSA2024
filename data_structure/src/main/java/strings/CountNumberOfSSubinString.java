package strings;

public class CountNumberOfSSubinString {

    private static int countSubstringOccurrences(String inputString, String substring) {
        int count = 0;
        int index = 0;

        while ((index = inputString.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.printf(" value " + countSubstringOccurrences( "ABBAC","AB"));
    }
}
