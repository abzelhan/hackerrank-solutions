package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindNearestPointThatHasSameCoordinate {

   private static class Point {

      int x;
      int y;
      int index;

      public Point(int x, int y, int index) {
         this.x = x;
         this.y = y;
         this.index = index;
      }

      public int getIndex() {
         return index;
      }

      public int getX() {
         return x;
      }

   }

   public static int nearestValidPoint(int x, int y, int[][] points) {
      Comparator<Point> comparing = Comparator
          .comparing(point -> Math.abs(x - point.x) + Math.abs(y - point.y));
      comparing.thenComparing(Point::getIndex);
      PriorityQueue<Point> queue = new PriorityQueue<>(comparing);
      for (int i = 0; i < points.length; i++) {
         if (points[i][0] == x || points[i][1] == y) {
            queue.add(new Point(points[i][0], points[i][1], i));
         }
      }

      if (queue.size() == 0) {
         return -1;
      }

      return queue.poll().index;
   }

   public static void main(String[] args) {
      int[][] arr = {
          {1, 2},
          {3, 1},
          {2, 4},
          {2, 3},
          {4, 4}
      };
      System.out.println(nearestValidPoint(3, 4, arr));
   }

}
