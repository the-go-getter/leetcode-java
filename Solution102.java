import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current;
    if(root==null){
      return result;
    }

    q.add(root);
    while(!q.isEmpty()){
      int levelSize = q.size();
      current = new ArrayList<>();
      while(levelSize>0){
        TreeNode node = q.poll();
        if(node.left!=null){
          q.add(node.left);
        }
        if(node.right!=null){
          q.add(node.right);
        }
        current.add(node.val);
        levelSize--;
      }
      result.add(new ArrayList<>(current));
    }
    return result;
  }
}
