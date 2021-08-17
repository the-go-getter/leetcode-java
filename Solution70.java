public class Solution70 {
  public static int climbStairs(int n) {
    int[] ways = new int[n+1];
    ways[0] = 1;
    ways[1] = 1;
    for (int step = 2; step < n+1; step++){
      ways[step] = ways[step-1] + ways[step-2];
    }
    return ways[n];
  }

  public static void main(String[] args) {
    System.out.println(Solution70.climbStairs(3));
  }
}
