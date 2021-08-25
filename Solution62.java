public class Solution62 {
  public int uniquePaths(int m, int n) {
    int[][] ways = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          ways[i][j] = 1;
        } else {
          ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
        }
      }
    }
    return ways[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Solution62 mySolution = new Solution62();
    System.out.println(mySolution.uniquePaths(3,7));
  }
}
