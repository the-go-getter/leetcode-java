class Solution238 {
  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] leftProduct = new int[length];
    int[] rightProduct = new int[length];
    leftProduct[0] = 1;
    rightProduct[length-1] = 1;

    for(int i=1; i<length; i++){
      leftProduct[i] = leftProduct[i-1] * nums[i-1];
      System.out.println(leftProduct[i]);
    }

    for(int i=length-2; i>=0; i--){
      rightProduct[i] = rightProduct[i+1] * nums[i+1];
      System.out.println(rightProduct[i]);
    }

    int[] result = new int[length];
    for(int i=0; i<length; i++){
      result[i] = leftProduct[i] * rightProduct[i];
    }

    return result;
  }
}