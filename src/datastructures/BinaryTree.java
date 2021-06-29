package datastructures;

public class BinaryTree<Key extends Comparable, Value> {

   private class Node implements Comparable<Node> {

      private Key key;
      private Value value;
      private Node left;
      private Node right;

      private Node(Key key, Value value) {
         this.key = key;
         this.value = value;
      }

      public Key getKey() {
         return key;
      }

      public void setKey(Key key) {
         this.key = key;
      }

      public Value getValue() {
         return value;
      }

      public void setValue(Value value) {
         this.value = value;
      }

      public Node getLeft() {
         return left;
      }

      public void setLeft(Node left) {
         this.left = left;
      }

      public Node getRight() {
         return right;
      }

      public void setRight(Node right) {
         this.right = right;
      }

      @Override
      public int compareTo(Node that) {
         return this.key.compareTo(that.key);
      }
   }

   private Node root;

   public void put(Key key, Value value) {
      root = put(root, key, value);
   }

   private Node put(Node node, Key key, Value value) {
      if (node == null) {
         return new Node(key, value);
      }

      int compareResult = node.key.compareTo(key);

      //right
      if (compareResult < 0) {
         node.setRight(put(node.getRight(), key, value));
      }
      //left
      else if (compareResult > 0) {
         node.setLeft(put(node.getLeft(), key, value));
      } else {
         node.setValue(value);
         return node;
      }

      return node;
   }

   public void traverseAll() {
      traverse(root);
   }

   private void traverse(Node node) {
      if (node == null) {
         return;
      }

      traverse(node.getLeft());
      System.out.println(node.getKey() + " " + node.getValue());
      traverse(node.getRight());
   }

   public static void main(String[] args) {
      BinaryTree<Integer, String> bst = new BinaryTree<>();
      bst.put(5, "A");
      bst.put(1, "B");
      bst.put(6, "C");
      bst.put(7, "D");

      bst.traverseAll();

   }

}
