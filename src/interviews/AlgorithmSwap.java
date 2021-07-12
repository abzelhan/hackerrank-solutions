package interviews;

import java.util.Arrays;
import java.util.LinkedList;

public class AlgorithmSwap {

   public static long sort(int[] arr, int[] aux, int l, int r) {
      if (l >= r) {
         return 0;
      }

      int mid = (l + r) / 2;
      long swaps = 0;

      swaps += sort(arr, aux, l, mid);
      swaps += sort(arr, aux, mid + 1, r);
      swaps += merge(arr, aux, l, mid, r);

      return swaps;
   }

   public static long merge(int[] arr, int[] aux, int l, int mid, int r) {
      for (int i = l; i <= r; i++) {
         aux[i] = arr[i];
      }

      int i = l, j = mid + 1;

      long swaps = 0;

      for (int k = l; k <= r; k++) {
         if (i > mid) {
            arr[k] = aux[j++];
         } else if (j > r) {
            arr[k] = aux[i++];
         } else if (aux[i] > aux[j]) {
            arr[k] = aux[j++];
            swaps += (mid + 1) - i;
         } else {
            arr[k] = aux[i++];
         }
      }

      return swaps;
   }

   public static long howManySwaps(int[] arr) {
      long counter = sort(arr, new int[arr.length], 0, arr.length - 1);
      System.out.println(Arrays.toString(arr));
      return counter;
   }

   public static void main(String[] args) {
      LinkedList<Integer>[] arr = new LinkedList[199];
      arr[0] = new LinkedList<>();
      arr[0].add(1);

      System.out.println(howManySwaps(new int[]{7, 1, 2}));

   }

}
