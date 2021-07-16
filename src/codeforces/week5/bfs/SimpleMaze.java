package codeforces.week5.bfs;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SimpleMaze {

   private static List<Cell> graph[][];
   private static boolean visited[][];
   private static int distance[][];
   private static Queue<Cell> queue;

   private static class Cell {

      int x;
      int y;

      private Cell(int x, int y) {
         this.x = x;
         this.y = y;
      }

   }

   private static void bfs(int x, int y) {
      queue.add(new Cell(x, y));
      visited[x][y] = true;
      distance[x][y] = 0;

      while (!queue.isEmpty()) {
         Cell cell = queue.poll();

         for (Cell neighbourCell : graph[cell.x][cell.y]) {
            if (!visited[neighbourCell.x][neighbourCell.y]) {
               queue.add(neighbourCell);
               visited[neighbourCell.x][neighbourCell.y] = true;
               distance[neighbourCell.x][neighbourCell.y] = distance[cell.x][cell.y] + 1;
            }
         }
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

   public static void main(String[] args) throws Exception {
      Reader scanner = new Reader();
      int rows = scanner.nextInt();
      int cols = scanner.nextInt();

      int[][] maze = new int[rows][cols];

      graph = new LinkedList[rows][cols];
      visited = new boolean[rows][cols];
      distance = new int[rows][cols];
      queue = new LinkedList<>();

      List<Cell> holes = new LinkedList<>();

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            maze[i][j] = scanner.nextInt();
            if (maze[i][j] == 2) {
               holes.add(new Cell(i, j));
            }
            graph[i][j] = new LinkedList<>();
         }
      }

      for (int r = 0; r < rows; r++) {
         for (int c = 0; c < cols; c++) {
            if (maze[r][c] != 1) {

               Cell cell = new Cell(r, c);

               //move to right
               for (int j = cell.y + 1; j < cols; j++) {
                  if (maze[cell.x][j] == 2) {
                     Cell exitCell = new Cell(cell.x, j);
                     graph[cell.x][cell.y].add(exitCell);
                     break;
                  }

                  if ((maze[cell.x][j] == 1 || (j + 1) == cols)) {
                     int maxRightPos = maze[cell.x][j] == 1 ? j - 1 : j;
                     if (cell.y != maxRightPos) {
                        Cell maxRightCell = new Cell(cell.x, maxRightPos);
                        graph[cell.x][cell.y].add(maxRightCell);
                     }
                     break;
                  }
               }

               //move to down
               for (int i = cell.x + 1; i < rows; i++) {
                  if (maze[i][cell.y] == 2) {
                     Cell exitCell = new Cell(i, cell.y);
                     graph[cell.x][cell.y].add(exitCell);
                     break;
                  }

                  if ((maze[i][cell.y] == 1 || (i + 1) == rows)) {
                     int maxDownPos = maze[i][cell.y] == 1 ? i - 1 : i;
                     if (cell.x != maxDownPos) {
                        Cell maxDownCell = new Cell(maxDownPos, cell.y);
                        graph[cell.x][cell.y].add(maxDownCell);
                     }
                     break;
                  }
               }

               //move to left
               for (int j = cell.y - 1; j >= 0; j--) {
                  if (maze[cell.x][j] == 2) {
                     Cell exitCell = new Cell(cell.x, j);
                     graph[cell.x][cell.y].add(exitCell);
                     break;
                  }

                  if ((maze[cell.x][j] == 1 || j == 0)) {
                     int maxLeftPos = maze[cell.x][j] == 1 ? j + 1 : j;
                     if (cell.y != maxLeftPos) {
                        Cell maxLeftCell = new Cell(cell.x, maxLeftPos);
                        graph[cell.x][cell.y].add(maxLeftCell);
                     }
                     break;
                  }
               }

               //move to top
               for (int i = cell.x - 1; i >= 0; i--) {
                  if (maze[i][cell.y] == 2) {
                     Cell exitCell = new Cell(i, cell.y);
                     graph[cell.x][cell.y].add(exitCell);
                     break;
                  }

                  if ((maze[i][cell.y] == 1 || i == 0)) {
                     int maxTopPos = maze[i][cell.y] == 1 ? i + 1 : i;
                     if (cell.x != maxTopPos) {
                        Cell maxTopCell = new Cell(maxTopPos, cell.y);
                        graph[cell.x][cell.y].add(maxTopCell);
                     }
                     break;
                  }
               }
            }
         }
      }

      bfs(0, 0);

      int min = Integer.MAX_VALUE;

      for (Cell hole : holes) {
         if (min > distance[hole.x][hole.y]) {
            min = distance[hole.x][hole.y];
         }
      }

      System.out.println(min);
   }

}
