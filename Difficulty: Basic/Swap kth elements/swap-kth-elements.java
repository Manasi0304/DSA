//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // Consume the newline
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputs) {
                arr.add(Integer.parseInt(s));
            }
            Solution ob = new Solution();
            ob.swapKth(arr, k);
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public void swapKth(List<Integer> arr, int k) {
        // code here
        int n = arr.size();
        
        
        int start = k - 1;
        int end = n - k;

        if (start != end) {
            
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
        }
    }
}
