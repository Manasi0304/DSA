class Solution {
    int isPerfect(int N) {
        int temp = N;
        int sum = 0;

        while (temp != 0) {
            int ld = temp % 10;           
            sum += factorial(ld);
            temp /= 10;
        }

        return (sum == N) ? 1 : 0;
    }

    private static int factorial(int dig) {
        int facto = 1;
        for (int i = 2; i <= dig; i++) {   
            facto =facto* i;
        }
        return facto;
    }
}
