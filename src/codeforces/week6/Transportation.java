package codeforces.week6;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Transportation {

   private static class Edge {

      int to, minutes, cups;

      public Edge(int to, int minutes, int cups) {
         this.to = to;
         this.minutes = minutes;
         this.cups = cups;
      }

   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int e = scanner.nextInt();
      boolean[] visited = new boolean[v];
      List<Edge>[] graph = new LinkedList[v];
      int[] distance = new int[v];
      int[] amountOfCups = new int[v];
      int[] pathTo = new int[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
         distance[i] = Integer.MAX_VALUE;
         amountOfCups[i] = 0;
      }

      for (int i = 0; i < e; i++) {
         int from = scanner.nextInt() - 1;
         int to = scanner.nextInt() - 1;
         int time = scanner.nextInt();
         int cups = (scanner.nextInt() - 3_000_000) / 100;
         graph[from].add(new Edge(to, time, cups));
         graph[to].add(new Edge(from, time, cups));
      }

      distance[0] = 0;
      amountOfCups[0] = 0;
      pathTo[0] = 0;
      while (true) {
         int minVertex = -1;
         int minWeight = Integer.MAX_VALUE;

         for (int i = 0; i < v; i++) {
            if (!visited[i] && distance[i] < minWeight) {
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
            if ((distance[edge.to] > distance[minVertex] + edge.minutes)
                && distance[minVertex] + edge.minutes <= 1440
                && amountOfCups[edge.to] < edge.cups ) {
               distance[edge.to] = distance[minVertex] + edge.minutes;
               amountOfCups[edge.to] = edge.cups ;
               pathTo[edge.to] = minVertex;
            }
         }

      }

      System.out.println(amountOfCups[v - 1]);


   }

}
