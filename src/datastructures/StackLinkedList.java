package datastructures;

public class StackLinkedList {

   private class Node {

      private int value;
      private Node next;
   }

   private Node first;

   public void push(int num) {
      Node node = new Node();
      node.value = num;

      if (!isEmpty()) {
         node.next = first;
      }
      first = node;
   }

   public int pop() {
      if (!isEmpty()) {
         int val = first.value;
         first = first.next;
         return val;
      }
      return -1;
   }

   public boolean isEmpty() {
      return first == null;
   }

   public static void main(String[] args) {
      StackLinkedList stackLinkedList = new StackLinkedList();
      stackLinkedList.push(1);
      stackLinkedList.push(2);
      stackLinkedList.push(3);
      stackLinkedList.push(4);
      stackLinkedList.push(5);
      System.out.println(stackLinkedList.pop());
      System.out.println(stackLinkedList.pop());
      System.out.println(stackLinkedList.pop());
      System.out.println(stackLinkedList.pop());
      System.out.println(stackLinkedList.pop());
      System.out.println(stackLinkedList.pop());
      System.out.println(stackLinkedList.pop());
   }

}
