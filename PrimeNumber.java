import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check if it's prime: ");
        int n = sc.nextInt();

        int flag = 1; // Assume the number is prime

        if (n <= 1) {
            flag = 0; 
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    flag = 0; 
                    break;
                }
            }
        }

        // Print the result
        if (flag == 1) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }

        sc.close(); 
    }
}
