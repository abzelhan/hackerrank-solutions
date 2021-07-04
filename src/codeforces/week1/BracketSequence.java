package codeforces.week1;

import java.util.Scanner;
import java.util.Stack;

public class BracketSequence {

   static class Pair {

      private char key;
      private int value;

      Pair(char key, int value) {
         this.key = key;
         this.value = value;
      }

      public char getKey() {
         return key;
      }


      public int getValue() {
         return value;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner("((()");
      String word = scanner.nextLine();

      int[] prefixSums = new int[word.length()];
      int prefixCounter = 0;
      for (int i = 0; i < word.length(); i++) {
         if (word.charAt(i) == '[' || word.charAt(i) == ']') {
            prefixCounter++;
         }
         prefixSums[i] = prefixCounter;
      }

      Stack<Pair> brackets = new Stack<>();
      int maxCounter = 0, startIndex = -1, length = 0;
      for (int i = 0; i < word.length(); i++) {
         if (word.charAt(i) == '[') {
            brackets.push(new Pair(']', i));
         } else if (word.charAt(i) == '(') {
            brackets.push(new Pair(')', i));
         } else {
            if (!brackets.isEmpty() && brackets.peek().getKey() == word.charAt(i)) {
               brackets.pop();

               int currentCounter = prefixSums[i];
               if (!brackets.isEmpty()) {
                  currentCounter -= prefixSums[brackets.peek().getValue()];
               }

               if (currentCounter >= maxCounter) {
                  maxCounter = currentCounter;
                  startIndex = brackets.isEmpty() ? 0 : brackets.peek().getValue() + 1;
                  length = i - (brackets.isEmpty() ? -1 : brackets.peek().getValue());
               }
            } else if (word.charAt(i) == ']') {
               brackets.push(new Pair('[', i));
            } else if (word.charAt(i) == ')') {
               brackets.push(new Pair('(', i));
            }
         }
      }
      System.out.println(maxCounter / 2);

      if (maxCounter != 0) {
         System.out.println(word.substring(startIndex, startIndex + length));
      }
   }

}
