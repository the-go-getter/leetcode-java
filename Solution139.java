import java.util.HashSet;
import java.util.List;

class Solution139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int left = 0; left < s.length(); left++) {
      for (int right = left; right <= s.length(); right++) {
        if (dp[left] && set.contains(s.substring(left, right))) {
          dp[right] = true;
        }
      }
    }

    return dp[s.length()];
  }
}
