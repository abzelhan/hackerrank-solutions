package codeforces.week5.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class TurnMe {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();

      LinkedList<Integer>[] edgeList = new LinkedList[v];

      for (int i = 0; i < v; i++) {
         if (edgeList[i] == null) {
            edgeList[i] = new LinkedList<>();
         }
         int edges = scanner.nextInt();
         for (int j = 0; j < edges; j++) {
            int mainEdge = i;
            int anotherEdge = scanner.nextInt() - 1;
            if (edgeList[anotherEdge] == null) {
               edgeList[anotherEdge] = new LinkedList<>();
            }
            edgeList[anotherEdge].add(mainEdge + 1);
         }
      }

      System.out.println(edgeList.length);

      for (int i = 0; i < edgeList.length; i++) {
         System.out.print(edgeList[i].size() + " ");
         for (int j = 0; j < edgeList[i].size(); j++) {
            System.out.print(edgeList[i].get(j) + " ");
         }
         System.out.println();
      }

   }

}
