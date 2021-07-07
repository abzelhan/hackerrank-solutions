package leetcode.easy;

public class ParkingSystem {

   int big;
   int medium;
   int small;

   public ParkingSystem(int big, int medium, int small) {
      this.big = big;
      this.medium = medium;
      this.small = small;
   }

   public boolean addCar(int carType) {
      if (carType == 3) {
         return small-- > 0;
      } else if (carType == 2) {
         return medium-- > 0;
      }

      return big-- > 0;
   }

}
