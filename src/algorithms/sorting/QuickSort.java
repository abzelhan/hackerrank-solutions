package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

   public static Random random = new Random();


   public static void quick(int[] arr, int l, int r) {
      if (l >= r) {
         return;
      }
      int pivotIndex = l + random.nextInt(r - l);
      int pivot = arr[pivotIndex];
      int i = l, j = r;
      while (i <= j) {

         //move to right side
         while (arr[i] < pivot) {
            i++;
         }
         //move to left
         while (arr[j] > pivot) {
            j--;
         }

         if (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
         }
      }

      if (l < j) {
         quick(arr, l, j);
      }
      if (i < r) {
         quick(arr, i, r);
      }
   }

   public static void main(String[] args) {

      int arr[] = {5, 4, 3, 2, 1};

      quick(arr, 0, 4);

      System.out.println(Arrays.toString(arr));

   }

}
