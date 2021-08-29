package leetcode.medium.graph;

public class FindTheTownJudge {

   public int findJudge(int n, int[][] trust) {
      short[] verticesCount = new short[n + 1];



      for (int i = 0; i < trust.length; i++) {
         verticesCount[trust[i][1]]++;
         verticesCount[trust[i][0]]--;
      }

      for (int i = 0; i < verticesCount.length; i++) {
         if (verticesCount[i] == n - 1) {
            return i;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{{1,3},{2,3}, {3,1}}));
   }

}
