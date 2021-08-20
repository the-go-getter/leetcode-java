import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution819 {
  public String mostCommonWord(String paragraph, String[] banned) {
    HashSet<String> bannedWords = new HashSet<String>(Arrays.asList(banned));
    HashMap<String, Integer> wordCount = new HashMap<>();
    String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
    String result = "";
    int maxCount = 0;
    for (String word: words){
      if (!bannedWords.contains(word)){
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }
    }

    for(String word: wordCount.keySet()){
      if (wordCount.get(word) > maxCount){
        result = word;
        maxCount = wordCount.get(word);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution819 mySolution = new Solution819();
    System.out.println(mySolution.mostCommonWord("Bob hit a ball, the hit BALL flew far " +
            "after it was hit.", new String[]{"hit"}));
  }
}
