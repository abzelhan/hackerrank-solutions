package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorderTraversal {

   class Node {

      public int val;
      public List<Node> children;

      public Node() {
      }

      public Node(int _val) {
         val = _val;
      }

      public Node(int _val, List<Node> _children) {
         val = _val;
         children = _children;
      }
   }

   ;


   public void preorderTraversal(Node node, List<Integer> nums) {
      if (node == null) {
         return;
      }

      nums.add(node.val);

      if (node.children != null) {
         for (Node child : node.children) {
            preorderTraversal(child, nums);
         }
      }

   }

   public List<Integer> preorder(Node root) {
      List<Integer> nums = new ArrayList<Integer>();
      preorderTraversal(root, nums);
      return nums;
   }

}
