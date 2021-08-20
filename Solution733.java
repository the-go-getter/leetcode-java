public class Solution733 {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor) {
      return image;
    }
    int oldColor = image[sr][sc];
    fillThis(image, sr, sc, oldColor, newColor);
    return image;
  }

  private void fillThis(int[][] image, int sr, int sc, int oldColor, int newColor) {
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) {
      return;
    }

    image[sr][sc] = newColor;
    fillThis(image, sr + 1, sc, oldColor, newColor);
    fillThis(image, sr, sc + 1, oldColor, newColor);
    fillThis(image, sr - 1, sc, oldColor, newColor);
    fillThis(image, sr, sc - 1, oldColor, newColor);
  }

  public static void main(String[] args) {
    Solution733 mySolution = new Solution733();
    int[][] output = mySolution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    for (int[] row : output) {
      for (int value : row) {
        System.out.print(value);
      }
      System.out.print("\n");
    }
  }
}
