import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//TreeNode class is in 112.jave
 
class Solution199 {
  public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> rsv = new ArrayList<>();
    if(root==null){
      return rsv;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      int levelSize = q.size();
      while(levelSize > 0){
        TreeNode current = q.poll();

        if(current.left != null){
          q.add(current.left);
        }

        if(current.right != null){
          q.add(current.right);
        }

        if(levelSize-- == 1){
          rsv.add(current.val);
        }
      }
    }
    return rsv;
  }
}
