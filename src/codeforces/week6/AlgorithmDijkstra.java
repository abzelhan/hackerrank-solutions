package codeforces.week6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AlgorithmDijkstra {

   private static class Edge implements Comparable<Edge> {

      int to, weight;

      public Edge(int to, int weight) {
         this.to = to;
         this.weight = weight;
      }

      @Override
      public int compareTo(Edge o) {
         return Integer.compare(weight, o.weight);
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


   private static int add(int x, int y)
   {
      if (y == 0)
         return x;
      else
         return add(x ^ y, (x & y) << 1);
   }

   public static void main(String[] args) throws Exception {
      Reader scanner = new Reader();
      int v = scanner.nextInt();
      int e = scanner.nextInt();

      List<Edge>[] graph = new ArrayList[v];
      int[] distance = new int[v];
      int[] pathTo = new int[v];

      for (int i = 0; i < v; ++i) {
         graph[i] = new ArrayList<>();
         distance[i] = Integer.MAX_VALUE;
      }

      for (int i = 0; i < e; ++i) {
         int from = scanner.nextInt() - 1;
         int to = scanner.nextInt() - 1;
         int weight = scanner.nextInt();

         graph[from].add(new Edge(to, weight));
         graph[to].add(new Edge(from, weight));
      }

      distance[0] = 0;
      pathTo[0] = -1;

      PriorityQueue<Edge> queue = new PriorityQueue<>();

      Edge startEdge = new Edge(0, 0);

      queue.add(startEdge);

      while (!queue.isEmpty()) {
         Edge smallest = queue.poll();
         int vertex = smallest.to;

         if (distance[vertex] < smallest.weight) {
            continue;
         }

         int size = graph[vertex].size();
         for (int i = 0; i < size; ++i) {
            Edge edge = graph[vertex].get(i);

            int newDistance = add(distance[vertex], edge.weight);

            if (distance[edge.to] > newDistance) {

               distance[edge.to] = newDistance;

               pathTo[edge.to] = vertex;
               queue.add(new Edge(edge.to, distance[edge.to]));
            }
         }

         graph[vertex].remove(smallest);
      }

      if (distance[v - 1] == Integer.MAX_VALUE) {
         System.out.println(-1);
         return;
      }

      LinkedList<Integer> path = new LinkedList<>();

      int pathIndex = v - 1;


      while (true) {
         if (pathIndex == -1) {
            break;
         }
         path.addFirst(add(pathIndex, 1));

         pathIndex = pathTo[pathIndex];
      }

      PrintWriter printWriter = new PrintWriter(System.out);

      for (Integer vertex : path) {
         printWriter.print(vertex);
         printWriter.append(" ");
      }

      printWriter.flush();

   }

}
