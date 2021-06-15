package codeforces.week1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Directory {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Stack<String> paths = new Stack<>();
      int operations = Integer.valueOf(scanner.nextLine());

      for (int i = 0; i < operations; i++) {
         String command = scanner.next();
         if (command.equals("pwd")) {
            if (paths.isEmpty()) {
               System.out.println("/");
            } else {

               Iterator<String> iterator = paths.iterator();
               while (iterator.hasNext()) {
                  String val = iterator.next();
               }

               for (String path : paths) {
                  System.out.print("/" + path);
               }
               System.out.print("/");
               System.out.println();
            }
         } else {
            String path = scanner.next();
            String[] dirs = path.split("/");
            if (path.startsWith("/")) {
               paths.clear();
            }
            for (String dir : dirs) {
               if (dir.equals("..") && !paths.isEmpty()) {
                  paths.pop();
               } else if (!dir.isEmpty()) {
                  paths.push(dir);
               }
            }
         }
      }

   }

}
