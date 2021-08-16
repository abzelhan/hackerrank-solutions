package codeforces.week7;

import java.util.LinkedList;

public class Sequence {

   public static void main(String[] args) {
      int n = 5;

      LinkedList<Integer>[] list = new LinkedList[n + 1];

      for (int i = 0; i < n + 1; i++) {
         list[i] = new LinkedList<>();
      }

      list[0].add(1);
      list[0].add(1);

      System.out.println();

   }

}
