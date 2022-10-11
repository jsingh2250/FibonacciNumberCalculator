import java.util.ArrayList;
import java.util.Scanner;

/** This is a command-line tool used to calculate the user-specified nth number in the Fibonacci Sequence.
 * 
 * @author Jaskaran Singh
 */
public class FibonacciNumberCalculator {
    // Stores the text input cursor that will be used in this program.
    private static final String TEXT_INPUT_CURSOR = ">";

    /**
     * Prints the text with a new line before and after the text.
     * @param text The text to print.
     */
    private static void printLnTextLn(String text) {
        System.out.println();
        System.out.println(text);
    }

    /**
     * Prints a formatted version of the text input cursor to show the user where to type their input.
     * @param textInputCursor The text input cursor to print.
     */
    private static void printTextInputCursor(String textInputCursor) {
        System.out.println();
        System.out.print(textInputCursor + " ");
    }

    /**
    * Prints information about the specified exception and exits out of the program.
    * 
    * @param exception The exception to print information about.
    */
    public static void printExceptionInformationAndExit(Exception exception) {
        // Print information about the exception.
        System.out.println();
        exception.printStackTrace();
        System.out.println();

        // Exit out of the program.
        System.exit(0);
    }

    /**
     * Prints a message to the user to let them know that their input was invalid.
     * 
     */
    private static void printInvalidInputMessage() {
        printLnTextLn("Your input was invalid. Please try again.");
    }

    /**
     * Prompts the user to specify a number. Reads and returns the user-specified number.
     * 
     * @param scanner The scanner object used to get user-input.
     * @return Reads and returns the user-specified number.
     */
    public static Integer readUserSpecifiedNumber(Scanner scanner) {
        // Declare a variable that will store the user-specified number.
        // Initialize the variable to null to indicate that the user hasn't specified a valid number.
        Integer number = null;

        // Try to get the user-specified number until they specify a non-negative integer.
        while (number == null) {
            try {
                // Prompt the user to specify a non-negative integer.
                printLnTextLn("Please enter a non-negative integer.");
                printTextInputCursor(TEXT_INPUT_CURSOR);

                // Store the user-specified number.
                number = Integer.parseInt(scanner.next());

                // If the user didn't specify a non-negative integer, throw an exception.
                if (number < 0) {
                    throw new Exception();
                }

            } catch (Exception exception) {
                // Reset the stored number to null.
                number = null;

                // Print a message to the user to let them know that their input was invalid.
                printInvalidInputMessage();
            }
        }

        // Return the user-specified number.
        return number;
    }

    /**
     * Prints the elements in the specified array list with spaces between the elements.
     * 
     * @param arrayList The array list that contains the elements to print.
     */
    public static <E> void printArrayList(ArrayList<E> arrayList) {
        System.out.println();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }

    /**
    * Calculates how many seconds have passed between the specified start and end times. The specified start and end times should be in milliseconds. Returns the amount of seconds that have passed between the specified start and end times.
    * 
    * @param startTimeInMilliseconds The start time in milliseconds.
    * @param endTimeInMilliseconds The end time in milliseconds.
    * @return Returns the amount of seconds that have passed between the specified start and end times.
    */
    public static double calculateTimePassedInSeconds(long startTimeInMilliseconds, long endTimeInMilliseconds) {
        return ((endTimeInMilliseconds - startTimeInMilliseconds) / 1000.0);
    }

    /**
    * Returns the ordinal indicator for the specified number.
    * 
    * @param number The specified number to determine the ordinal indicator for.
    * @return Returns the ordinal indicator for the specified number.
    */
    public static String getOrdinalIndicator(int number) {
        switch (number) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    /**
     * Main method of this class.
     * 
     * @param args User-specified number.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Store the name of this program as a string.
        final String PROGRAM_NAME = "Fibonacci Number Calculator";

        // Store the valid commands the user can input as strings.
        final String RESTART_COMMAND = "restart";

        // Declare a variable to store whether the user wants to restart the program.
        boolean shouldRestartProgram = false;

        // Create a scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // Declare a variable to store user input.
        String userInput = null;

        // Declare a variable to store the user-specified number.
        Integer number = null;

        // Try to parse a non-negative integer from the command line argument.
        try {
            // Try to get the command line argument.
            userInput = args[0];

            // Try to parse a non-negative integer from the command line argument.
            number = Integer.parseInt(userInput);
            if (number < 0) {
                throw new Exception();
            }
        } catch (Exception exception) {
            // Reset the stored number to null.
            number = null;

            // Print a message to the user to let them know that their input was invalid.
            printInvalidInputMessage();
        }

        // Try to get the user-specified number until they specify a non-negative integer.
        if (number == null) {
            number = readUserSpecifiedNumber(scanner);
        }

        do {
            // Declare variables to store the start and end times of tasks.
            long startTimeInMilliseconds;
            long endTimeInMilliseconds;

            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();

            // Calculate the Fibonacci number.
            long fibonacciNumber = 0;

            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();

            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringArrayListCreation = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);

            // Tell the user that the task has been completed. Also tell the user how long it took to complete the task.
            System.out.println();
            System.out.printf("The %d%s number in the Fibonacci Sequence is %d.%n", number, getOrdinalIndicator(number),
                    fibonacciNumber);
            System.out.printf("It took %f seconds to calculate the number.",
                    timePassedInSecondsDuringArrayListCreation);
            System.out.println();

            // Ask the user if they want to restart the program.
            printLnTextLn("Would you like to restart the program?\n" + "Enter \"" + RESTART_COMMAND
                    + "\" to restart the program. Enter anything else to quit.");
            printTextInputCursor(TEXT_INPUT_CURSOR);
            userInput = scanner.next();

            // Determine and store whether the user wants to restart the program based on their input.
            shouldRestartProgram = (userInput.equals(RESTART_COMMAND) ? true : false);

            // If the user opted to restart the program, get the next non-negative number from them.
            if (shouldRestartProgram) {
                number = readUserSpecifiedNumber(scanner);
            }

            // If the user opted to restart the program, go back to the top of this loop.
        } while (shouldRestartProgram == true);

        // Close the scanner.
        scanner.close();

        // Print a farewell message.
        System.out.println();
        System.out.println("Thank you for using the " + PROGRAM_NAME + " program!\n" + "Goodbye.");
    }
}