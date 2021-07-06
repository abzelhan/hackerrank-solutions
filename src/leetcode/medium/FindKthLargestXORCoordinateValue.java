package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestXORCoordinateValue {

   public static int partition(int[] arr, int l, int r) {
      int pivotIndex = l;
      int pivot = arr[pivotIndex];

      int i = l + 1, j = r;

      while (i <= j) {
         while (i < arr.length && arr[i] < pivot) {
            i++;
         }
         while (j >= 0 && arr[j] > pivot) {
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

      int temp = arr[l];
      arr[l] = arr[j];
      arr[j] = temp;

      pivotIndex = j;

      return pivotIndex;
   }

   public static int findKthLargest(int[] nums, int k) {
      int l = 0;
      int r = nums.length - 1;
      int kElementIndex = nums.length - k;
      int kElement = -1;

      while (l <= r) {
         int pivotIndex = partition(nums, l, r);

         if (pivotIndex == kElementIndex) {
            kElement = nums[pivotIndex];
            break;
         }

         if (pivotIndex < kElementIndex) {
            l = pivotIndex + 1;
         } else if (pivotIndex > kElementIndex) {
            r = pivotIndex - 1;
         }
      }

      return kElement;
   }

   public static int kthLargestValue(int[][] arr, int kVal) {
      int[][] xorMatrix = new int[arr.length + 1][arr[0].length + 1];
      int xorArr[] = new int[arr.length * arr[0].length];
      int idx = 0;
      for (int i = 1; i < xorMatrix.length; i++) {
         for (int j = 1; j < xorMatrix[i].length; j++) {
            xorMatrix[i][j] = arr[i - 1][j - 1]
                ^ xorMatrix[i - 1][j - 1]
                ^ xorMatrix[i - 1][j]
                ^ xorMatrix[i][j - 1];

            xorArr[idx++] = xorMatrix[i][j];
         }
      }
      return findKthLargest(xorArr, kVal);
   }

   public static void main(String[] args) {

      int[][] arr = {
          {5, 2},
          {1, 6},
      };

      System.out.println(kthLargestValue(arr, 3));
   }

}
