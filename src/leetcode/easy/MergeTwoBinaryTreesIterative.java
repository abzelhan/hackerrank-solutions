package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTreesIterative {

   public static class TreeNode {

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

   private class Pair {

      TreeNode node1;
      TreeNode node2;

      public Pair(TreeNode node1, TreeNode node2) {
         this.node1 = node1;
         this.node2 = node2;
      }
   }

   public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 == null) {
         return root2;
      }

      Queue<TreeNode> queue = new LinkedList<>();

      queue.add(root1);
      queue.add(root2);

      while (!queue.isEmpty()) {
         TreeNode node1 = queue.poll();
         TreeNode node2 = queue.poll();

         if (node1 != null && node2 != null) {
            node1.val += node2.val;

            if (node1.left != null && node2.left != null) {
               queue.add(node1.left);
               queue.add(node2.left);
            }
            if (node1.right != null && node2.right != null) {
               queue.add(node1.right);
               queue.add(node2.right);
            }

            if (node1.left == null && node2.left != null) {
               node1.left = node2.left;
            }

            if (node1.right == null && node2.right != null) {
               node1.right = node2.right;
            }

         }

      }

      return root1;
   }

   public static void main(String[] args) {
      TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
      TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
          new TreeNode(3, null, new TreeNode(7)));

      TreeNode node = mergeTrees(root1, root2);
      System.out.println();
   }

}
