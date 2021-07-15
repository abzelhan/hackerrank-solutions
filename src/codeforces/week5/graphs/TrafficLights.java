package codeforces.week5.graphs;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TrafficLights {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      List<Byte>[] vertex = new LinkedList[n];

      for (int i = 0; i < n; i++) {
         vertex[i] = new LinkedList<>();
      }

      int m = scanner.nextInt();

      for (int i = 0; i < m; i++) {
         byte a = scanner.nextByte();
         byte b = scanner.nextByte();

         a--;
         b--;

         vertex[a].add(b);
         vertex[b].add(a);
      }
      PrintWriter printWriter = new PrintWriter(System.out);
      for (int i = 0; i <n; i++) {
         printWriter.print(vertex[i].size() + " ");
      }

      printWriter.flush();
      printWriter.close();
   }

}
