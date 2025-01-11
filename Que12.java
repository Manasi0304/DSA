
/* Implement multithreaded matrix multiplication. And compare the time taken with sequential
   matrix multiplication. */

import java.util.*;

// Harshada Borse
class threadedMatMul extends Thread {
    int row;
    int col;
    int[][] matA;
    int[][] matB;
    int[][] result;

    public threadedMatMul(int row, int col, int[][] matA, int[][] matB, int[][] result) {
        this.row = row;
        this.col = col;
        this.matA = matA;
        this.matB = matB;
        this.result = result;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < matB.length; i++) {
            sum += matA[row][i] * matB[i][col];
        }

        result[row][col] = sum;
    }
}

public class Que12 {
    public static void sequencialMatMul(int[][] matA, int[][] matB, int[][] result) {
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matB[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matB.length; k++) {
                    sum += matA[i][k] * matB[k][j];
                }
                result[i][j] = sum;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("*** Matrix Multiplication (Multi-Threaded and Sequencial comparison ***");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.print("Enter the number of rows for matrix A: ");
        int rowA = sc.nextInt();
        System.out.print("Enter the number of columns for matrix A: ");
        int colA = sc.nextInt();
        System.out.print("Enter the number of rows for matrix B: ");
        int rowB = sc.nextInt();
        System.out.print("Enter the number of columns for matrix B: ");
        int colB = sc.nextInt();

        if (colA != rowB) {
            System.out.println("Matrix multiplication not possible");
            return;
        }

        int[][] matA = new int[rowA][colA];
        int[][] matB = new int[rowB][colB];
        int[][] result = new int[rowA][colB];

        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                matA[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the elements of matrix B:");
        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < colB; j++) {
                matB[i][j] = sc.nextInt();
            }
        }

        // Multi-threaded matrix multiplication
        long startTThread = System.nanoTime();
        Thread[][] threads = new Thread[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                threads[i][j] = new threadedMatMul(i, j, matA, matB, result);
                threads[i][j].start();
            }
        }

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        long endTThread = System.nanoTime();

        System.out.println("Result of multi-threaded matrix multiplication:");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(
                "Time taken to run multi-threaded matrix multiplication: " + (endTThread - startTThread) + " ns");

        // Sequencial matrix multiplication
        long startTSeq = System.nanoTime();
        sequencialMatMul(matA, matB, result);
        long endTSeq = System.nanoTime();
        System.out.println("Result of Sequencial matrix multiplication:");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Time taken to run sequencial matrix multiplication: " + (endTSeq - startTSeq) + " ns");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" !! Thank You !! \n Have a nice day");
        System.out.println("--------------------------------------------------------------------------------");
    }
}