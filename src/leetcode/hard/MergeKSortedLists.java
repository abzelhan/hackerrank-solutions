package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MergeKSortedLists {

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

   public static ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
         @Override
         public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
         }
      });

      for (ListNode node : lists) {
         while (node != null) {
            queue.add(node);
            node = node.next;
         }
      }

      ListNode head = new ListNode();
      ListNode node = head;
      while (!queue.isEmpty()) {
         ListNode sortedNode = queue.poll();
         sortedNode.next = null;
         node.next = sortedNode;
         node = node.next;
      }

      return head.next;
   }

   public static void main(String[] args) {
      ListNode[] listNodes = new ListNode[3];
      listNodes[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
      listNodes[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
      listNodes[2] = new ListNode(2, new ListNode(6));

      ListNode listNode = mergeKLists(listNodes);

   }

}
