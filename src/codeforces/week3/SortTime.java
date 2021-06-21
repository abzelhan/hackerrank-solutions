package codeforces.week3;

import java.util.Scanner;

public class SortTime {

   public static class Time implements Comparable<Time> {

      int hour;
      int minute;
      int second;

      public Time(int hour, int minute, int second) {
         this.hour = hour;
         this.minute = minute;
         this.second = second;
      }

      @Override
      public String toString() {
         return hour + " " + minute + " " + second;
      }

      @Override
      public int compareTo(Time that) {
         if (this.hour < that.hour) {
            return -1;
         } else if (this.hour > that.hour) {
            return 1;
         } else {
            if (this.minute < that.minute) {
               return -1;
            } else if (this.minute > that.minute) {
               return 1;
            } else {
               if (this.second < that.second) {
                  return -1;
               } else if (this.second > that.second) {
                  return 1;
               } else {
                  return 0;
               }
            }
         }
      }
   }


   public static void sort(Time[] arr, Time[] aux, int left, int right) {
      if (left >= right) {
         return;
      }

      int mid = (left + right) / 2;

      sort(arr, aux, left, mid);
      sort(arr, aux, mid + 1, right);

      merge(arr, aux, left, mid, right);
   }

   public static void merge(Time[] arr, Time[] aux, int left, int mid, int right) {
      for (int i = left; i <= right; i++) {
         aux[i] = arr[i];
      }

      int i = left;
      int j = mid + 1;

      for (int k = left; k <= right; k++) {
         if(i > mid){
            arr[k] = aux[j++];
         } else if (j > right) {
            arr[k] = aux[i++];
         } else if(aux[j].compareTo(aux[i]) < 0) {
            arr[k] = aux[j++];
         } else {
            arr[k] = aux[i++];
         }
      }

   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      Time[] arr = new Time[n];
      Time[] aux = new Time[n];
      for (int i = 0; i < n; i++) {
         arr[i] = new Time(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
      }

      sort(arr, aux, 0, n - 1);

      for (int i = 0; i < n; i++) {
         System.out.println(arr[i]);
      }

   }

}
