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

         if(tree == null) {
            tree = new TreeNode(root.val);
            treePointer = tree;
         } else {
            treePointer.right =  new TreeNode(root.val);
            treePointer = treePointer.right;
         }

         increasingBST(root.right);

         return tree;
      }
   }

}
