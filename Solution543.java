class Solution543 {
  int result = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    findMaxDepth(root);
    return result;
  }

  public int findMaxDepth(TreeNode root){
    if(root==null){
      return 0;
    }

    int left = findMaxDepth(root.left);
    int right = findMaxDepth(root.right);

    result = Math.max(result, left + right);

    return 1+Math.max(left,right);
  }
}