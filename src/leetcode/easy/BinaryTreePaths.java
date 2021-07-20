package leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {



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

   private Stack<TreeNode> stack = new Stack<>();
   private List<String> result = new LinkedList<>();

   public void binaryTreePaths2(TreeNode node) {
      if(node == null) {
         return;
      }


      stack.push(node);

      if(node.left == null && node.right == null) {

         StringBuilder  str = new StringBuilder();

         int counter = 1;
         for (TreeNode treeNode : stack) {
            str.append(String.valueOf(treeNode.val));

            if(counter != stack.size()){
               str.append("->");
            }
            counter++;

         }


         result.add(str.toString());
         return;
      }

      if(node.left != null) {

         binaryTreePaths2(node.left);
         stack.pop();
      }


      if(node.right != null) {

         binaryTreePaths2(node.right);
         stack.pop();
      }


   }

   public List<String> binaryTreePaths(TreeNode node) {
      binaryTreePaths2(node);
      return result;

   }

   public static void main(String[] args) {
      new BinaryTreePaths().binaryTreePaths(
          new TreeNode(3, new TreeNode(9),
              new TreeNode(20,
                  new TreeNode(15),
                  new TreeNode(7))));
   }

}
