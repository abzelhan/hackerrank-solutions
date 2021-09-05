package leetcode.medium.graph;

import java.util.LinkedList;
import java.util.List;

public class MakeNetworkConnected {

   private void dfs(int source, List<Integer>[] graph, boolean[] visited) {
      visited[source] = true;

      for (Integer neighbour : graph[source]) {
         if (!visited[neighbour]) {
            dfs(neighbour, graph, visited);
         }
      }

   }

   public int makeConnected(int n, int[][] connections) {
      if (connections.length < n - 1) {
         return -1;
      }

      List<Integer>[] graph = new List[n];
      boolean[] visited = new boolean[n];

      for (int i = 0; i < n; i++) {
         graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < connections.length; i++) {
         graph[connections[i][0]].add(connections[i][1]);
         graph[connections[i][1]].add(connections[i][0]);
      }

      int counter = 0;

      for (int i = 0; i < n; i++) {
         if (!visited[i]) {
            dfs(i, graph, visited);
            counter++;
         }
      }

      return counter - 1;
   }

   public static void main(String[] args) {

   }

}
