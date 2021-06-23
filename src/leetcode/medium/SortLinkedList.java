package leetcode.medium;

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

   public ListNode sortList(ListNode head) {
      if (head == null) {
         return head;
      }

      int size = 0;

      ListNode first = head;
      while (first != null) {
         size++;
         first = first.next;
      }

      return sort(head, 0, size - 1);
   }


   public ListNode sort(ListNode list, int left, int right) {
      if (list.next == null) {
         return list;
      }
      // 1 -> 2 -> 3 -> 4
      ListNode leftSide = new ListNode();
      ListNode node = leftSide;

      int mid = (left + right) / 2;

      for (int i = left; i <= mid; i++) {
         node.next = list;
         list = list.next;
         node = node.next;
      }

      node.next = null;
      leftSide = leftSide.next;

      ListNode rightSide = new ListNode();
      node = rightSide;

      for (int i = mid + 1; i <= right; i++) {
         node.next = list;
         list = list.next;
         node = node.next;
      }

      rightSide = rightSide.next;

      return merge(sort(leftSide, left, mid), sort(rightSide, mid + 1, right));
   }

   public ListNode merge(ListNode l1, ListNode l2) {
      ListNode head = new ListNode();
      ListNode node = head;

      while (l1 != null || l2 != null) {
         if (l1 == null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
         } else if (l2 == null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
         } else if (l2.val < l1.val) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
         } else {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
         }
      }

      return head.next;
   }

   public static void main(String[] args) {
      ListNode listNode = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4))));
      ListNode result = new SortLinkedList().sortList(listNode);

      while (result != null) {
         System.out.println(result.val);
         result = result.next;
      }
   }

}
