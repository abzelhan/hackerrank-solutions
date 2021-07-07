package leetcode.easy;

public class ConvertSortedArrayToBinarySearchTree {

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


   public static TreeNode binaryPut(int[] nums, int l, int r) {
      if (l > r) {
         return null;
      }

      int mid = (l + r) / 2;
      TreeNode node = new TreeNode(nums[mid]);
      node.left = binaryPut(nums, l, mid - 1);
      node.right = binaryPut(nums, mid + 1, r);

      return node;
   }

   public static TreeNode sortedArrayToBST(int[] nums) {
      return binaryPut(nums, 0, nums.length - 1);
   }

   public static void main(String[] args) {
      TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
      System.out.println();
   }

}
