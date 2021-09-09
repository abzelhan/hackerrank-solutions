package leetcode.medium.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RedundantConnection {

   public void dfs(int from, List<Integer>[] graph, Set<Integer> visited) {
      visited.add(from);

      for (Integer to : graph[from]) {
         if (!visited.contains(to)) {
            dfs(to, graph, visited);
         }
      }
   }

   public int[] findRedundantConnection(int[][] edges) {
      List<Integer>[] graph = new List[1001];
      Set<Integer> visited = new HashSet<>();
      LinkedList<int[]> result = new LinkedList<>();

      for (int i = 0; i < 1001; i++) {
         graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < edges.length; i++) {
         visited.clear();
         int from = edges[i][0];
         int to = edges[i][1];
         //dfs
         dfs(from, graph, visited);

         if (visited.contains(to)) {
            result.add(edges[i]);
         } else {
            graph[from].add(to);
            graph[to].add(from);
         }
      }

      return result.getLast();
   }

   public static void main(String[] args) {

   }

}
