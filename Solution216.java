import java.util.ArrayList;
import java.util.List;

class Solution216 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    findCombos(k, n, 1, new ArrayList<>(), result);
    return result;
  }

  public void findCombos(int k, int target, int currNum, List<Integer> current, List<List<Integer>> result) {
    if (current.size() > k || target < 0) {
      return;
    }

    if (target == 0 && current.size() == k) {
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = currNum; i < 10; i++) {
      current.add(i);
      findCombos(k, target - i, i + 1, current, result);
      current.remove(current.size() - 1);
    }
  }
}