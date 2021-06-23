package leetcode.easy;

public class MergeTwoSortedLinkedLists {

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

   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
      ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
      ListNode listNode2 = new ListNode(2, new ListNode(4, new ListNode(6, null)));
      ListNode result = mergeTwoLists(listNode1, listNode2);
      System.out.println();
   }

}
