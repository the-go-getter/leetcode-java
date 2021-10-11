class Solution124 {
  int result = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    findMaxSum(root);
    return result;
  }

  public int findMaxSum(TreeNode root){
    if(root==null){
      return 0;
    }

    int leftSum = Math.max(findMaxSum(root.left), 0);
    int rightSum = Math.max(findMaxSum(root.right), 0);

    result = Math.max(result, root.val + leftSum + rightSum);

    return root.val + Math.max(leftSum, rightSum);
  }
}
