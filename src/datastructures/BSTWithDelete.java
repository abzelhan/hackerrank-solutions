package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BSTWithDelete<Key extends Comparable, Value> {

   private class Node {

      Key key;
      Value value;
      Node left;
      Node right;
      Node parent;

      public Node(Key key, Value value) {
         this.key = key;
         this.value = value;
      }
   }

   private Node root;

   public void put(Key key, Value value) {
      root = put(root, key, value);
   }

   public Node put(Node node, Key key, Value value) {
      if (node == null) {
         return new Node(key, value);
      }

      int cmpResult = node.key.compareTo(key);

      if (cmpResult < 0) {
         node.right = put(node.right, key, value);
         node.right.parent = node;
      } else if (cmpResult > 0) {
         node.left = put(node.left, key, value);
         node.left.parent = node;
      } else {
         node.value = value;
      }

      return node;
   }

   public void printInorder() {
      printInorder(root);
   }

   private void printInorder(Node node) {
      if (node == null) {
         return;
      }

      printInorder(node.left);
      printInorder(node.right);
      System.out.println(node.value);
   }

   public void printLevelOrder() {
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         Node node = queue.poll();
         System.out.println(node.value);
         if (node.left != null) {
            queue.add(node.left);
         }
         if (node.right != null) {
            queue.add(node.right);
         }
      }
   }

   public Node findByKey(Key key) {
      return findByKey(root, key);
   }

   private Node findByKey(Node node, Key key) {
      if (node == null) {
         return null;
      }

      int cmpResult = node.key.compareTo(key);

      if (cmpResult == 0) {
         return node;
      } else if (cmpResult < 0) {
         return findByKey(node.right, key);
      } else {
         return findByKey(node.left, key);
      }
   }

   private Node findMin(Node node) {
      if (node.left == null) {
         return node;
      }

      return findMin(node.left);
   }

   private void transplant(Node u, Node v) {
      if (u.parent == null) {
         root = v;
      } else if (u.parent.left == u) {
         u.parent.left = v;
         v.parent = u.parent;
         u.parent = null;
      } else {
         u.parent.right = v;
         v.parent = u.parent;
         u.parent = null;
      }
   }

   public void delete(Key key) {
      Node node = findByKey(key);

      if (node == null) {
         return;
      }

      if (node.left == null && node.right == null) {
         //root
         if (node.parent == null) {
            root = null;
         }

         if (node.parent.left == node) {
            node.parent.left = null;
            node.parent = null;
         }

         if (node.parent.right == node) {
            node.parent.right = null;
            node.parent = null;
         }

      } else if (node.left == null) {
         transplant(node, node.right);
         node.right = null;
      } else if (node.right == null) {
         transplant(node, node.left);
         node.left = null;
      } else {
         Node min = findMin(node.right);

         //if min's parent is node
         if (min.parent == node) {
            transplant(node, min);
            min.left = node.left;
            min.left.parent = min;
            node.left = null;
         } else {
            Node nodeSuccessor = min;

            transplant(nodeSuccessor, nodeSuccessor.right);
            nodeSuccessor.right = null;
            transplant(node, nodeSuccessor);
            nodeSuccessor.left = node.left;
            nodeSuccessor.left.parent = nodeSuccessor;
            nodeSuccessor.right = node.right;
            nodeSuccessor.right.parent = nodeSuccessor;
            node.left = null;
            node.right = null;
            System.out.println();
         }
      }
   }

   public static void main(String[] args) {
      BSTWithDelete<Integer, Integer> bstWithDelete = new BSTWithDelete<>();
      bstWithDelete.put(4, 4);
      bstWithDelete.put(6, 6);
      bstWithDelete.put(5, 5);
      bstWithDelete.put(11, 11);
      bstWithDelete.put(10, 10);
      bstWithDelete.put(7, 7);
      bstWithDelete.put(8, 8);
      bstWithDelete.put(9, 9);

      bstWithDelete.delete(6);
      bstWithDelete.printLevelOrder();
   }

}
