public class Solution14 {
  public String longestCommonPrefix(String[] strs) {
    String result = new String();
    char current = ' ';
    for (int j = 0; j < strs[0].length(); j++) {
      current = strs[0].charAt(j);
      for (int i = 0; i < strs.length; i++) {
        if (j < strs[i].length() && strs[i].charAt(j) == current) {
          continue;
        } else {
          return result;
        }
      }
      result += current;
    }
    return result;
  }
}
