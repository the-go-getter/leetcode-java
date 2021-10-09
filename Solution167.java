class Solution167 {
  public int[] twoSum(int[] numbers, int target) {
    int sum = 9999;
    int[] indices = new int[2];
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int currSum = numbers[left] + numbers[right];
      if (Math.abs(target - currSum) < Math.abs(target - sum)) {
        sum = currSum;
        indices[0] = left + 1;
        indices[1] = right + 1;
      }

      if (currSum < target) {
        left++;
      } else {
        right--;
      }
    }
    return indices;
  }
}
