public class Solution905 {
  public int[] sortArrayByParity(int[] nums) {
    int evenIndex = 0;
    int oddIndex = nums.length - 1;
    int temp;
    while(evenIndex < oddIndex){
      while(nums[evenIndex] % 2 == 0 && evenIndex < oddIndex){
        evenIndex++;
      }
      while(nums[oddIndex] % 2 != 0 && evenIndex < oddIndex){
        oddIndex--;
      }
      temp = nums[evenIndex];
      nums[evenIndex] = nums[oddIndex];
      nums[oddIndex] = temp;
      evenIndex++;
    }

    return nums;
  }

  public static void main(String[] args) {
    Solution905 mySolution = new Solution905();
    int[] result = mySolution.sortArrayByParity(new int[]{1,2,3,4,5,6,7,8});
    for(int num: result){
      System.out.print(num);
    }
  }
}


