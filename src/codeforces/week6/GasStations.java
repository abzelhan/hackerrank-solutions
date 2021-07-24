package codeforces.week6;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GasStations {

   private static class Edge {

      int to, weight;

      public Edge(int to, int weight) {
         this.to = to;
         this.weight = weight;
      }

   }

   private static void dfs(List<Edge>[] graph, int v, boolean[] marked) {
      marked[v] = true;

      for (int i = 0; i < graph[v].size(); i++) {
         Edge edge = graph[v].get(i);
         if (!marked[edge.to]) {
            dfs(graph, edge.to, marked);
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      boolean[] visited = new boolean[v];
      List<Edge>[] graph = new LinkedList[v];
      int[] distance = new int[v];
      int[] cost = new int[v];
      int[] pathTo = new int[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
         cost[i] = scanner.nextInt();
         distance[i] = Integer.MAX_VALUE;
      }

      int m = scanner.nextInt();

      for (int i = 0; i < m; i++) {
         int from = scanner.nextInt() - 1;
         int to = scanner.nextInt() - 1;

         graph[from].add(new Edge(to, 1));
         graph[to].add(new Edge(from, 1));
      }

      //dfs
      boolean[] visitedBefore = new boolean[v];

      dfs(graph, 0, visitedBefore);

      if (!visitedBefore[v - 1]) {
         System.out.println(-1);
         return;
      }

      distance[0] = cost[0];
      pathTo[0] = 0;

      while (true) {
         int minVertex = -1;
         int minWeight = Integer.MAX_VALUE;

         for (int i = 0; i < v; i++) {
            if (distance[i] < Integer.MAX_VALUE && !visited[i] && (distance[i]) < minWeight) {
               minVertex = i;
               minWeight = distance[i];
            }
         }

         if (minVertex == -1) {
            break;
         }

         visited[minVertex] = true;

         for (int i = 0; i < graph[minVertex].size(); i++) {
            Edge edge = graph[minVertex].get(i);

            if (distance[edge.to] > (distance[minVertex] + cost[edge.to])) {
               distance[edge.to] = (distance[minVertex] +cost[edge.to]);
               pathTo[edge.to] = minVertex;
            }
         }
      }

      System.out.println(distance[pathTo[v-1]]);

   }

}
