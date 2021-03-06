
//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    } else if (root.val == targetSum && root.left == null && root.right == null) {
      return true;
    } else {
      return hasPathSum(root.left, targetSum - root.val) ||
              hasPathSum(root.right, targetSum - root.val);
    }
  }

  public static void main(String[] args) {
    System.out.println();
  }
}