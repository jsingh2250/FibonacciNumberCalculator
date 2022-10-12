import java.util.ArrayList;

/** This class can be used to calculate the nth number in the Fibonacci Sequence.
 * 
 * @author Jaskaran Singh
 */
public class FibonacciNumber {
    // An array list for storing numbers in the Fibonacci Sequence to allow for quicker calculation of the nth Fibonacci number.
    private static ArrayList<Integer> fibonacciSequence = new ArrayList<>();
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
        // Add the number to the array list if it hasn't already been stored.
        if ((n - 2) >= fibonacciSequence.size()) {
            // Recursively calculate and store the nth Fibonacci number.
            fibonacciSequence.add(getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2));
        }

        // Return the stored specified nth number in the Fibonacci Sequence.
        return fibonacciSequence.get(n - 2);
    }
}