package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostToConnectAllPoints {

   private static class DSU {

      private int[] parent;
      private int[] rank;

      public DSU(int n) {
         parent = new int[n];
         rank = new int[n];
         for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
         }
      }

      public void union(int p, int q) {
         int leaderP = find(p);
         int leaderQ = find(q);

         if (leaderP == leaderQ) {
            return;
         }

         if (rank[leaderP] > rank[leaderQ]) {
            parent[leaderQ] = leaderP;
         } else if (rank[leaderP] < rank[leaderQ]) {
            parent[leaderP] = leaderQ;
         } else {
            parent[leaderQ] = leaderP;
            rank[leaderP]++;
         }

      }

      public int find(int p) {
         if (parent[p] == p) {
            return p;
         }

         parent[p] = find(parent[p]);
         return parent[p];
      }

   }

   private static class Edge implements Comparable<Edge> {

      private int w;
      private int v;
      private int weight;

      public Edge(int w, int v, int weight) {
         this.w = w;
         this.v = v;
         this.weight = weight;
      }

      @Override
      public int compareTo(Edge that) {
         return Integer.compare(this.weight, that.weight);
      }
   }

   public int getManhattanDistance(int x1, int y1, int x2, int y2) {
      return Math.abs(x1 - x2) + Math.abs(y1 - y2);
   }

   public int minCostConnectPoints(int[][] points) {
      List<Edge> edges = new ArrayList<>();

      for (int i = 0; i < points.length; i++) {
         int[] point1 = points[i];

         for (int j = 0; j < points.length; j++) {
            if (j != i) {
               int[] point2 = points[j];

               edges.add(new Edge(i, j,
                   getManhattanDistance(point1[0], point1[1], point2[0], point2[1])));
            }
         }
      }

      DSU dsu = new DSU(points.length);

      Collections.sort(edges);

      int minCost = 0;
      int connectedVertices = 1;
      for (int i = 0; i < edges.size(); i++) {
         Edge edge = edges.get(i);

         if (dsu.find(edge.v) != dsu.find(edge.w)) {
            dsu.union(edge.w, edge.v);
            minCost += edge.weight;
            connectedVertices++;
         }

         if (connectedVertices == points.length) {
            break;
         }
      }

      return minCost;
   }

   public static void main(String[] args) {
      System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(new int[][]{
          {0, 0},
          {2, 2},
          {3, 10},
          {5, 2},
          {7, 0}
      }));
   }

}
