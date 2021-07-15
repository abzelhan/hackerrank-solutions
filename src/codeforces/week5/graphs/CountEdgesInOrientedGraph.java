package codeforces.week5.graphs;

import java.util.Scanner;

public class CountEdgesInOrientedGraph {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      int counter = 0;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            counter += scanner.nextInt();
         }
      }
      System.out.println(counter);

   }

}
