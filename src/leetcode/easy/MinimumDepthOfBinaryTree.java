package leetcode.easy;

import java.util.TreeSet;

public class MinimumDepthOfBinaryTree {

   private static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   private int minDepth = Integer.MAX_VALUE;

   public void minDepth(TreeNode root, int depth) {
      if (root == null) {
         return;
      }

      if (root.left == null && root.right == null) {
         minDepth = Math.min(minDepth, depth);
      }

      if (root.left != null) {
         minDepth(root.left, depth + 1);
      }

      if (root.right != null) {
         minDepth(root.right, depth + 1);
      }
   }

   public int minDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }

      minDepth(root, 1);
      return minDepth;
   }

   public static void main(String[] args) {

   }

}
