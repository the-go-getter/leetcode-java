import java.util.ArrayList;
import java.util.List;

class Solution22 {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    recursiveHelper(n, result, "", 0, 0);
    return result;
  }

  public void recursiveHelper(int max, List<String> result, String current, int open, int close) {
    if (current.length() == 2 * max) {
      result.add(current);
      return;
    }

    if (close < open) {
      recursiveHelper(max, result, current + ")", open, close + 1);
    }

    if (open < max) {
      recursiveHelper(max, result, current + "(", open + 1, close);
    }
  }

  public static void main(String[] args) {
    Solution22 mySolution = new Solution22();
    System.out.println(mySolution.generateParenthesis(3));
  }
}