
/*
    PART A: Implement Quick Sort using divide and conquer strategy. Give more
        than 500 inputs for best and for worst case scenario, and compare the time taken.
    PART B: Write a function to demonstrate Mutation of a chromosome representing
        solution of Traveling Salesperson Problem (TSP)
*/
import java.util.*;

// Harshada Borse
public class Que3 {

    public static int calculateFitness(int[] chromosome, int[][] distMat) {
        int fitness = 0;
        for (int i = 0; i < chromosome.length - 1; i++) {
            fitness += distMat[chromosome[i]][chromosome[i + 1]]; // adding distance between two cities
        }

        fitness += distMat[chromosome[chromosome.length - 1]][chromosome[0]]; // adding distance from last city to first
                                                                              // city
        return fitness;
    }

    public static int[] mutation(int[] chromosome) {
        Random rnd = new Random();
        int n = chromosome.length;

        int[] mutatedChro = chromosome.clone();
        int ind1 = rnd.nextInt(n);
        int ind2 = rnd.nextInt(n);

        while (ind1 == ind2) {
            ind2 = rnd.nextInt(n);
        }

        int temp = mutatedChro[ind1];
        mutatedChro[ind1] = mutatedChro[ind2];
        mutatedChro[ind2] = temp;

        return mutatedChro;
    }

    public static void main(String args[]) {
        // refer Que1 for part A
        // Best case scenario: sorted array
        // worst case scenario: reverse sorted array

        /*
         * 1. Mutation
         * Purpose: Introduces diversity into the population by making small random
         * changes to an individual (chromosome).
         * When it's applied: It is applied to individual chromosomes, usually with a
         * low probability (mutation rate).
         * What it does: Alters one or more genes in a chromosome to create a slightly
         * modified version of the original.
         * How it helps: Prevents the algorithm from getting stuck in local optima and
         * helps explore the search space more broadly.
         * Example in TSP:
         * Given a chromosome (path) [0, 1, 2, 3, 4], mutation could randomly swap two
         * cities, resulting in [0, 3, 2, 1, 4].
         */

        // Example of mutation for given sample TSP
        // Example distance matrix
        int[][] distMat = {
                { Integer.MAX_VALUE, 10, 15, 20 },
                { 10, Integer.MAX_VALUE, 5, 25 },
                { 15, 5, Integer.MAX_VALUE, 30 },
                { 20, 25, 30, Integer.MAX_VALUE }
        };

        System.out.println("-----------------Mutation in TSP-----------------");
        int[] chromosome = { 0, 1, 2, 3 };
        System.out.println("Original chromosome: ");
        for (int city : chromosome) {
            System.out.print(city + " ");
        }
        int fitness = calculateFitness(chromosome, distMat);
        System.out.println("Total Distance (Fitness): " + fitness);

        int[] mutatedChro = mutation(chromosome);
        System.out.println("\nMutated chromosome: ");
        for (int city : mutatedChro) {
            System.out.print(city + " ");
        }
        int mutatedFitness = calculateFitness(mutatedChro, distMat);
        System.out.println("Total Distance (Fitness): " + mutatedFitness);

        System.out.println("----------------------------------------------------");
        System.out.println("!! Thank You !! \n Have a nice day");
        System.out.println("----------------------------------------------------");

    }
}
