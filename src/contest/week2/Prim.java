package contest.week2;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Prim {

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

   private static class Result {

      /*
       * Complete the 'prims' function below.
       *
       * The function is expected to return an INTEGER.
       * The function accepts following parameters:
       *  1. INTEGER n
       *  2. 2D_INTEGER_ARRAY edges
       *  3. INTEGER start
       */

      public static int prims(int n, List<List<Integer>> edges, int start) {
         List<Edge> edgeList = new LinkedList<>();

         for (int i = 0; i < edges.size(); i++) {
            List<Integer> edgeXYWeight = edges.get(i);
            edgeList.add(new Edge(edgeXYWeight.get(0), edgeXYWeight.get(1), edgeXYWeight.get(2)));
         }

         Collections.sort(edgeList);

         int minCost = 0;
         int connectedVertices = 1;

         DSU dsu = new DSU(n + 1);

         for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (dsu.find(edge.v) != dsu.find(edge.w)) {
               dsu.union(edge.v, edge.w);
               minCost+=edge.weight;
               connectedVertices++;

            }

            if (connectedVertices == edgeList.size()) {
               break;
            }
         }

         return minCost;
      }

   }

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int m = Integer.parseInt(firstMultipleInput[1]);

      List<List<Integer>> edges = new ArrayList<>();

      IntStream.range(0, m).forEach(i -> {
         try {
            edges.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
      });

      int start = Integer.parseInt(bufferedReader.readLine().trim());

      int result = Result.prims(n, edges, start);
      System.out.println(result);

      bufferedReader.close();
   }
}
