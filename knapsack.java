import java.util.*;
public class knapsack {
    public static int KnapSackBag(int value[],int wt[],int M,int n)
    {
        int K[][]=new int[n+1][M+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=M;j++)
            {
                if (i==0 || j==0){
                    K[i][j]=0;
                }
                else if (wt[i-1]<=j)
                {
                    K[i][j]=Math.max(value[i-1]+K[i-1][j-wt[i-1]] ,K[i-1][j]);
                    //   dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                }
                else{
                    K[i][j]=K[i-1][j];
                }
            }
            
        }
        return K[n][M];
        
    }
    public static void main(String[] args) {
        System.out.println("Enter Capacity of knapsack Bag");
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        System.out.println("Enter number of items");
        int n = sc.nextInt();
        int value[] = new int[n];
        int wt[] = new int[n];
        System.out.println("Enter wight of item ");
        for(int i=0;i<n;i++)
        {
  
            wt[i]=sc.nextInt();
        }
        System.out.println("enter price of item ");
        for(int i=0;i<n;i++){
           value[i]=sc.nextInt();
        }

        int max =KnapSackBag(value,wt,M,n);
        System.out.println("Maximum weight in bag is : " +max);
        sc.close();
    }
}
