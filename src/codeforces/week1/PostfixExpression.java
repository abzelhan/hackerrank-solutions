package codeforces.week1;

import java.util.Scanner;

public class PostfixExpression {

   private static class Stack {

      private class Node {

         private int item;
         private Node next;
      }

      private Node first;

      public void push(int item) {
         Node oldNext = first;
         first = new Node();
         first.item = item;
         first.next = oldNext;
      }

      public int pop() {
         int item = first.item;
         first = first.next;
         return item;
      }

      public boolean isEmpty() {
         return first == null;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String expression = scanner.nextLine();
      Stack stack = new Stack();

      for (int i = 0; i < expression.length(); i++) {
         if (expression.charAt(i) != ' ') {
            if (!Character.isDigit(expression.charAt(i))) {
               int right = stack.pop();
               int left = stack.pop();
               if (expression.charAt(i) == '+') {
                  stack.push(left + right);
               }
               if (expression.charAt(i) == '-') {
                  stack.push(left - right);
               }
               if (expression.charAt(i) == '*') {
                  stack.push(left * right);

               }
            } else {
               stack.push(Character.getNumericValue(expression.charAt(i)));
            }
         }
      }
      System.out.println(stack.pop());
   }

}
