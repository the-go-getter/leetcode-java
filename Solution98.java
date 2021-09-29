class Solution98 {
  public boolean isValidBST(TreeNode root) {
    return checkBST(root, null, null);
  }

  public boolean checkBST(TreeNode root, TreeNode min, TreeNode max){
    if(root==null){
      return true;
    } else if((min == null || root.val > min.val) && (max == null || root.val < max.val)){
      return checkBST(root.left, min, root) && checkBST(root.right, root, max);
    } else{
      return false;
    }
  }
}
