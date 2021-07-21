package leetcode.easy;

public class SumOfLeftLeaves {



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
   

   public int sumOfLeftLeaves(TreeNode node, TreeNode parent) {
      if(node == null) {
         return 0;
      }

      int sum = 0;

      if(parent != null && node == parent.left && node.left == null && node.right == null) {
         sum+=node.val;
      }

      if(node.left != null) {
         sum+=sumOfLeftLeaves(node.left, node);
      }

      if(node.right != null) {
         sum+=sumOfLeftLeaves(node.right, node);
      }

      return sum;
   }

   public int sumOfLeftLeaves(TreeNode root) {
      return sumOfLeftLeaves(root, null);
   }

}
