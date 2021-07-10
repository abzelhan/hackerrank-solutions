package leetcode.easy;

public class SlowestKey {

   public char slowestKey(int[] releaseTimes, String keysPressed) {
      int maxDuration;
      char slowestKey;
      maxDuration = releaseTimes[0];
      slowestKey = keysPressed.charAt(0);
      for (int i = 1; i < keysPressed.length(); i++) {
         int duration = releaseTimes[i] - releaseTimes[i - 1];

         if (duration > maxDuration) {
            maxDuration = duration;
            slowestKey = keysPressed.charAt(i);
         } else if (duration == maxDuration && slowestKey < keysPressed.charAt(i)) {
            slowestKey = keysPressed.charAt(i);
         }
      }

      return slowestKey;
   }

   public static void main(String[] args) {
      System.out.println(new SlowestKey().slowestKey(new int[]{12,23,36,46,62}, "spuda"));
   }

}
