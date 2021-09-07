import java.util.ArrayList;
import java.util.List;

public class Solution78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> current = new ArrayList<>();
    List<List<Integer>> subsets = new ArrayList<>();
    findSubsets(nums, current, 0, subsets);
    return subsets;
  }

  public void findSubsets(int[] nums, List<Integer> current, int index, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(current));
    for (int i = index; i < nums.length; i++) {
      current.add(nums[i]);
      findSubsets(nums, current, i + 1, subsets);
      current.remove(current.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution78 mySolution = new Solution78();
    System.out.println(mySolution.subsets(new int[]{1, 2, 3}));
  }
}
