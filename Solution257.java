import java.util.ArrayList;
import java.util.List;

public class Solution257 {
  public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> paths = new ArrayList<>();
    if(root == null){
      return paths;
    }
    findPaths(root, "", paths);
    return paths;
  }

  public void findPaths(TreeNode root, String currentPath, ArrayList<String> paths){
    currentPath += root.val;
    if(root.left==null && root.right==null){
      paths.add(currentPath);
    } else{
      if(root.left != null){
        findPaths(root.left, currentPath + "->", paths);
      }
      if(root.right != null){
        findPaths(root.right, currentPath + "->", paths);
      }
    }
  }
}
