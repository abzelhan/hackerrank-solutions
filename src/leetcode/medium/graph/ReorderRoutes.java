package leetcode.medium.graph;

import java.util.LinkedList;
import java.util.List;

public class ReorderRoutes {

   private static class Pair {

      Integer to;
      boolean isReal;

      public Pair(Integer to, boolean isReal) {
         this.to = to;
         this.isReal = isReal;
      }
   }

   int counter;

   public void dfs(int v, List<Pair>[] graph,
       boolean[] visited) {
      visited[v] = true;

      for (Pair pair : graph[v]) {
         if (!visited[pair.to]) {
            if (!pair.isReal) {
               counter++;
            }

            dfs(pair.to, graph, visited);
         }
      }
   }

   public int minReorder(int n, int[][] connections) {
      List<Pair>[] graph = new List[n];
      boolean[] visited = new boolean[n];

      for (int i = 0; i < n; i++) {
         graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < connections.length; i++) {
         graph[connections[i][0]].add(new Pair(connections[i][1], false));

         graph[connections[i][1]].add(new Pair(connections[i][0], true));
      }

      dfs(0, graph, visited);

      return counter;
   }

   public static void main(String[] args) {
      System.out.println(new ReorderRoutes().minReorder(3, new int[][]{{1, 0}, {2, 0}}));
   }

}
