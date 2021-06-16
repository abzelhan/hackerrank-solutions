package codeforces.week1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Tennis {

   private static class Queue {

      private class Node {

         private int item;
         private Node next;
      }

      private Node first, last;

      public boolean isEmpty() {
         return first == null;
      }

      public void enqueue(int item) {
         Node oldLast = last;
         last = new Node();
         last.item = item;
         last.next = null;
         if (isEmpty()) {
            first = last;
         } else {
            oldLast.next = last;
         }
      }

      public int dequeue() {
         int item = first.item;
         first = first.next;
         if (isEmpty()) {
            last = null;
         }

         return item;
      }

   }

   public static void main(String[] args) {
      ArrayDeque deque = new ArrayDeque<Integer>();

      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long k = scanner.nextLong();

//      k = k <= n ? n : k % n;

      int[] winCounters = new int[n];

      for (int i = 0; i < n; i++) {
         deque.add(scanner.nextInt());
      }

      for (int i = 0; i < n * n; i++) {
         int first = (int) deque.pop();
         int second = (int) deque.pop();

         int winner = Math.max(first, second);
         int loser = Math.min(first, second);

         winCounters[winner - 1]++;
         if (winCounters[winner - 1] == k) {
            System.out.println(winner);
            return;
         }
         deque.addFirst(winner);
         deque.addLast(loser);
      }

      int max = winCounters[0];
      int pos = 0;
      for (int i = 1; i < winCounters.length; i++) {
         if (winCounters[i] > max) {
            max = winCounters[i];
            pos = i;
         }
      }

      System.out.println(pos + 1);
   }

}
