class Solution27 {
  public static int removeElement(int[] nums, int val) {
    int result = 0;
    int temp;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        temp = nums[i];
        nums[i] = nums[result];
        nums[result] = temp;
        result += 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Solution27.removeElement(new int[]{3, 2, 2, 3}, 3));
  }
}
