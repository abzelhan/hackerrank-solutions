package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {

   private static class ProductOfNumbers {

      private List<Integer> prefixProduct;

      public ProductOfNumbers() {
         prefixProduct = new ArrayList<>();
      }

      public void add(int num) {
         if (prefixProduct.isEmpty()) {
            prefixProduct.add(num);
         } else {
            if (num == 0) {

               for (int i = prefixProduct.size() - 1; i >= 0; i--) {
                  if (prefixProduct.get(i) == 0) {
                     break;
                  }

                  prefixProduct.set(i, 0);
               }
               prefixProduct.add(num);
            } else {
               if (prefixProduct.get(prefixProduct.size() - 1) != 0) {
                  prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
               } else {
                  prefixProduct.add(num);
               }
            }
         }
      }

      public int getProduct(int k) {
         if (prefixProduct.get(prefixProduct.size() - k) == 0) {
            return 0;
         }
         if (prefixProduct.size() - 1 - k >= 0) {
            if (prefixProduct.get(prefixProduct.size() - 1 - k) == 0) {
               return prefixProduct.get(prefixProduct.size() - 1);
            }
            return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct
                .get(prefixProduct.size() - 1 - k);
         }

         return prefixProduct.get(prefixProduct.size() - 1);
      }
   }

   public static void main(String[] args) {
      ProductOfNumbers productOfNumbers = new ProductOfNumbers();

      productOfNumbers.add(1);

      System.out.println(productOfNumbers.getProduct(1));
      System.out.println(productOfNumbers.getProduct(1));
      System.out.println(productOfNumbers.getProduct(1));
      productOfNumbers.add(7);
      productOfNumbers.add(6);
      productOfNumbers.add(7);
      System.out.println(productOfNumbers.getProduct(2));

   }

}
