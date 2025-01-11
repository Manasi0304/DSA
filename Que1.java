/* PART A: Implement Quicksort using divide and conquer strategy and display time for sorting
    for 500 values.
   PART B: Use same data for Mergesort and compare the time required with Quicksort.
*/

import java.util.*;

// Harshada Borse
public class Que1 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        int arrInd = low;
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[arrInd++];
        }

        arrInd = mid + 1;
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[arrInd++];
        }

        int ind1 = 0;
        int ind2 = 0;
        arrInd = low;
        while (ind1 < n1 && ind2 < n2) {
            if (arr1[ind1] <= arr2[ind2]) {
                arr[arrInd++] = arr1[ind1++];
            } else {
                arr[arrInd++] = arr2[ind2++];
            }
        }

        while (ind1 < n1) {
            arr[arrInd++] = arr1[ind1++];
        }

        while (ind2 < n2) {
            arr[arrInd++] = arr2[ind2++];
        }
    }

    public static void main(String[] args) {
        // first try on small input 😊
        int n = 500;
        int[] sample = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            sample[i] = random.nextInt(1000);
        }

        int[] mergeSample = sample.clone();
        System.out.println("------------ Using Quick sort --------------");
        for (int i : sample) {
            System.out.print(i + " ");
        }

        long startTime = System.nanoTime();
        quickSort(sample, 0, n - 1);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println();
        System.out.println("Sorting the array using Quick sort");
        for (int i : sample) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Time taken for Quick sort: " + timeElapsed + " ns");
        System.out.println("----------------------------------------------------");

        System.out.println("------------ Using Merge sort --------------");
        for (int i : mergeSample) {
            System.out.print(i + " ");
        }

        startTime = System.nanoTime();
        mergeSort(mergeSample, 0, n - 1);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println();
        System.out.println("Sorting the array using Merge sort");
        for (int i : mergeSample) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Time taken for Merge sort: " + timeElapsed + " ns");
        System.out.println("----------------------------------------------------");
        System.out.println("!! Thank You !! \n Have a nice day");
        System.out.println("----------------------------------------------------");
    }
}
