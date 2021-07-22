package codeforces.week6;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShortestPath {

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
      int from = scanner.nextInt() - 1;
      int to = scanner.nextInt() - 1;
      int[] distance = new int[v];
      boolean[] marked = new boolean[v];

      List<Edge>[] graph = new LinkedList[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
         distance[i] = Integer.MAX_VALUE;
      }

      distance[from] = 0;

      for (int i = 0; i < e; i++) {
         int v1 = scanner.nextInt() - 1;
         int v2 = scanner.nextInt() - 1;
         int weight = scanner.nextInt();
         graph[v1].add(new Edge(v2, weight));
      }

      while (true) {
         int vertex = -1;
         int minWeight = Integer.MAX_VALUE;
         //find min vertex
         for (int i = 0; i < v; i++) {
            if (!marked[i] && distance[i] < minWeight) {
               minWeight = distance[i];
               vertex = i;
            }
         }

         if (vertex == -1) {
            break;
         }

         marked[vertex] = true;

         for (int i = 0; i < graph[vertex].size(); i++) {
            Edge edge = graph[vertex].get(i);

            if (distance[edge.to] > distance[vertex] + edge.weight) {
               distance[edge.to] = distance[vertex] + edge.weight;
            }
         }
      }

      System.out.println(distance[to] == Integer.MAX_VALUE ? -1 : distance[to]);

   }

}
