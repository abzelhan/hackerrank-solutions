package leetcode.medium.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximalNetworkRank {

   private static class Graph implements Comparable<Graph>{
      int vertex;
      Set<Integer> vertices;

      public Graph(int vertex, Set<Integer> vertices) {
         this.vertex = vertex;
         this.vertices = vertices;
      }

      @Override
      public int compareTo(Graph o) {
         int thisSize = o.vertices.size();
         int thatSize = this.vertices.size();

         return Integer.compare(thisSize, thatSize);
      }
   }

   public int maximalNetworkRank(int n, int[][] roads) {
      Graph[] graphs = new Graph[n];

      for (int i = 0; i < n; i++) {
         graphs[i] = new Graph(i, new HashSet<>());
      }

      for (int i = 0; i < roads.length; i++) {
         graphs[roads[i][0]].vertices.add(roads[i][1]);
         graphs[roads[i][1]].vertices.add(roads[i][0]);
      }

      Arrays.sort(graphs);

      int maxTotal = 0;

      for (int i = 0; i < graphs.length; i++) {
         Graph first = graphs[i];

         for (int j = i + 1; j < graphs.length; j++) {
            Graph second = graphs[j];

            int total = first.vertices.size() + second.vertices.size();
            if (first.vertices.contains(second.vertex) || second.vertices.contains(first.vertex)) {
               total--;
            }
            if (total < maxTotal) {
               break;
            }

            maxTotal = Math.max(maxTotal, total);
         }
      }

      return maxTotal;
   }

   public static void main(String[] args) {
      System.out.println(new MaximalNetworkRank().maximalNetworkRank(8, new int[][]{
          {0, 1}
          , {1, 2}
          , {2, 3}
          , {2, 4}
          , {5, 6}
          , {5, 7}
      }));
   }

}
