import java.util.Arrays;

public class Solution973 {
  public int[][] kClosest(int[][] points, int k) {
    Arrays.sort(points, (x, y) -> (x[0]*x[0] + x[1]*x[1]) - (y[0]*y[0] + y[1]*y[1]));
    return Arrays.copyOfRange(points, 0, k);
  }

  public static void main(String[] args) {
    Solution973 mySolution = new Solution973();
    int[][] out=  mySolution.kClosest(new int[][]{{1,3},{2,-2}}, 1);
    System.out.println(Arrays.deepToString(out));
  }
}
