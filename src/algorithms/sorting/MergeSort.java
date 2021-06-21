package algorithms.sorting;

import java.util.Scanner;

public class MergeSort {

   public static void sort(int a[], int aux[], int left, int right) {
      if (left >= right) {
         return;
      }
      int mid = (left + right) / 2;
      sort(a, aux, left, mid);
      sort(a, aux, mid + 1, right);
      merge(a, aux, left, mid, right);
   }

   public static void merge(int a[], int aux[], int left, int mid, int right) {
      for (int i = left; i <= right; i++) {
         aux[i] = a[i];
      }

      int i = left;
      int j = mid + 1;
      for (int k = left; k <= right; k++) {
         if (i > mid) {
            a[k] = aux[j++];
         } else if (j > right) {
            a[k] = aux[i++];
         } else if (aux[j] < aux[i]) {
            a[k] = aux[j++];
         } else {
            a[k] = aux[i++];
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] arr = new int[n];
      int[] aux = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }

      sort(arr, aux, 0, n-1);

      for (int i = 0; i < n; i++) {
         System.out.print(arr[i]+ " ");
      }

   }

}
