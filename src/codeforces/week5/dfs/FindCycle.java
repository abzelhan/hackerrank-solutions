package codeforces.week5.dfs;

import java.util.Scanner;

public class FindCycle {

   private static byte[][] graph;
   private static byte[] visited;

   private static boolean dfs(int v) {
      if (visited[v] == 1) {
         return true;
      }

      visited[v] = 1;

      for (int i = 0; i < graph.length; i++) {
         if (graph[v][i] == 1) {
            boolean hasCycle = dfs(i);
            if (hasCycle) {
               return true;
            }
         }
      }

      visited[v] = 2;

      return false;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int v = scanner.nextInt();
      graph = new byte[v][v];
      visited = new byte[v];

      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            graph[i][j] = scanner.nextByte();
         }
      }

      for (int i = 0; i < v; i++) {
         if (visited[i] == 0) {
            boolean hasCycle = dfs(i);

            if (hasCycle) {
               System.out.println("1");
               return;
            }
         }
      }

      System.out.println("0");
   }

}
