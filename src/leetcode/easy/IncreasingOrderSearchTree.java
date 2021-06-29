package leetcode.easy;

public class IncreasingOrderSearchTree {

  public class TreeNode {
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

      private TreeNode tree;
      private TreeNode treePointer;

      public TreeNode increasingBST(TreeNode root) {
         if(root == null) {
            return null;
         }

         increasingBST(root.left);

         if(treePointer != null) {
            treePointer.right = root;
            root.left = null;
         }

         if(tree == null) {
            tree = root;
         }

         treePointer = root;
         increasingBST(root.right);

         return tree;
      }
   }

}
