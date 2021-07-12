package leetcode.easy;

public class RangeSumOfBST {

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

   public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null) {
         return 0;
      }

      int sum = 0;
      sum += rangeSumBST(root.left, low, high);

      sum += rangeSumBST(root.right, low, high);

      if (root.val >= low && root.val <= high) {
         sum += root.val;
      }

      return sum;
   }

   public static void main(String[] args) {
      TreeNode treeNode = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)),
          new TreeNode(15, null, new TreeNode(18)));
      System.out.println(new RangeSumOfBST().rangeSumBST(treeNode, 7 , 15));
   }


}
