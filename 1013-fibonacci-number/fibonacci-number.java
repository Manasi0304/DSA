class Solution {
    public int fib(int n) {
        int last=1;
        int slast=0;
        int cur;
        if(n==0)return 0;
        for(int i=2;i<=n;i++){
            cur=slast+last;
            slast=last;
            last=cur;
        }
        return last;
    }
}