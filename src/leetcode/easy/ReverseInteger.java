package leetcode.easy;

public class ReverseInteger {

   public int reverse(int x) {
      int res = 0;
      boolean isNegative = x < 0;

      if(isNegative) {
         x*=-1;
      }

      while(x > 0) {
         int remainder = x % 10;
         x /=10;//964632435
         if ((long)res * 10 > Integer.MAX_VALUE) {
            return 0;
         }

         res*=10;
         res += remainder;
      }

      return isNegative ? res * -1 : res;
   }

   public static void main(String[] args) {
      int reverse = new ReverseInteger().reverse(123);
      System.out.println(reverse);
   }

}
