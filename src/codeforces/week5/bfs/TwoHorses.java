package codeforces.week5.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TwoHorses {

   private static class Cell {

      int x;
      int y;

      private Cell(int x, int y) {
         this.x = x;
         this.y = y;
      }

   }

   private static List<Cell>[][] graph;
   private static Queue<Cell> queue;
   private static boolean[][] marked1 = new boolean[8][8];
   private static boolean[][] marked2 = new boolean[8][8];
   private static int[][] distance1 = new int[8][8];
   private static int[][] distance2 = new int[8][8];

   private static boolean checkCell(int i, int j, int rows, int cols) {
      return (i >= 0 && i < rows && j >= 0 && j < cols);
   }

   private static void bfs(int x, int y, boolean[][] marked, int[][] distance) {
      queue.add(new Cell(x, y));
      marked[x][y] = true;
      distance[x][y] = 0;

      while (!queue.isEmpty()) {
         Cell cell = queue.poll();

         for (Cell neighbourCell : graph[cell.x][cell.y]) {
            if (!marked[neighbourCell.x][neighbourCell.y]) {
               marked[neighbourCell.x][neighbourCell.y] = true;
               distance[neighbourCell.x][neighbourCell.y] = distance[cell.x][cell.y] + 1;
               queue.add(neighbourCell);
            }
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String pos1 = scanner.next();
      String pos2 = scanner.next();

      graph = new LinkedList[8][8];
      queue = new LinkedList<>();
      Queue<Integer[]> queue1 = new LinkedList<>();

      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            graph[i][j] = new LinkedList<>();
         }
      }

      int i1 = pos1.charAt(1) - 49;
      int j1 = pos1.charAt(0) - 97;

      int i2 = pos2.charAt(1) - 49;
      int j2 = pos2.charAt(0) - 97;

      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            if (checkCell(i - 2, j + 1, 8, 8)) {
               graph[i][j].add(new Cell(i - 2, j + 1));
            }
            if (checkCell(i - 2, j - 1, 8, 8)) {
               graph[i][j].add(new Cell(i - 2, j - 1));

            }
            if (checkCell(i + 2, j + 1, 8, 8)) {
               graph[i][j].add(new Cell(i + 2, j + 1));

            }
            if (checkCell(i + 2, j - 1, 8, 8)) {
               graph[i][j].add(new Cell(i + 2, j - 1));

            }
            if (checkCell(i - 1, j + 2, 8, 8)) {
               graph[i][j].add(new Cell(i - 1, j + 2));

            }
            if (checkCell(i - 1, j - 2, 8, 8)) {
               graph[i][j].add(new Cell(i - 1, j - 2));

            }
            if (checkCell(i + 1, j + 2, 8, 8)) {
               graph[i][j].add(new Cell(i + 1, j + 2));

            }
            if (checkCell(i + 1, j - 2, 8, 8)) {
               graph[i][j].add(new Cell(i + 1, j - 2));
            }
         }
      }

      bfs(i1, j1, marked1, distance1);
      bfs(i2, j2, marked2, distance2);

      int minDist = Integer.MAX_VALUE;

      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            if (distance1[i][j] == distance2[i][j]) {

               if (distance1[i][j] < minDist) {
                  minDist = distance1[i][j];
               }

            }
         }
      }

      System.out.println(minDist == Integer.MAX_VALUE ? "-1" : minDist);

   }

}
