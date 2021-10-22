package strings;

public class SplitStringIntoBalancedString {

    /*
    Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
     */
    private static int balancedStringSplit(String s){
        int balancedCount =0; int count=0;
        String lCounterTotal = "";
        String rCounterTotal = "";
        for(int i=0;i<s.length();i++) {
            char current = s.charAt(i);
            if (current == 'L') {
                lCounterTotal+=String.valueOf(current);
                count++;
            } else if (current == 'R') {
                rCounterTotal+=String.valueOf(current);
                count--;
            }
            if (count == 0) {
                balancedCount++;
            }

        }
        System.out.println("lCounterTotal  "+ lCounterTotal);
        System.out.println("rCounterTotal "+ rCounterTotal);
        if(lCounterTotal.length()!=rCounterTotal.length()){
            System.out.println("String is not balanced");
            return 0;
        }else {
            return balancedCount;
        }

    }

    public static void main(String args[]){
        System.out.println("Values: " + balancedStringSplit("RLRRLLRLRL"));
    }
}

