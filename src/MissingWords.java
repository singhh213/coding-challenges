import java.util.Arrays;

public class MissingWords {

    /*
        Given two sentences, x and y where y is a guaranteed to be a subsequence of x, find the sequence of words in x
        that are missing from y.

        - Both x and y contain words separated by spaces using a-z and A-Z

        Return array of strings containing the words missing from y where each element is a missing word.
        Words should be ordered in same sequence as found in x.

        Ex. x = "I like sports" and y = "like" -> missingWords(x, y) should return ["I", "sports"]

     */

    public static void main(String[] args) {
        String x = "I like sports";
        String y = "like";
        String[] missingWords = missingWords(x, y);
        System.out.println(Arrays.toString(missingWords));


        x = "I like to eat pizza for dinner and ice cream for desert";
        y = "for dinner and ice";
        missingWords = missingWords(x, y);
        System.out.println(Arrays.toString(missingWords));

        x = "Dog";
        y = "Dog";
        missingWords = missingWords(x, y);
        System.out.println(Arrays.toString(missingWords));
    }

    private static String[] missingWords(String s1, String s2) {

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        String[] missingWords = new String[words1.length - words2.length];

        int w2Index = 0;
        int mWordsIndex = 0;
        for (String word : words1) {
            if (w2Index >= words2.length || !word.equals(words2[w2Index])) {
                missingWords[mWordsIndex] = word;
                mWordsIndex++;
            } else {
                w2Index++;
            }
        }
        return missingWords;
    }
}
