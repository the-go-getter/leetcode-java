import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Solution297 {
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  public class Codec {

    public String serializeHelper(TreeNode root, String result) {
      if (root == null) {
        result += "null,";
        return result;
      }

      result += root.val + ",";
      result = serializeHelper(root.left, result);
      result = serializeHelper(root.right, result);

      return result;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      return serializeHelper(root, "");
    }

    public TreeNode deserializeHelper(List<String> dataList) {
      if (dataList.get(0).equals("null")) {
        dataList.remove(0);
        return null;
      }

      TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
      dataList.remove(0);
      root.left = deserializeHelper(dataList);
      root.right = deserializeHelper(dataList);

      return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] dataArray = data.split(",");
      List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
      return deserializeHelper(dataList);
    }
  }

/*
 Your Codec object will be instantiated and called as such:
 Codec ser = new Codec();
 Codec deser = new Codec();
 TreeNode ans = deser.deserialize(ser.serialize(root));
*/
}
