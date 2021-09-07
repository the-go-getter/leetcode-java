public class Solution64 {
  public int minPathSum(int[][] grid) {
    int[][] dp = grid.clone();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (i == 0 && j == 0) {
          dp[0][0] = grid[0][0];
        } else if (i == 0) {
          dp[i][j] = grid[i][j] + dp[i][j - 1];
        } else if (j == 0) {
          dp[i][j] = grid[i][j] + dp[i - 1][j];
        } else {
          dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }
}
