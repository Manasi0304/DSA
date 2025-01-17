//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            int arr[] = new int[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> list = obj.getAlternates(arr);
            for (int i : list) System.out.print(i + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    // function to print alternate elements of an array
    public ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
         ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i += 2) {
            result.add(arr[i]);
        }
        
        return result;
    }
}