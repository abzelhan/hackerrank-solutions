package codeforces.week3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class DevuDurak {

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

   public static Random random = new Random();

   public static void quickSort(long a[], int l, int r) {

      if (l >= r) {
         return;
      }

      int pivotIndex = l + random.nextInt(r - l);

      long pivot = a[pivotIndex];

      int i = l, j = r;

      while (i <= j) {
         while (a[i] < pivot) {
            i++;
         }
         while (a[j] > pivot) {
            j--;
         }
         if (i <= j) {
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
         }
      }
      if (l < j) {
         quickSort(a, l, j);
      }

      if (i < r) {
         quickSort(a, i, r);
      }

   }

   public static void main(String[] args) throws Exception {
      Reader scanner = new Reader();
      int n = scanner.nextInt();
      long x = scanner.nextInt();
      long arr[] = new long[n];

      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }

      quickSort(arr, 0, n - 1);
      long result = 0;
      for (int i = 0; i < n; i++) {

         result += x * arr[i];
         if (x > 1) {
            x--;
         }
      }

      Math.max(1l, 2L);

      System.out.println(result);
   }

}
