import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (i == 0 || nums[i] != nums[i - 1]) {
          if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

            while (lo + 1 < nums.length && nums[lo] == nums[lo + 1]) {
              lo++;
            }
            while (hi - 1 > 0 && nums[hi] == nums[hi - 1]) {
              hi--;
            }
          }
        }

        if (sum < 0) {
          lo++;
        } else {
          hi--;
        }
      }
    }
    return result;
  }
}