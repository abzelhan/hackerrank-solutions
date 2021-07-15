package codeforces.week5.graphs;

import java.io.PrintWriter;
import java.util.Scanner;

public class VertexOutdegree {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      PrintWriter printWriter = new PrintWriter(System.out);
      byte v = scanner.nextByte();
      for (int i = 0; i < v; i++) {
         int counter = 0;
         for (int j = 0; j < v; j++) {
            counter += scanner.nextByte();
         }

         printWriter.append(counter + " ");
      }
      printWriter.flush();
      printWriter.close();
      scanner.close();
   }

}
