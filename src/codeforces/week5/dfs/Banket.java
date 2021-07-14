package codeforces.week5.dfs;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Banket {

   private static LinkedList<Integer>[] graph;
   private static int[] tables;
   private static boolean good = true;

   private static void dfs(int v, int table) {
      if (tables[v] == table) {
         return;
      }

      if (tables[v] != 0) {
         good = false;
         return;
      }

      tables[v] = table;
      for (Integer w : graph[v]) {
         if (tables[v] == 1) {
            dfs(w, 2);
         } else {
            dfs(w, 1);
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int w = scanner.nextInt();
      graph = new LinkedList[v];
      tables = new int[v];

      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < w; i++) {
         int a = scanner.nextInt() - 1;
         int b = scanner.nextInt() - 1;

         graph[a].add(b);
         graph[b].add(a);
      }

      for (int i = 0; i < v; i++) {
         if (tables[i] == 0) {
            dfs(i, 1);
         }
      }

      if (good) {
         System.out.println("YES");
         PrintWriter printWriter = new PrintWriter(System.out);

         int counter = 0;
         for (int i = 0; i < tables.length; i++) {
            if (tables[i] == 1) {
               counter++;
               printWriter.print((i + 1));
               printWriter.print(" ");
            }
         }

         System.out.println(counter);
         printWriter.flush();
      } else {
         System.out.println("NO");
      }

   }

}
