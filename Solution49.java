import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
    for(String str: strs){
      char[] orderedArray = str.toCharArray();
      Arrays.sort(orderedArray);
      String ordered = new String(orderedArray);
      groupedAnagrams.put(ordered, groupedAnagrams.getOrDefault(ordered, new ArrayList<String>()));
      groupedAnagrams.get(ordered).add(str);
    }

    List<List<String>> result = new ArrayList<>(groupedAnagrams.values());
    return result;
  }

  public static void main(String[] args) {
    Solution49 mySolution = new Solution49();
    System.out.println(mySolution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
  }
}
