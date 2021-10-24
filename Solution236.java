class Solution236 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return searchAncestor(root, p, q);
  }

  public TreeNode searchAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    TreeNode left = searchAncestor(root.left, p, q);
    TreeNode right = searchAncestor(root.right, p, q);

    if (root == p || root == q || (left != null && right != null)) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    } else {
      return null;
    }
  }
}
