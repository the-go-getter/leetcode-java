import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentLevel;
    Queue<TreeNode> q = new LinkedList<>();

    if(root==null){
      return result;
    }

    q.add(root);
    boolean reverse = false;

    while(!q.isEmpty()){
      int levelSize = q.size();
      currentLevel = new ArrayList<>();
      while(levelSize>0){
        TreeNode current = q.poll();
        if(current.left!=null){
          q.add(current.left);
        }
        if(current.right!=null){
          q.add(current.right);
        }
        currentLevel.add(current.val);
        levelSize--;
      }
      if(reverse){
        Collections.reverse(currentLevel);
      }
      result.add(new ArrayList<>(currentLevel));
      reverse = !reverse;
    }

    return result;
  }
}