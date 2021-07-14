package codeforces.week5.dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class ConnectivityComponents {

   private static LinkedList<Integer>[] graph;
   private static boolean[] visited;

   private static void dfs(int v) {
      visited[v] = true;

      for (Integer w : graph[v]) {
         if (!visited[w]) {
            dfs(w);
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int w = scanner.nextInt();
      graph = new LinkedList[v];
      visited = new boolean[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < w; i++) {
         int a = scanner.nextInt() - 1;
         int b = scanner.nextInt() - 1;

         graph[a].add(b);
         graph[b].add(a);
      }

      int counter = 0;

      for (int i = 0; i < graph.length; i++) {
         if (!visited[i]) {
            counter++;
            dfs(i);
         }
      }

      System.out.println(counter);
   }

}
