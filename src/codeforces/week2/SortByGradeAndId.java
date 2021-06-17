package codeforces.week2;

import java.util.Arrays;
import java.util.Scanner;

public class SortByGradeAndId {

   private static class Student implements Comparable<Student> {

      int id;
      int grade;

      Student(int id, int grade) {
         this.id = id;
         this.grade = grade;
      }

      @Override
      public String toString() {
         return "Student{" +
             "id=" + id +
             ", grade=" + grade +
             '}';
      }

      @Override
      public int compareTo(Student that) {
         if (this.grade < that.grade) {
            return -1;
         } else if (this.grade > that.grade) {
            return 1;
         } else if (this.id < that.id) {
            return 1;
         } else if (this.id > that.id) {
            return -1;
         }
         return 0;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int n = scanner.nextInt();

      Student[] students = new Student[n];
      for (int i = 0; i < n; i++) {
         students[i] = new Student(scanner.nextInt(), scanner.nextInt());
      }

      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0; j--) {
            if (students[j].compareTo(students[j - 1]) > 0) {
               Student temp = students[j];
               students[j] = students[j - 1];
               students[j - 1] = temp;
            }
         }
      }

      for (int i = 0; i < n; i++) {
         System.out.print(students[i].id + " " + students[i].grade);
         System.out.println();
      }
   }

}
