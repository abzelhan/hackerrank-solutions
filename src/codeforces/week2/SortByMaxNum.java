package codeforces.week2;

import java.util.Scanner;

public class SortByMaxNum {

   static class Num implements Comparable<Num> {

      int num;
      int maxNum;

      Num(int num) {
         this.num = num;

         int max = 0;

         while (num != 0) {
            int remainder = num % 10;
            if (remainder > max) {
               max = remainder;
            }
            num /= 10;
         }

         maxNum = max;
      }

      @Override
      public int compareTo(Num that) {
         if (this.maxNum > that.maxNum) {
            return 1;
         }
         if (this.maxNum < that.maxNum) {
            return -1;
         }
         if (this.num > that.num) {
            return 1;
         }
         if (this.num < that.num) {
            return -1;
         }
         return 0;
      }
   }

   private static void exchange(Comparable arr[], int i, int j) {
      Comparable temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      Num[] nums = new Num[n];
      for (int i = 0; i < n; i++) {
         nums[i] = new Num(scanner.nextInt());
      }

      for (int i = 0; i < n; i++) {
         int min = i;
         for (int j = i + 1; j < n; j++) {
            if (nums[j].compareTo(nums[min]) < 0) {
               min = j;
            }
         }
         exchange(nums, i, min);
      }

      for (int i = 0; i < n; i++) {
         System.out.print(nums[i].num + " ");
      }
   }

}
