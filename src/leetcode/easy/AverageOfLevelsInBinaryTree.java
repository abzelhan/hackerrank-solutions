package leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

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

   public List<Double> averageOfLevels(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      List<Double> result = new LinkedList<>();

      if (root != null) {

         queue.add(root);

         while (!queue.isEmpty()) {

            double sum = 0;
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
               TreeNode node = queue.poll();
               sum += node.val;

               if (node.left != null) {
                  queue.add(node.left);
               }
               if (node.right != null) {
                  queue.add(node.right);
               }
            }

            result.add(sum / qSize);
         }
      }

      return result;
   }



   public static void main(String[] args) {
      AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
      List<Double> average = averageOfLevelsInBinaryTree.averageOfLevels(
          new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));

      for (Double aDouble : average) {
         System.out.println(aDouble);
      }



   }

}
