package leetcode.hard;

import java.util.Map.Entry;
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

   static TreeMap<Integer, Integer> map;

   public static ListNode mergeKLists(ListNode[] lists) {
      for (int i = 0; i < lists.length; i++) {
         ListNode node = lists[i];

         while (node != null) {
            int val = node.val;
            Integer counter = 1;
            if (map.containsKey(val)) {
               counter = map.get(val);
               map.put(val, ++counter);
            } else {
               map.put(val, counter);
            }
            node = node.next;
         }
      }

      ListNode first = null;

      for (Entry<Integer, Integer> entry : map.entrySet()) {
         for (int i = 0; i < entry.getValue(); i++) {
            if (first == null) {
               first = new ListNode();
               first.val = entry.getKey();
               continue;
            }

            ListNode current = first;
            while (current.next != null) {
               current = current.next;
            }
            current.next = new ListNode(entry.getKey());
         }
      }

      return first;
   }

   public static void main(String[] args) {
      map = new TreeMap<>(Integer::compareTo);
      ListNode[] listNodes = new ListNode[3];
      listNodes[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
      listNodes[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
      listNodes[2] = new ListNode(2, new ListNode(6));

      ListNode listNode = mergeKLists(listNodes);

      System.out.println(listNode);
   }

}
