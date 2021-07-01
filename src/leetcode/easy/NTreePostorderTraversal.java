package leetcode.easy;

import java.util.*;

public class NTreePostorderTraversal {

   class Node {
      public int val;
      public List<Node> children;

      public Node() {}

      public Node(int _val) {
         val = _val;
      }

      public Node(int _val, List<Node> _children) {
         val = _val;
         children = _children;
      }
   }

   public void postorderTraversal(Node node, List<Integer> nums) {
      if (node == null) {
         return;
      }

      if (node.children != null) {
         for (Node child : node.children) {
            postorderTraversal(child, nums);
         }
      }

      nums.add(node.val);
   }

   public List<Integer> postorder(Node root) {
      List<Integer> nums = new ArrayList<Integer>();
      postorderTraversal(root, nums);
      return nums;
   }

}
