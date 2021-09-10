package leetcode.medium.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedSameRowColumn {

   private static class Cell {

      int x;
      int y;

      public Cell(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }

         Cell cell = (Cell) o;

         if (x != cell.x) {
            return false;
         }
         return y == cell.y;
      }

      @Override
      public int hashCode() {
         int result = x;
         result = 31 * result + y;
         return result;
      }
   }

   public void dfs(Cell start, Map<Integer, Set<Cell>> rowNeighbours,
       Map<Integer, Set<Cell>> colNeighbours, Set<Cell> visited) {
      visited.add(start);

      List<Cell> mergedCells = new LinkedList<>();
      mergedCells.addAll(rowNeighbours.get(start.x));
      mergedCells.addAll(colNeighbours.get(start.y));

      for (Cell neighbourCell : mergedCells) {
         if (!visited.contains(neighbourCell)) {
            dfs(neighbourCell, rowNeighbours, colNeighbours, visited);
         }
      }
   }

   public int removeStones(int[][] stones) {
      Map<Integer, Set<Cell>> rowNeighbours = new HashMap<>();
      Map<Integer, Set<Cell>> colNeighbours = new HashMap<>();
      List<Cell> cells = new LinkedList<>();

      for (int i = 0; i < stones.length; i++) {
         cells.add(new Cell(stones[i][0], stones[i][1]));
      }

      Set<Cell> visited = new HashSet<>();

      for (Cell cell : cells) {
         rowNeighbours.putIfAbsent(cell.x, new HashSet<>());
         colNeighbours.putIfAbsent(cell.y, new HashSet<>());

         rowNeighbours.get(cell.x).add(cell);
         colNeighbours.get(cell.y).add(cell);
      }

      int counter = 0;

      for (Cell cell : cells) {
         if (!visited.contains(cell)) {
            counter++;
            dfs(cell, rowNeighbours, colNeighbours, visited);
         }
      }

      return stones.length - counter;
   }

   public static void main(String[] args) {

      System.out.println(new MostStonesRemovedSameRowColumn().removeStones(new int[][]{
              {0, 0},
              {0, 1}
              , {1, 0}
              , {1, 2}
              , {2, 1}
              , {2, 2}

          }
      ));


   }

}
