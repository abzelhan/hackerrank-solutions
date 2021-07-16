package codeforces.week5.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MinPathInGraph {

   private static List<Integer> graph[];
   private static int distance[];
   private static boolean visited[];

   private static void bfs(int source) {
      Queue<Integer> queue = new LinkedList<>();
      queue.add(source);
      distance[source] = 0;
      visited[source] = true;

      while (!queue.isEmpty()) {
         Integer v = queue.poll();

         for (Integer w : graph[v]) {
            if (!visited[w]) {
               queue.add(w);
               distance[w] = distance[v] + 1;
               visited[w] = true;
            }
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int e = scanner.nextInt();

      graph = new LinkedList[v + 1];
      distance = new int[v + 1];
      visited = new boolean[v + 1];

      for (int i = 1; i < v + 1; i++) {
         graph[i] = new LinkedList<>();
         distance[i] = -1;
      }

      for (int i = 0; i < e; i++) {
         int a = scanner.nextInt();
         int b = scanner.nextInt();

         graph[a].add(b);
         graph[b].add(a);
      }

      int source = scanner.nextInt();
      int destination = scanner.nextInt();

      bfs(source);

      System.out.println(distance[destination]);

   }

}
