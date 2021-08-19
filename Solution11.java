public class Solution11 {
  public static int maxArea(int[] height) {
    int area;
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
      area = (right - left) * Math.min(height[left], height[right]);

      if (area > maxArea) {
        maxArea = area;
      }

      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    System.out.println(Solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
