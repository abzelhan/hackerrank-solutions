package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BalanceBinarySearchTree {

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

   private static void collectNodes(TreeNode node, List<TreeNode> list) {
      if (node == null) {
         return;
      }

      collectNodes(node.left, list);
      list.add(node);
      collectNodes(node.right, list);
   }

   private static TreeNode binaryPut(List<TreeNode> list, int l, int r) {
      if (l > r) {
         return null;
      }

      int mid = (l + r) / 2;
      TreeNode treeNode = list.get(mid);

      treeNode.left = binaryPut(list,l, mid - 1);
      treeNode.right = binaryPut(list, mid + 1, r);

      return treeNode;
   }

   public static TreeNode balanceBST(TreeNode root) {
      List<TreeNode> nodeList = new ArrayList<>();
      collectNodes(root, nodeList);
      root = binaryPut(nodeList, 0, nodeList.size() - 1);


      return root;
   }

   public static void main(String[] args) {
      balanceBST(new TreeNode(1, null,
          new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))))));
   }

}
