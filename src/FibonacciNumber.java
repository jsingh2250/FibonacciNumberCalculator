/** This class can be used to calculate the nth number in the Fibonacci Sequence.
 * 
 * @author Jaskaran Singh
 */
public class FibonacciNumber {
    /**
     * Calculates the specified nth number in the Fibonacci Sequence. Returns the specified nth number in the Fibonacci Sequence.
     * 
     * @param n The specified number in the Fibonacci Sequence to return.
     * @return Returns the specified nth number in the Fibonacci Sequence.
     */
    public static int getNthFibonacciNumber(int n) throws Exception {
        // If the number is 0 or 1, return the number.
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursively calculate the nth Fibonacci number.
        return getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2);
    }
}