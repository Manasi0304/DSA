import java.util.*;

/* 
PART A: Implement QuickSort using divide and conquer strategy.
PART B: Compare its time required wrt Merge sort OR Randomized Quick Sort
*/

// Harshada Borse
public class Que2 {
    // refer part A from Que1 😊
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, p - 1);
            randomizedQuickSort(arr, p + 1, high);
        }
    }

    public static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);
        swap(arr, randomIndex, high);
        return partition(arr, low, high);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    public static void main(String[] args) {
        System.out.println("------------------- Randomized Quick Sort -------------------");
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Original array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Sorting the array
        randomizedQuickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println("----------------------------------------------------");
        System.out.println("!! Thank You !! \n Have a nice day");
        System.out.println("----------------------------------------------------");
    }
}
