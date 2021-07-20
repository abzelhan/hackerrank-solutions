package leetcode.easy;

import java.util.Stack;

public class SumOfRootToLeafBinaryNumbers {


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

   public void sumRootToLeaf(TreeNode root, Stack<Integer> nums, StringBuilder str) {
      if (root == null) {
         return;
      }

      nums.add(root.val);

      if (root.left == null && root.right == null) {
         for (Integer num : nums) {
            str.append(num);
         }
         str.append("\n");
         nums.pop();
         return;
      }

      sumRootToLeaf(root.left, nums, str);

      sumRootToLeaf(root.right, nums, str);

      nums.remove(nums.size() - 1);

   }

   public int sumRootToLeaf(TreeNode root) {
      StringBuilder str = new StringBuilder();
      sumRootToLeaf(root, new Stack<Integer>(), str);

      String[] nums = str.toString().split("\n");
      int sum = 0;
      for (String num : nums) {
         sum += Integer.parseInt(num, 2);
      }

      return 0;
   }

}
