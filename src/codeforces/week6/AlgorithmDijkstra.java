package codeforces.week6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class AlgorithmDijkstra {

   private static class Edge {

      int to, weight;

      public Edge(int weight, int to) {
         this.to = to;
         this.weight = weight;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }
         Edge edge = (Edge) o;
         return to == edge.to && weight == edge.weight;
      }

      @Override
      public int hashCode() {
         return Objects.hash(to, weight);
      }
   }

   private static class Reader {

      final private int BUFFER_SIZE = 1 << 16;
      private DataInputStream din;
      private byte[] buffer;
      private int bufferPointer, bytesRead;

      public Reader() {
         din = new DataInputStream(System.in);
         buffer = new byte[BUFFER_SIZE];
         bufferPointer = bytesRead = 0;
      }

      public Reader(String file_name) throws IOException {
         din = new DataInputStream(
             new FileInputStream(file_name));
         buffer = new byte[BUFFER_SIZE];
         bufferPointer = bytesRead = 0;
      }

      public String readLine() throws IOException {
         byte[] buf = new byte[64]; // line length
         int cnt = 0, c;
         while ((c = read()) != -1) {
            if (c == '\n') {
               if (cnt != 0) {
                  break;
               } else {
                  continue;
               }
            }
            buf[cnt++] = (byte) c;
         }
         return new String(buf, 0, cnt);
      }

      public int nextInt() throws IOException {
         int ret = 0;
         byte c = read();
         while (c <= ' ') {
            c = read();
         }
         boolean neg = (c == '-');
         if (neg) {
            c = read();
         }
         do {
            ret = ret * 10 + c - '0';
         } while ((c = read()) >= '0' && c <= '9');

         if (neg) {
            return -ret;
         }
         return ret;
      }

      public long nextLong() throws IOException {
         long ret = 0;
         byte c = read();
         while (c <= ' ') {
            c = read();
         }
         boolean neg = (c == '-');
         if (neg) {
            c = read();
         }
         do {
            ret = ret * 10 + c - '0';
         } while ((c = read()) >= '0' && c <= '9');
         if (neg) {
            return -ret;
         }
         return ret;
      }

      public double nextDouble() throws IOException {
         double ret = 0, div = 1;
         byte c = read();
         while (c <= ' ') {
            c = read();
         }
         boolean neg = (c == '-');
         if (neg) {
            c = read();
         }

         do {
            ret = ret * 10 + c - '0';
         } while ((c = read()) >= '0' && c <= '9');

         if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
               ret += (c - '0') / (div *= 10);
            }
         }

         if (neg) {
            return -ret;
         }
         return ret;
      }

      private void fillBuffer() throws IOException {
         bytesRead = din.read(buffer, bufferPointer = 0,
             BUFFER_SIZE);
         if (bytesRead == -1) {
            buffer[0] = -1;
         }
      }

      private byte read() throws IOException {
         if (bufferPointer == bytesRead) {
            fillBuffer();
         }
         return buffer[bufferPointer++];
      }

      public void close() throws IOException {
         if (din == null) {
            return;
         }
         din.close();
      }
   }

   private static void printPath(int parent[], int j, PrintWriter printWriter) {
      if (j == 0) {
         return;
      }

      printPath(parent, parent[j], printWriter);
      printWriter.print((parent[j] + 1));
      printWriter.print(" ");
   }

   public static void main(String[] args) throws Exception {
      Reader scanner = new Reader();
      int v = scanner.nextInt();
      int e = scanner.nextInt();

      List<Edge>[] graph = new LinkedList[v];
      int[] distance = new int[v];
      int[] pathTo = new int[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
         distance[i] = Integer.MAX_VALUE;
      }

      for (int i = 0; i < e; i++) {
         int from = scanner.nextInt() - 1;
         int to = scanner.nextInt() - 1;
         int weight = scanner.nextInt();

         graph[from].add(new Edge(weight, to));
         graph[to].add(new Edge(weight, from));
      }

      distance[0] = 0;
      pathTo[0] = -1;

      TreeSet<Edge> set = new TreeSet<Edge>(new Comparator<Edge>() {
         @Override
         public int compare(Edge o1, Edge o2) {
            return Integer.compare(o1.weight, o2.weight);
         }
      });

      Edge startEdge = new Edge(0, 0);

      set.add(startEdge);

      while (!set.isEmpty()) {
         Edge smallest = set.first();
         set.remove(smallest);
         int vertex = smallest.to;

         int size = graph[vertex].size();
         for (int i = 0; i < size; i++) {
            Edge edge = graph[vertex].get(i);

            if (distance[edge.to] > distance[vertex] + edge.weight) {
               Edge oldEdge = new Edge(distance[edge.to], edge.to);
               if (set.contains(oldEdge)) {
                  set.remove(oldEdge);
               }
               distance[edge.to] = distance[vertex] + edge.weight;
               pathTo[edge.to] = vertex;
               set.add(new Edge(distance[edge.to], edge.to));
            }
         }
      }

      if (distance[v - 1] == Integer.MAX_VALUE) {
         System.out.println(-1);
         return;
      }

      PrintWriter printWriter = new PrintWriter(System.out);

      printPath(pathTo, v - 1, printWriter);
      printWriter.print(v);

      printWriter.flush();

      /*Stack<Integer> path = new Stack<>();
      int pathIndex = v - 1;
      while (true) {

         path.add(pathIndex + 1);
         if (pathIndex == pathTo[pathIndex]) {
            break;
         }
         pathIndex = pathTo[pathIndex];
      }

      PrintWriter printWriter = new PrintWriter(System.out);

      while (!path.isEmpty()) {
         printWriter.print(path.pop() + " ");
      }

      printWriter.flush();*/

   }

}
