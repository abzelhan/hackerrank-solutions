package leetcode.easy;


public class UnivaluedBinaryTree {

   private static class TreeNode {
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
   
   public boolean isUnivalTree(TreeNode node, TreeNode parent) {
      if(node == null) {
         return true;
      }

      boolean isSameValueWithParent = parent == null ? true : parent.val == node.val;

      if(node.left != null){
         isSameValueWithParent&=isUnivalTree(node.left, node);
      }

      if(node.right != null){
         isSameValueWithParent&=isUnivalTree(node.right, node);
      }

      return isSameValueWithParent;
   }

   public boolean isUnivalTree(TreeNode root) {
      return isUnivalTree(root, null);
   }
   
}
