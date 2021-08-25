import java.util.ArrayList;
import java.util.List;

public class Solution113 {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    findPaths(root, targetSum, new ArrayList<Integer>(), result);
    return result;
  }

  public void findPaths(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result) {
    if (root == null) {
      return;
    } else if ((root.val == targetSum) && (root.left == null) && (root.right == null)) {
      current.add(root.val);
      result.add(current);
      return;
    } else {
      current.add(root.val);
      findPaths(root.left, targetSum - root.val, new ArrayList<>(current), result);
      findPaths(root.right, targetSum - root.val, new ArrayList<>(current), result);
    }
  }
}
