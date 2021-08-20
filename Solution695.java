public class Solution695 {
  public int maxAreaOfIsland(int[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          result = Math.max(result, findArea(grid, i, j));
        }
      }
    }
    return result;
  }

  private int findArea(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
      return 0;
    } else {
      grid[i][j] = 0;
      return 1 + findArea(grid, i + 1, j) + findArea(grid, i - 1, j) +
              findArea(grid, i, j + 1) + findArea(grid, i, j - 1);
    }
  }

  public static void main(String[] args) {
    Solution695 mySolution = new Solution695();
    System.out.println(mySolution.maxAreaOfIsland(new int[][]
                    {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                    {0,1,0,0,1,1,0,0,1,1,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
  }
}
