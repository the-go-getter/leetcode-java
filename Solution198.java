public class Solution198 {
  public int rob(int[] nums) {
    if(nums == null || nums.length == 0){
      return -1;
    }

    int size = nums.length;
    int[] amount = new int[size];

    if(size > 0){
      amount[0] = nums[0];
    }

    if(size > 1){
      amount[1] = Math.max(nums[0], nums[1]);
      for(int i = 2; i<size; i++){
        amount[i] = Math.max(amount[i-1], amount[i-2] + nums[i]);
      }
    }

    return amount[size-1];
  }

  public static void main(String[] args) {
    Solution198 mySolution = new Solution198();
    System.out.println(mySolution.rob(new int[]{1,2,3,1}));
  }
}
