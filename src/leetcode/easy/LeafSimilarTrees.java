package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTrees {



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

   public void collectLeafValues(TreeNode node, List<Integer> values) {
      if(node == null) {
         return;
      }

      if(node.left == null && node.right == null) {
         values.add(node.val);
      }

      if(node.left != null) {
         collectLeafValues(node.left, values);
      }

      if(node.right != null) {
         collectLeafValues(node.right, values);
      }

   }

   public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> firstRootLeaves = new LinkedList<Integer>();
      collectLeafValues(root1, firstRootLeaves);
      List<Integer> secondRootLeaves = new LinkedList<Integer>();
      collectLeafValues(root2, secondRootLeaves);
      return firstRootLeaves.equals(secondRootLeaves);
   }

}
