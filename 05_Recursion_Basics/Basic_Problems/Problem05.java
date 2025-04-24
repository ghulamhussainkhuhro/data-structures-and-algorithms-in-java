package Basic_Problems;

public class Problem05 {

    // Recursive method to calculate Fibonacci number
    public static long fib(int n) {
        if (n == 0) return 0;   // Base case: fib(0) = 0
        if (n == 1) return 1;   // Base case: fib(1) = 1
        return fib(n - 1) + fib(n - 2);  // Recursive case: fib(n) = fib(n-1) + fib(n-2)
    }

    // Method to print first n terms of Fibonacci sequence
    public static void printFibonacciTerms(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();  // Move to the next line after printing all terms
    }

    public static void main(String[] args) {
        int n = 5;  // Number of terms to print
        System.out.println("First " + n + " terms of Fibonacci sequence:");
        printFibonacciTerms(n);  // Call the method to print the first n terms
        
        System.out.println(fib(n));
    }
    
}
