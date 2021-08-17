import java.util.ArrayList;
import java.util.List;

public class Solution17 {
  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    findCombos(digits, map, 0, "", result);
    return result;
  }

  private static void findCombos(String digits, String[] map, int index, String combo, List<String> result) {
    if (index == digits.length()) {
      result.add(combo);
      return;
    }

    String letters = map[digits.charAt(index) - '0'];

    for (char letter : letters.toCharArray()) {
      findCombos(digits, map, index + 1, combo + letter, result);
    }
  }

  public static void main(String[] args) {
    System.out.println(Solution17.letterCombinations("23"));
  }
}
