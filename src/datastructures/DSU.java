package datastructures;

class UnionFindLinear {

   public int[] leader;

   public UnionFindLinear(int n) {
      leader = new int[n];

      for (int i = 0; i < n; i++) {
         leader[i] = i;
      }
   }

   public int find(int p) {
      return leader[p];
   }

   public void union(int p, int q) {
      int pLeader = leader[p];
      int qLeader = leader[q];

      for (int i = 0; i < leader.length; i++) {
         if (leader[i] == pLeader) {
            leader[i] = qLeader;
         }
      }
   }

}

public class DSU {

   public static void main(String[] args) {
      UnionFindLinear unionFindLinear = new UnionFindLinear(10);
      System.out.println(unionFindLinear.find(3));
      unionFindLinear.union(3,4);
      unionFindLinear.union(2,4);
      System.out.println(unionFindLinear.find(2));

      for (int i = 0; i < 10; i++) {
         System.out.print(unionFindLinear.find(i) + " ");
      }
   }

}
