package leetcode.easy;

import java.util.*;

public class InvertBinaryTree {



  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

   class Solution {
      public TreeNode invertTree(TreeNode root) {
         if(root == null) return null;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);

         while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;
            node.left = rightChild;
            node.right = leftChild;

            if(node.left != null) {
               queue.add(node.left);
            }
            if(node.right != null) {
               queue.add(node.right);
            }


         }
         return root;
      }
   }

}
