package codeforces.week1;

import java.util.Scanner;

public class ValidParentheses {

   private static class Stack {

      private class Node {

         private char item;
         private Node next;
      }

      private Node first;

      private void push(char item) {
         Node oldFirst = first;
         first = new Node();
         first.item = item;
         first.next = oldFirst;
      }

      private char pop() {
         char item = first.item;
         first = first.next;
         return item;
      }

      private char peek() {
         return first.item;
      }

      private boolean isEmpty() {
         return first == null;
      }

   }

   public static void main(String[] args) {
      String word = new Scanner(System.in).nextLine();
      Stack stack = new Stack();
      boolean isValid = true;
      for (int i = 0; i < word.length(); i++) {
         char bracket = word.charAt(i);
         if (bracket == '{') {
            stack.push('}');
         } else if (bracket == '[') {
            stack.push(']');
         } else if (bracket == '(') {
            stack.push(')');
         } else {
            if (stack.isEmpty()) {
               isValid = false;
               break;
            } else if (stack.peek() == bracket) {
               stack.pop();
            } else {
               isValid = false;
               break;
            }
         }
      }

      if (!stack.isEmpty()) {
         isValid = false;
      }

      System.out.println(isValid ? "yes" : "no");
   }

}
