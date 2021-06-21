package leetcode.medium;

import java.util.Random;

public class SortLinkedList {

   public static class ListNode {

      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
         this.val = val;
      }

      ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
      }
   }

   public static ListNode sortList(ListNode head) {
      if (head == null) {
         return head;
      }

      int size = 0;

      ListNode first = head;
      while (first != null) {
         size++;
         first = first.next;
      }

      return sort(head, 0, size);
   }


   public static ListNode sort(ListNode node, int left, int right) {
      if (node.next == null) {
         return node;
      }
      int mid = (left + right) / 2;

      ListNode leftNode = null;
      ListNode l = leftNode;
      ListNode rightNode = null;
      ListNode r = rightNode;

      int i = left;
      int j = mid + 1;
      while (i < mid) {
         if (leftNode == null) {
            leftNode = new ListNode(node.val);
            l = leftNode;
         } else {
            l.next = new ListNode(node.val);
            l = l.next;
         }
         node = node.next;
         i++;
      }
      l = null;

      while (j <= right) {
         if (rightNode == null) {
            rightNode = new ListNode(node.val);
            r = rightNode;
         } else {
            r.next = new ListNode(node.val);
            r = r.next;
         }
         node = node.next;
         j++;
      }
      r = null;

      return merge(sort(leftNode, left, mid), sort(rightNode, mid, right));
   }

   public static ListNode merge(ListNode l1, ListNode l2) {
      ListNode first = null;
      ListNode node = null;
      while (l1 != null || l2 != null) {

         if (l1 == null) {
            //process l2
            if (first == null) {
               first = new ListNode(l2.val);
               node = first;
            } else {
               node.next = new ListNode(l2.val);
               node = node.next;
            }
            l2 = l2.next;
         } else if (l2 == null) {
            //process l1
            if (first == null) {
               first = new ListNode(l1.val);
               node = first;
            } else {
               node.next = new ListNode(l1.val);
               node = node.next;
            }
            l1 = l1.next;
         } else if (l1.val < l2.val) {
            //process l1
            if (first == null) {
               first = new ListNode(l1.val);
               node = first;
            } else {
               node.next = new ListNode(l1.val);
               node = node.next;
            }
            l1 = l1.next;
         } else {
            //process l2
            if (first == null) {
               first = new ListNode(l2.val);
               node = first;
            } else {
               node.next = new ListNode(l2.val);
               node = node.next;
            }
            l2 = l2.next;
         }
      }

      l1 = null;
      l2 = null;
      return first;
   }

   public static void main(String[] args) {
      ListNode listNode = new ListNode();
      ListNode l = listNode;
      Random r = new Random();
      for (int i = 0; i < 10000_000; i++) {
         l.next = new ListNode(r.nextInt());
         l = l.next;
      }

      ListNode result = sortList(listNode);

      while (result != null) {
         System.out.println(result.val);
         result = result.next;
      }
   }

}
