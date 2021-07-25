package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {

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

   private static class Pair {

      TreeNode node;
      int index;

      public Pair(TreeNode node, int index) {
         this.node = node;
         this.index = index;
      }
   }


   public int widthOfBinaryTree(TreeNode root) {
      if (root == null) {
         return 0;
      }

      Deque<Pair> queue = new LinkedList<>();
      int maxWidth = Integer.MIN_VALUE;
      queue.add(new Pair(root, 0));

      while (!queue.isEmpty()) {

         int size = queue.size();

         maxWidth = Math.max(maxWidth, queue.getLast().index - queue.getFirst().index + 1);

         for (int i = 0; i < size; i++) {
            Pair pair = queue.poll();

            if (pair.node.left != null) {
               queue.add(new Pair(pair.node.left, pair.index * 2 + 1));
            }
            if (pair.node.right != null) {
               queue.add(new Pair(pair.node.right, pair.index * 2 + 2));
            }
         }

      }

      return maxWidth;
   }

   public static void main(String[] args) {

   }

}
