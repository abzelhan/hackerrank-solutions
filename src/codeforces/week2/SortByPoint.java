package codeforces.week2;

import java.util.Scanner;

public class SortByPoint {

   static class Point implements Comparable<Point> {

      int x;
      int y;

      Point(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public int compareTo(Point that) {
         double distanceLeft = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
         double distanceRight = Math.sqrt(Math.pow(that.x, 2) + Math.pow(that.y, 2));
         if (distanceLeft < distanceRight) {
            return -1;
         }
         if (distanceLeft > distanceRight) {
            return 1;
         }
         return 0;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      Point[] points = new Point[n];
      for (int i = 0; i < n; i++) {
         points[i] = new Point(scanner.nextInt(), scanner.nextInt());
      }

      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0; j--) {
            if (points[j].compareTo(points[j - 1]) < 0) {
               Point temp = points[j];
               points[j] = points[j - 1];
               points[j - 1] = temp;
            }
         }
      }

      for (int i = 0; i < n; i++) {
         System.out.print(points[i].x + " " + points[i].y);
         System.out.println();
      }
   }

}
