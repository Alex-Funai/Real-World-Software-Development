// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

/* Bank Transaction Analyzer (Simple Version)
 * Parses as CSV file and returns it as a list for calculating double values.
 * Format of CSV should be, DD-MM-YYYY, [±TRANSACTION AMOUNT], [TRANSACTION COMPANY]
 * Note: Uses comma as the delimiter for establishing columns -- don't include brackets.
 */

/* The Kiss Principle -- When analyzing certain requested dependencies in a program request
 * you can start simple by listing them in a query. "KISS" is an acronym for "Keep-It-Short-Simple".
 * Initially answer the first solution in your query, and have the applications code in a single class.
 */

/* [Notes] - Final Variables:
 * Depending on the project Final keywords may be preferable to specify variables not being local and reassigned.
 */

/* [Notes] - Code Maintainability and Anti-Patterns:
 * 1. Code is simple to locate code responsible for particular features.
 * 2. Code is simple to understand what the code does.
 * 3. Code is simple to add or remove new features.
 * 4. Code provides good encapsulation. Implementation details should be hidden from a user of your code,
 *      so it's easier to understand and make changes.
 */

/* Query:
 * 1. What is the total profit and loss from a list of bank statements? Is it positive or negative?
 * 2. How many bank transactions are there in a particular month?
 * 3. What are their top-10 expenses?
 * 4. Which category does they spend most of their money on?
 *
 */

/* Process:
 * 1. Loading the CSV file passed as a command-line argument to the application.
 * 2. Path class represents a path in the filesystem.
 * 3. Files.readAllLines() to return a list of lines.
 * 4. Parsing the lines list by:
 *      a. Splitting them by split() with a "," as the delimiter/separator.
 *      b. Extracting the amount.
 *      c. Parsing the amount to a double.
 *
 * Complications:
 * 1. What if the file is empty?
 * 2. What if parsing the amount fails because the data was corrupted?
 * 3. What if a statement line has missing data?
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    // [2.1] Setting a file path to a private variable RESOURCES.
    private static final String RESOURCES = "src/main/resources/";

    // [2.1] Calculating the sum of all statements:
    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(RESOURCES + "ExampleStatements.csv");
        // Returns a list of lines for parsing.
        final List<String> lines = Files.readAllLines(path);
        double total = 0;

        // Enhanced For-Loop to iterate through the lines Array without need for indexing through the loop.
        for (final String line : lines) {
            // Create columns array, by splitting the lines by the specified "," delimiter in the CSV file.// Enhanced For-Loop to iterate through the lines Array without need for indexing through the loop.
            final String[] columns = line.split(",");
            // Returns a new double initialized to the value represented by the amount String.
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }
        System.out.println("The total for all transactions is " + total);

        // [2.2] Calculating the sum of January statements:
        total = 0;
        // Creates a formatter using the specified pattern; Ex: d MMM uuuu will format 2011-12-03 as '3 Dec 2011'
        final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Enhanced For-Loop to iterate through the lines Array without need for indexing through the loop.
        for (final String line : lines) {
            // Create columns array, by splitting the lines by the specified "," delimiter in the CSV file.// Enhanced For-Loop to iterate through the lines Array without need for indexing through the loop.
            final String[] columns = line.split(",");
            // Obtains an instance of LocalDate from a text string such as 2007-12-03.
            final LocalDate date = LocalDate.parse(columns[0], DATE_FORMATTER);
            // References value of month as an integer, which corresponds to the CSV format.
            if (date.getMonth() == Month.JANUARY) {
                // Returns a new double under the "amount" variable, and searches the preformatted csv in it's date column.
                final double amount = Double.parseDouble(columns[1]);
                // Adding and assigning the amount values to the total variable.
                total += amount;
            }
        }
        System.out.println("The total for al transactions in January is " + total);

    }
}
