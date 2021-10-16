class Solution53 {
  public int maxSubArray(int[] nums) {
    int maxSum = -99999;
    int currSum = -99999;
    for (int num : nums) {
      currSum = Math.max(currSum + num, num);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}