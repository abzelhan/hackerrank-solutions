package leetcode.medium.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumNumberOfVerticesReachAllNodes {

   public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
      boolean[] vertices = new boolean[n];

      for (int i = 0; i < edges.size(); i++) {
         vertices[edges.get(i).get(1)] = true;
      }

      List<Integer> result = new LinkedList<>();

      for (int i = 0; i < n; i++) {
         if (!vertices[i]) {
            result.add(i);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(new MinimumNumberOfVerticesReachAllNodes().findSmallestSetOfVertices(6,
          Arrays.asList(
              Arrays.asList(0, 1),
              Arrays.asList(0, 2),
              Arrays.asList(2, 5),
              Arrays.asList(3, 4),
              Arrays.asList(5, 2)
              )));
   }

}
