class Solution42 {
  public int trap(int[] height) {
    int length = height.length;
    int[] leftMax = new int[length];
    int[] rightMax = new int[length];
    leftMax[0] = 0;
    rightMax[length-1] = 0;

    for(int i = 1; i<length; i++){
      if(height[i-1] > leftMax[i-1]){
        leftMax[i] = height[i-1];
      } else{
        leftMax[i] = leftMax[i-1];
      }

      if(height[length-i] > rightMax[length-i]){
        rightMax[length-1-i] = height[length-i];
      } else{
        rightMax[length-1-i] = rightMax[length-i];
      }
    }

    int trappedWater = 0;
    for(int i=0; i<length-1; i++){
      int currentWater = Math.min(leftMax[i], rightMax[i]) - height[i];
      if(currentWater > 0){
        trappedWater+=currentWater;
      }
    }

    return trappedWater;
  }
}