package datastructures;

public class QueueLinkedList {

   private class Node {

      int item;
      Node next;
   }

   private Node first;
   private Node last;

   public void enqueue(int num) {
      Node oldLast = last;
      last = new Node();
      last.item = num;
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

   public boolean isEmpty() {
      return first == null;
   }

   public static void main(String[] args) {
      QueueLinkedList queueLinkedList = new QueueLinkedList();
      queueLinkedList.enqueue(1);
      queueLinkedList.enqueue(2);
      queueLinkedList.enqueue(3);
      queueLinkedList.enqueue(4);

      System.out.println(queueLinkedList.dequeue());
      System.out.println(queueLinkedList.dequeue());
      System.out.println(queueLinkedList.dequeue());
      System.out.println(queueLinkedList.dequeue());
      queueLinkedList.enqueue(1);

   }

}
