class Solution572 {
  boolean result = false;
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(root==null){
      return false;
    }

    if(root.val == subRoot.val){
      result = result || compareTrees(root, subRoot);
    }

    isSubtree(root.left, subRoot);
    isSubtree(root.right, subRoot);

    return result;
  }

  public boolean compareTrees(TreeNode root, TreeNode subRoot){
    if(root == null || subRoot == null){
      return root==subRoot;
    } else{
      return root.val==subRoot.val && compareTrees(root.left, subRoot.left)
              && compareTrees(root.right, subRoot.right);
    }
  }
}
