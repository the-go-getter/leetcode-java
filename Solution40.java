import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    findCombos(candidates, target, result, 0, new ArrayList<>());
    return result;
  }

  public void findCombos(int[] candidates, int target, List<List<Integer>> result, int currIndex, ArrayList<Integer> current){
    if(target<0){
      return;
    } else if(target == 0){
      result.add(new ArrayList<>(current));
      return;
    }

    for(int i=currIndex; i<candidates.length; i++){
      if(i==currIndex || candidates[i]!=candidates[i-1]){
        current.add(candidates[i]);
        findCombos(candidates, target-candidates[i], result, i+1, current);
        current.remove(current.size()-1);
      }
    }
  }
}