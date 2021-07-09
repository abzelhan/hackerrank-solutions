package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {

   public static class TreeNode {

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

   public static List<List<Integer>> levelOrderFast(TreeNode root) {
      List<List<Integer>> list=new LinkedList<>();
      Queue<TreeNode> q=new LinkedList<>();

      if(root==null)
         return list;
      else
      {
         q.add(root);

         while(!q.isEmpty())
         {
            List<Integer> temp=new LinkedList<>();
            int tsize=q.size();
            for(int i=0;i<tsize;i++)
            {
               TreeNode x=q.remove();
               temp.add(x.val);
               if(x.left!=null)
                  q.add(x.left);
               if(x.right!=null)
                  q.add(x.right);
            }
            list.add(temp);
         }
         return list;
      }
   }

   public static List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new LinkedList<>();
      if (root == null) {
         return result;
      }
      HashMap<Integer, List<TreeNode>> treeMap = new HashMap<>();
      treeMap.put(1, Arrays.asList(root));
      int level = 1;

      do {
         List<TreeNode> treeNodes = treeMap.get(level);
         level++;
         for (TreeNode treeNode : treeNodes) {
            List<TreeNode> children = treeMap.getOrDefault(level, new LinkedList<>());
            if (treeNode.left != null) {
               children.add(treeNode.left);
               treeMap.put(level, children);
            }
            if (treeNode.right != null) {
               children.add(treeNode.right);
               treeMap.put(level, children);
            }
         }
         result.add(treeNodes.stream().map(node -> node.val).collect(Collectors.toList()));
      } while (treeMap.containsKey(level));

      return result;
   }

   public static void main(String[] args) {
      TreeNode treeNode = new TreeNode(3, new TreeNode(9),
          new TreeNode(20, new TreeNode(15), new TreeNode(7)));

      TreeNode treeNodeBamboo = new TreeNode(1,
          new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null),
          null);

      List<List<Integer>> list = levelOrderFast(treeNode);

      for (List<Integer> children : list) {
         for (Integer child : children) {
            System.out.print(child + " ");
         }

         System.out.println();
      }

   }

}
