package codeforces.week6;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BellmanFord {

   private static class Edge {

      int to, weight;

      public Edge(int to, int weight) {
         this.to = to;
         this.weight = weight;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int e = scanner.nextInt();
      List<Edge>[] graph = new LinkedList[v];
      int[] distance = new int[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
         distance[i] = Integer.MAX_VALUE;
      }

      for (int i = 0; i < e; i++) {
         int from = scanner.nextInt() - 1;
         int to = scanner.nextInt() - 1;
         int weight = scanner.nextInt();

         graph[from].add(new Edge(to, weight));
      }

      distance[0] = 0;

      for (int k = 1; k < v; k++) {
         for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
               Edge edge = graph[i].get(j);

               if (distance[i] < Integer.MAX_VALUE && distance[edge.to] > distance[i] + edge.weight) {
                  distance[edge.to] = distance[i] + edge.weight;
               }
            }
         }
      }


      for (int i = 0; i < v; i++) {
         System.out.print((distance[i] == Integer.MAX_VALUE ? -1 : distance[i]) + " ");
      }

   }

}
