package leetcode.easy;

import java.util.Stack;

public class ConstructStringFromBinaryTree {


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

   public static void preorderToString(TreeNode root, Stack<String> queue) {
      if (root == null) {
         return;
      }

      queue.push(String.valueOf(root.val));

      boolean hasRightChild = root.left == null && root.right != null;

      queue.push("(");
      preorderToString(root.left, queue);
      if (!hasRightChild && root.left == null) {
         queue.pop();
      } else {
         queue.push(")");
      }
      queue.push("(");
      preorderToString(root.right, queue);
      if (root.right == null) {
         queue.pop();
      } else {
         queue.push(")");
      }

      return;
   }

   public static String tree2str(TreeNode root) {
      Stack<String> deque = new Stack<>();
      preorderToString(root, deque);
      StringBuilder builder = new StringBuilder();

      for (String character : deque) {
         builder.append(character);
      }

      return builder.toString();
   }


   public static void main(String[] args) {
      TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, null, null)),
          new TreeNode(3, null, null));

      System.out.println(tree2str(treeNode));
   }

}
