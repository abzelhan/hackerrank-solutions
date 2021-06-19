package codeforces.week1;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesReplacement {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String word = scanner.nextLine();
      Stack<Character> brackets = new Stack<>();
      int counter = 0;

      for (int i = 0; i < word.length(); i++) {
         char bracket = word.charAt(i);
         if (bracket == '[') {
            brackets.push(']');
         } else if (bracket == '<') {
            brackets.push('>');
         } else if (bracket == '{') {
            brackets.push('}');
         } else if (bracket == '(') {
            brackets.push(')');
         } else {

            if (!brackets.isEmpty()) {
               Character closeBracket = brackets.peek();
               if (closeBracket != bracket) {
                  counter++;
               }
               brackets.pop();
               continue;
            }

            System.out.println("Impossible");
            return;
         }
      }

      if (!brackets.isEmpty()) {
         System.out.println("Impossible");
      } else {
         System.out.println(counter);
      }
   }

}
