package leetcode.medium;

public class SumOfNodesWithEvenValuedGrandparent {

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

   public int sumEvenGrandparent(TreeNode node, TreeNode parent) {
      if (node == null) {
         return 0;
      }

      int sum = 0;
      boolean isParentEvent = parent != null && parent.val % 2 == 0;

      if (node.left != null) {

         if (isParentEvent) {
            sum += node.left.val;
         }

         sum += sumEvenGrandparent(node.left, node);
      }

      if (node.right != null) {

         if (isParentEvent) {
            sum += node.right.val;
         }

         sum += sumEvenGrandparent(node.right, node);
      }

      return sum;
   }

   public int sumEvenGrandparent(TreeNode node) {
      return sumEvenGrandparent(node, null);
   }

   public static void main(String[] args) {

      TreeNode root = new TreeNode(6, null,
          new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
      System.out.println(new SumOfNodesWithEvenValuedGrandparent().sumEvenGrandparent(
          root));

   }

}
