package leetcode.easy;


public class SearchInBinarySearchTree {

   public static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      public TreeNode(int val) {
         this.val = val;
      }

      public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   public static TreeNode searchBST(TreeNode root, int val) {
      if (root == null) {
         return null;
      }

      if (root.val < val) {
         return searchBST(root.right, val);
      } else if (root.val > val) {
         return searchBST(root.left, val);
      } else {

         return root;
      }

   }


   public static void main(String[] args) {
      TreeNode tree = new TreeNode(4,
          new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
          new TreeNode(7, null, null));

      TreeNode treeNode = searchBST(tree, 2);



   }

}
