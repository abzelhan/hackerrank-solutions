package codeforces.week3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class LessOrEqual {

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

      public int nextLong() throws IOException {
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

   public static void quickSort(int a[], int l, int r) {

      if (l >= r) {
         return;
      }

      int pivotIndex = l + random.nextInt(r - l);

      int pivot = a[pivotIndex];

      int i = l, j = r;

      while (i <= j) {
         while (a[i] < pivot) {
            i++;
         }
         while (a[j] > pivot) {
            j--;
         }
         if (i <= j) {
            int temp = a[i];
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

   public static void main(String[] s) throws Exception {
      Reader scanner = new Reader();
      int n = scanner.nextInt();
      int k = scanner.nextInt();

      int arr[] = new int[n + 1];
      arr[0] = 1;
      for (int i = 1; i <= n; ++i) {
         arr[i] = scanner.nextInt();

      }

      quickSort(arr, 1, n);

      if (k + 1 > n) {
         System.out.println(arr[k]);
         return;
      }
      System.out.println((arr[k] != arr[k + 1]) ? arr[k] : -1);

   }

}