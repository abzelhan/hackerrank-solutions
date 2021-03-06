package leetcode.medium;


import java.util.Arrays;

public class KthLargestElementInArray {

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

   public static void main(String[] args) {
      int[] arr = {5, 4, 3, 2, 1, 8, 7, 6};
      int k = 2;

      System.out.println(findKthLargest(arr, k));
      System.out.println(Arrays.toString(arr));
   }

}
