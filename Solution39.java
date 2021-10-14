import java.util.ArrayList;
import java.util.List;

class Solution39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    findCombos(candidates, target, result, 0, new ArrayList<>());
    return result;
  }

  public void findCombos(int[] candidates, int target, List<List<Integer>> result, int currIndex, ArrayList<Integer> current) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = currIndex; i < candidates.length; i++) {
      current.add(candidates[i]);
      findCombos(candidates, target - candidates[i], result, i, current);
      current.remove(current.size() - 1);
    }
  }
}