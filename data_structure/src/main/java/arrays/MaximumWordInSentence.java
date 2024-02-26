package arrays;

public class MaximumWordInSentence {

//2114. Maximum Number of Words Found in Sentences (LC)
    public static int mostWordsFound(String[] sentences) {
        int maxWords = Integer.MIN_VALUE;
        if(sentences.length<1) return 0;

        for(String str:sentences){
            String[]  newStr = str.split("\\s+");
            maxWords = Math.max(newStr.length, maxWords);
        }

        return maxWords;
    }

    public static void main(String[] args) {
        String str[] = {"w jrpihe zsyqn l dxchifbxlasaehj","nmmfrwyl jscqyxk a xfibiooix xolyqfdspkliyejsnksfewbjom","xnleojowaxwpyogyrayfgyuzhgtdzrsyococuqexggigtberizdzlyrdsfvryiynhg","krpwiazoulcixkkeyogizvicdkbrsiiuhizhkxdpssynfzuigvcbovm","rgmz rgztiup wqnvbucfqcyjivvoeedyxvjsmtqwpqpxmzdupfyfeewxegrlbjtsjkusyektigr","o lgsbechr lqcgfiat pkqdutzrq iveyv iqzgvyddyoqqmqerbmkxlbtmdtkinlk","hrvh efqvjilibdqxjlpmanmogiossjyxepotezo","qstd zui nbbohtuk","qsdrerdzjvhxjqchvuewevyzlkyydpeeblpc"};
        System.out.println(mostWordsFound(str));
    }
}
