
/*
 *  Implementsolution to 0/1 Knapsack using Dynamic Programming algorithm.
 */
import java.util.*;

// Harshada Borse
public class Que5 {

    public static int solveUsingMemoization(int[] weight, int[] profit, int capacity, int index, int[][] dp) {
        // base case
        if (index == 0 || capacity == 0) {
            if (weight[0] <= capacity)
                return profit[0];
            else
                return 0;
        }

        if (dp[index][capacity] != -1)
            return dp[index][capacity];

        int include = 0;
        if (weight[index] <= capacity)
            // as it get include in ans therefore capacity get reduced by included weight
            include = profit[index] + solveUsingMemoization(weight, profit, capacity - weight[index], index - 1, dp);

        // as it not included therefore capacity remains same
        int exclude = solveUsingMemoization(weight, profit, capacity, index - 1, dp);

        dp[index][capacity] = Math.max(include, exclude);
        return dp[index][capacity];
    }

    public static int solveUsingTabulation(int[] weight, int[] profit, int capacity, int n) {
        int[][] dp = new int[n][capacity + 1];

        // Base case
        for (int w = weight[0]; w <= capacity; w++) {
            if (weight[0] <= w)
                dp[0][w] = profit[0];
            else
                dp[0][w] = 0;
        }

        // Fill the DP table for other items
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= capacity; w++) {
                int include = 0;
                // If the current item can be included
                if (weight[i] <= w)
                    include = profit[i] + dp[i - 1][w - weight[i]];

                // Exclude the current item
                int exclude = dp[i - 1][w];

                dp[i][w] = Math.max(include, exclude);
            }
        }
        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("\t ***** 0/1 Knapsack Problem using DP *****\t");
        System.out.println("-------------------------------------------------------");

        System.out.print("Enter the size of weight and profit array : ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter the weight : ");
        System.out.print("Weight : ");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter the profit : ");
        System.out.print("profit : ");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter the capacity of bag : ");
        int capacity = sc.nextInt();

        boolean x = true;
        while (x) {
            System.out.println("------------------------------------------");
            System.out.println("Choices Avaliable :");
            System.out.println(
                    "1. Solve Using Memoization\n2. Solve Using Tabulation\n3. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            System.out.println("------------------------------------------");

            switch (choice) {
                case 1:
                    int[][] dp = new int[n][capacity + 1];
                    // initialize all to -1
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j <= capacity; j++) {
                            dp[i][j] = -1;
                        }
                    }

                    int ans2 = solveUsingMemoization(weight, profit, capacity, n - 1, dp);
                    System.out.println("Max Profit : " + ans2);
                    System.out.println("------------------------------------------");
                    break;

                case 2:
                    int ans3 = solveUsingTabulation(weight, profit, capacity, n);
                    System.out.println("Max Profit : " + ans3);
                    System.out.println("------------------------------------------");
                    break;

                case 3:
                    System.out.println("Thank you for responding !!");
                    System.out.println("Have a nice day !!");
                    x = false;
                    System.out.println("------------------------------------------------------");
                    break;

                default:
                    System.out.println("Please, enter the correct choice.");
                    System.out.println("------------------------------------------------------");
                    break;
            }
        }
    }
}
