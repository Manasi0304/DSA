//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    // Your code goes here
	    
        int sr = 0, er = n - 1;
        int sc = 0, ec = m - 1;
        int count = 0; 

        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                count++;
                if (count == k) return a[sr][j];
            }
            sr++; 
            for (int i = sr; i <= er; i++) {
                count++;
                if (count == k) return a[i][ec];
            }
            ec--; 
            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    count++;
                    if (count == k) return a[er][j];
                }
                er--; 
            }
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    count++;
                    if (count == k) return a[i][sc];
                }
                sc++; 
            }
        }
        return -1; 


	}
	
}