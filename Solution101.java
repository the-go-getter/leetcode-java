public class Solution101 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    } else if (root.left == null || root.right == null) {
      return root.left == root.right;
    } else {
      return checkSymmetry(root.left, root.right);
    }
  }

  public boolean checkSymmetry(TreeNode left, TreeNode right) {
    if (left == null || right == null) {
      return left == right;
    } else if (left.val != right.val) {
      return false;
    } else {
      return checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
    }
  }
}
