package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

   private static class Node {

      public int val;
      public List<Node> neighbors;

      public Node() {
         val = 0;
         neighbors = new ArrayList<Node>();
      }

      public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<Node>();
      }

      public Node(int _val, ArrayList<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
      }


   }

   public static Node dfs(Node node, Map<Integer, Node> nodeDictionary) {
      Node newNode = new Node();
      newNode.val = node.val;

      nodeDictionary.put(newNode.val, newNode);

      for (Node neighbor : node.neighbors) {
         if (nodeDictionary.containsKey(neighbor.val)) {
            newNode.neighbors.add(nodeDictionary.get(neighbor.val));
         } else {
            newNode.neighbors.add(dfs(neighbor, nodeDictionary));
         }
      }

      return newNode;
   }

   public static Node cloneGraph(Node node) {
      if (node == null) {
         return node;
      }
      Map<Integer, Node> nodeDictionary = new HashMap<>();
      return dfs(node, nodeDictionary);
   }

   public static void main(String[] args) {
      Node first = new Node(1);
      Node second = new Node(2);
      Node third = new Node(3);
      Node fourth = new Node(4);

      first.neighbors.add(second);
      first.neighbors.add(fourth);

      second.neighbors.add(first);
      second.neighbors.add(third);

      third.neighbors.add(second);
      third.neighbors.add(fourth);

      fourth.neighbors.add(first);
      fourth.neighbors.add(third);

      Node node = cloneGraph(first);

      System.out.println();


   }

}
