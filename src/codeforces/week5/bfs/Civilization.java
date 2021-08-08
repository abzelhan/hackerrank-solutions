package codeforces.week5.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Civilization {

   private static List<Cell> graph[][];
   private static boolean visited[][];
   private static int distance[][];
   private static Queue<Cell> queue;
   private static char grid[][];

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
               int distanceCost = grid[neighbourCell.x][neighbourCell.y] == 'W' ? 2 : 1;
               distance[neighbourCell.x][neighbourCell.y] = distance[cell.x][cell.y] + distanceCost;
            }
         }
      }
   }

   private static boolean isValid(int x, int y, int rows, int cols) {
      return (x >= 0 && x < rows && y >= 0 && y < cols);
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int rows = scanner.nextInt();
      int cols = scanner.nextInt();
      graph = new LinkedList[rows][cols];
      visited = new boolean[rows][cols];
      distance = new int[rows][cols];
      queue = new LinkedList<>();

      int x1 = scanner.nextInt() - 1;
      int y1 = scanner.nextInt() - 1;
      int x2 = scanner.nextInt() - 1;
      int y2 = scanner.nextInt() - 1;

      scanner.nextLine();
      grid = new char[rows][cols];

      int[] di = {1, -1, 0, 0};
      int[] dj = {0, 0, 1, -1};

      for (int i = 0; i < rows; i++) {
         String line = scanner.nextLine().replace(" ","");
         for (int j = 0; j < cols; j++) {
            grid[i][j] = line.charAt(j);
            graph[i][j] = new LinkedList<>();
         }
      }

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            if (grid[i][j] != '#') {
               for (int k = 0; k < 4; k++) {
                  int neighbourX = i + di[k];
                  int neighbourY = j + dj[k];

                  if (isValid(neighbourX, neighbourY, rows, cols)
                      && grid[neighbourX][neighbourY] != '#') {
                     graph[i][j].add(new Cell(neighbourX, neighbourY));
                  }

               }
            }
         }
      }

      bfs(x1, y1);

      if (distance[x2][y2] == 0) {
         System.out.println(-1);
         return;
      }

      int distanceCost = grid[x2][y2] == 'W' ? 2 : 1;


      System.out.println(grid[x1][y1] == grid[x2][y2] ? distance[x2][y2] - distanceCost : distance[x2][y2]);
   }

}
