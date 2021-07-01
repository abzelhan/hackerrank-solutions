package leetcode.easy;

import java.util.*;

public class BinaryTreeTraversal {

   private class TreeNode {
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


   public void postorderTraversal(TreeNode node, List<Integer> nums) {
      if(node == null) return;

      postorderTraversal(node.left, nums);
      postorderTraversal(node.right, nums);
      nums.add(node.val);

   }

   public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> nums = new ArrayList<Integer>();
      postorderTraversal(root, nums);
      return nums;
   }

   public void preorderTraversal(TreeNode node, List<Integer> nums) {
      if(node == null) return;
      nums.add(node.val);
      preorderTraversal(node.left, nums);
      preorderTraversal(node.right, nums);


   }

   public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> nums = new ArrayList<Integer>();
      preorderTraversal(root, nums);
      return nums;
   }

   public void inorderTraversal(TreeNode node, List<Integer> nums) {
      if(node == null) return;
      preorderTraversal(node.left, nums);
      nums.add(node.val);
      preorderTraversal(node.right, nums);
   }

   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> nums = new ArrayList<Integer>();
      inorderTraversal(root, nums);
      return nums;
   }


   public static void main(String[] args) {

   }

}
