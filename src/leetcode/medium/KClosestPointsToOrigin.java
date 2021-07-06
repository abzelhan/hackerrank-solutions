package leetcode.medium;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

   private static class Point implements Comparable<Point> {

      int x;
      int y;
      double distance;
      public Point(int x, int y) {
         this.x = x;
         this.y = y;
         this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      }

      @Override
      public int compareTo(Point that) {
         return Double.compare(distance, that.distance);
      }
   }

   public static int[][] kClosest(int[][] points, int k) {
      PriorityQueue<Point> queue = new PriorityQueue<>();
      for (int i = 0; i < points.length; i++) {
         queue.add(new Point(points[i][0], points[i][1]));

      }

      points = new int[k][2];

      for (int i = 0; i < k; i++) {
         points[i][0] = queue.peek().x;
         points[i][1] = queue.peek().y;
         queue.poll();
      }

      return points;
   }

   public static void main(String[] args) {
      int[][] points = {
          {3, 3},
          {-2, 4},
          {5, -1}

      };

      points = kClosest(points, 2);
      for (int i = 0; i < points.length; i++) {
         System.out.println(points[i][0] + " " + points[i][1]);

      }
   }

}
