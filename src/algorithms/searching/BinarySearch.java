package algorithms.searching;

public class BinarySearch {

   public static int search(int[] arr, int key) {
      int left = 0, right = arr.length - 1;

      while (left <= right) {
         int mid = (left + right) / 2;


         if (arr[mid] == key) {
            return mid;
         }

         if (arr[mid] < key) {
            left = mid + 1;
         } else {
            right = mid - 1;
         }

      }

      return -1;
   }

   public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4};
      System.out.println(search(arr, 5));
   }

}
