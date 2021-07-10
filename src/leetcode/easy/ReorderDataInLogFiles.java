package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorderDataInLogFiles {

   private class Log implements Comparable<Log> {

      String id;
      String body;
      boolean isLetterLog;
      int index;

      Log(int index, String log) {
         int indexOfFirstSeparator = log.indexOf(' ');
         this.id = log.substring(0, indexOfFirstSeparator);
         this.body = log.substring(indexOfFirstSeparator).trim();
         this.index = index;
         this.isLetterLog = Character.isLetter(body.charAt(0));
      }

      @Override
      public int compareTo(Log that) {
         if (this.isLetterLog && !that.isLetterLog) {
            return -1;
         } else if (!this.isLetterLog && that.isLetterLog) {
            return 1;
         } else if (this.isLetterLog && that.isLetterLog) {
            int compareResult = this.body.compareTo(that.body);

            if (compareResult == 0) {
               compareResult = this.id.compareTo(that.id);
            }

            return compareResult;
         }

         return Integer.compare(this.index, that.index);
      }
   }

   public String[] reorderLogFiles(String[] logs) {
      PriorityQueue<Log> queue = new PriorityQueue<>();
      for (int i = 0; i < logs.length; i++) {
         queue.add(new Log(i, logs[i]));
      }

      String[] sortedLogs = new String[logs.length];

      for (int i = 0; i < logs.length; i++) {
         sortedLogs[i] = logs[queue.poll().index];
      }

      return sortedLogs;
   }

   public static void main(String[] args) {

      System.out.println(Arrays.toString(new ReorderDataInLogFiles().reorderLogFiles(new String[]{

          "1 n u", "r 527", "j 893", "6 14", "6 82"
      })));
   }

}
