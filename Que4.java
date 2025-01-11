/* PART A : Implement Merge Sort using divide and conquer strategy. Note the time required 
    for best and worst case situations on large number of values.
   PART B: Write a function to demonstrate Crossover of two chromosome representing solution
    of Traveling Salesperson Problem (TSP)
*/

import java.util.*;

// Harshada Borse
public class Que4 {
   public static int[] crossover(int[] parent1, int[] parent2) {
      int n = parent1.length;
      int[] child = new int[n];
      boolean[] visited = new boolean[n];
      Arrays.fill(child, -1);
      Random rand = new Random();
      int start = rand.nextInt(n);
      int end = rand.nextInt(n);
      if (start > end) {
         int temp = start;
         start = end;
         end = temp;
      }
      for (int i = start; i <= end; i++) {
         child[i] = parent1[i];
         visited[parent1[i]] = true;
      }

      int k = 0;
      for (int i = 0; i < n; i++) {
         if (!visited[parent2[i]]) {
            while (child[k] != -1) {
               k++;
            }
            child[k] = parent2[i];
            visited[parent2[i]] = true;
         }
      }
      return child;
   }

   public static void main(String args[]) {
      // refer `Que1` for part A
      // Best case scenario: sorted array
      // Worst case scenario: reverse sorted array

      /*
       * 2. Crossover
       * Purpose: Combines genetic material from two parents to create new offspring.
       * When it's applied: It is applied to pairs of individuals (chromosomes) in the
       * population.
       * What it does: Combines genetic material from two parents to create new
       * offspring.
       * How it helps: Helps explore the search space by combining good solutions from
       * different individuals.
       * Example in TSP:
       * Given two parent chromosomes [0, 1, 2, 3, 4] and [4, 3, 2, 1, 0], crossover
       * could combine parts of both parents to create offspring [0, 3, 2, 1, 4].
       */

      // Example of crossover for given sample TSP
      int[] parent1 = { 0, 1, 2, 3, 4 };
      int[] parent2 = { 4, 3, 2, 1, 0 };
      System.out.println("Parent 1: ");
      for (int i : parent1) {
         System.out.print(i + " ");
      }

      System.out.println("\nParent 2: ");
      for (int i : parent2) {
         System.out.print(i + " ");
      }

      int[] offspring = crossover(parent1, parent2);
      System.out.println("\nOffspring: ");
      for (int i : offspring) {
         System.out.print(i + " ");
      }

      System.out.println();
      System.out.println("------------------------------------------------------");
      System.out.println(" !! Thank You !! \n Have a nice day");
      System.out.println("------------------------------------------------------");
   }
}
