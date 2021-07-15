package codeforces.week5.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class OutdegreeByEdgeList {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      byte v = scanner.nextByte();

      LinkedList<Short>[] edgeList = new LinkedList[v];
      short m = scanner.nextShort();

      for (int i = 0; i < v; i++) {
         edgeList[i] = new LinkedList<>();
      }

      for (int i = 0; i < m; i++) {
         short a = (short) (scanner.nextShort() - 1);
         short b = (short) (scanner.nextShort() - 1);
         edgeList[a].add(b);
         edgeList[b].add(a);
      }

      for (int i = 0; i < edgeList.length; i++) {
         System.out.print(edgeList[i].size() + " ");
      }
   }

}
