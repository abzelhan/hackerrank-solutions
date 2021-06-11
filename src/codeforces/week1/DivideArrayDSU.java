package codeforces.week1;

import java.util.Scanner;

public class DivideArrayDSU {

   static class DSU {

      int parent[];
      int rank[];
      long sum[];

      public DSU(int n) {
         parent = new int[n];
         rank = new int[n];
         sum = new long[n];
         for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            sum[i] = 0;
         }
      }

      public int findSet(int a) {
         if (a == parent[a]) {
            return a;
         }

         parent[a] = findSet(parent[a]);
         return parent[a];
      }

      public void unionSet(int a, int b) {
         a = findSet(a);
         b = findSet(b);

         if (a != b) {
            if (rank[a] < rank[b]) {
               int temp = a;
               a = b;
               b = temp;
            }
            parent[b] = a;
            sum[a] += sum[b];
            if (rank[a] == rank[b]) {
               rank[a]++;
            }
         }
      }

      public void addSum(int index, long add) {
         sum[index] += add;
      }

      public long getSum(int index) {
         return sum[findSet(index)];
      }

   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long[] numbers = new long[n];
      int[] indexes = new int[n];
      boolean isValid[] = new boolean[n];
      for (int i = 0; i < n; i++) {
         numbers[i] = scanner.nextLong();
         isValid[i] = false;
      }

      for (int i = 0; i < n; i++) {
         indexes[i] = scanner.nextInt() - 1;
      }
      long sum[] = new long[n];
      DSU dsu = new DSU(n);
      long curMaxSum = 0;

      for (int i = n - 1; i >= 0; i--) {
         sum[i] = curMaxSum;
         isValid[indexes[i]] = true;
         dsu.addSum(indexes[i], numbers[indexes[i]]);
         if (indexes[i] > 0 && isValid[indexes[i] - 1]) {
            dsu.unionSet(indexes[i], indexes[i] - 1);
         }
         if (indexes[i] + 1 < n && isValid[indexes[i] + 1]) {
            dsu.unionSet(indexes[i], indexes[i] + 1);
         }
         curMaxSum = Math.max(curMaxSum, dsu.getSum(indexes[i]));
      }

      for (int i = 0; i < n; i++) {
         System.out.println(sum[i]);
      }
   }

}
