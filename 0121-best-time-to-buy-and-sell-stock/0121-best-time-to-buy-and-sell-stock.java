class Solution {
    public int maxProfit(int[] prices) {
         int maxProfit = 0; // Initialize max profit to 0
        int minPrice = Integer.MAX_VALUE;
        int n=prices .length;
        for(int i=0;i<n;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                maxProfit=Math.max(maxProfit , prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
