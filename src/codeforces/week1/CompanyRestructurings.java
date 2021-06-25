package codeforces.week1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;

public class CompanyRestructurings {

   static class DSU {

      private int[] parent;
      private int[] rank;

      public DSU(int n) {
         parent = new int[n + 1];
         rank = new int[n + 1];
         for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
         }
      }

      public int find(int a) {
         if (a == parent[a]) {
            return a;
         }

         //path compression
         parent[a] = find(parent[a]);
         return parent[a];
      }

      public void union(int p, int q) {
         int rootP = find(p);
         int rootQ = find(q);

         if (rootP == rootQ) {
            return;
         }

         if (rank[rootP] < rank[rootQ]) {
            int temp = rootP;
            rootP = rootQ;
            rootQ = temp;
         }

         parent[rootQ] = rootP;
         if (rank[rootP] == rank[rootQ]) {
            rank[rootP]++;
         }

      }

   }

   static class Interval implements Comparable<Interval> {

      int left;
      int right;

      Interval(int left, int right) {
         this.left = left;
         this.right = right;
      }

      @Override
      public int compareTo(Interval o) {
         return Integer.compare(this.left, o.left);
      }
   }

   static class Reader {

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

   public static void main(String[] args) throws IOException {
      Reader scanner = new Reader();
      PrintWriter writer = new PrintWriter(System.out);
      int n = scanner.nextInt();
      DSU dsu = new DSU(n);

      TreeSet<Interval> intervals = new TreeSet<>();

      for (int i = 1; i <= n; i++) {
         intervals.add(new Interval(i, i));
      }

      int operations = scanner.nextInt();

      for (int i = 0; i < operations; i++) {
         int operationType = scanner.nextInt();
         int p = scanner.nextInt();
         int q = scanner.nextInt();
         if (operationType == 3) {
            Interval leftInterval = intervals.lower(new Interval(p + 1, 0));
            Interval rightInterval = intervals.lower(new Interval(q + 1, 0));
            if (leftInterval == null) {
               leftInterval = intervals.last();
            }
            if (rightInterval == null) {
               rightInterval = intervals.last();
            }
            boolean inSameGroup = dsu.find(leftInterval.left) == dsu.find(rightInterval.left);
            writer.println(inSameGroup ? "YES" : "NO");
         } else if (operationType == 1) {
            Interval leftInterval = intervals.lower(new Interval(p + 1, 0));
            Interval rightInterval = intervals.lower(new Interval(q + 1, 0));
            if (leftInterval == null) {
               leftInterval = intervals.last();
            }
            if (rightInterval == null) {
               rightInterval = intervals.last();
            }
            boolean inSameGroup = dsu.find(leftInterval.left) == dsu.find(rightInterval.left);

            if (!inSameGroup) {
               dsu.union(leftInterval.left, rightInterval.left);
            }
         } else {
            int curL = p;
            Interval curInterval = intervals.lower(new Interval(curL + 1, 0));
            if (curInterval == null) {
               curInterval = intervals.last();
            }

            curL = curInterval.right + 1;
            intervals.remove(curInterval);

            while (curL <= q) {
               Interval c = intervals.lower(new Interval(curL + 1, 0));
               if (c == null) {
                  c = intervals.last();
               }
               if (dsu.find(curInterval.left) != dsu.find(c.left)) {
                  dsu.union(curInterval.left, c.left);
               }
               intervals.remove(c);
               curInterval.right = c.right;
               curL = c.right + 1;
            }
            intervals.add(curInterval);
         }
      }
      scanner.close();
      writer.flush();
      writer.close();
   }

}
