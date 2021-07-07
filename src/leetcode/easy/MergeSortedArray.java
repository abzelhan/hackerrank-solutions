package leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {

   public static void merge(int[] nums1, int m, int[] nums2, int n) {
      for (int k = m, l = 0; k < m + n; k++, l++) {
         nums1[k] = nums2[l];
      }

      int i = 0;
      int j = m;

      if (nums2.length > 0) {
         int[] aux = Arrays.copyOf(nums1, nums1.length);

         for (int k = 0; k < nums1.length; k++) {
            if (i > m - 1) {
               nums1[k] = aux[j++];
            } else if (j >= nums1.length) {
               nums1[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
               nums1[k] = aux[i++];
            } else {
               nums1[k] = aux[j++];
            }
         }
      }
   }

   public static void main(String[] args) {
      int[] nums1 = {2,0};
      merge(nums1, 1, new int[]{1}, 1);

      System.out.println(Arrays.toString(nums1));
   }

}
