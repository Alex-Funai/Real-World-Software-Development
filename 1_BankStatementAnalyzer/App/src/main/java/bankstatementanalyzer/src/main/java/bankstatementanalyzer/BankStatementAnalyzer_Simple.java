// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

package src.main.java.bankstatementanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

/**
 * This is a simple version that doesn't utilize all the other classes. It parses as CSV file and returns it
 * as a list for calculating double values. Format of CSV should be, DD-MM-YYYY, [±TRANSACTION AMOUNT],
 * [TRANSACTION COMPANY]. Comma is used as a delimitter/separator.
 *
 * <p>Bugs: could make some bugs by expanding this program.
 *
 * @author akfunai
 */
public class BankStatementAnalyzer_Simple {

    private static final String RESOURCES = "App/src/main/resources/";      // Sets the resources folder to
                                                                            // the string variable 'RESOURCES'.
    /**
     * Parses through a CSV file in the resources folder, and outputs
     * some random information about the data, and it's transactions.
     *
     * <p>Bugs: n/a
     *
     * @author akfunai
     */
    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(RESOURCES + "ExampleStatements.csv");      // Sets file path from the resources
                                                                                    // folder + parameter >> 'path'.

        final List<String> lines = Files.readAllLines(path);    // Creates a list of the files lines.

        double total = 0;       // Initializes double variable total
                                // to store transaction values.


        for (final String line : lines) {       // Enhanced for-loop to iterate through the lines array.

            final String[] columns = line.split(",");       // Creates array[] 'columns' by separating incoming
                                                                  // lines by using commas as delimitters.

            final double amount = Double.parseDouble(columns[1]);   // Creates double 'amount' variable to store
                                                                    // the transaction amounts from columns[1].
            total += amount;    // Increments amount to the same
                                // 'total' variable as loop iterates.
        }
        System.out.println("The total for all transactions is " + total);   // Prints out a statement that shows
                                                                            // the calculated total for transactions.
        /**
         * Embeded method for processing transactions specifically
         * of the month January.
         * @author akfunai
         *
         * @ccode TransactionsInJanuary[]
         */
        total = 0;  // Resetting variable 'total' value
                    // to zero for processing new results.

        final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");     // Date formatter using a specified pattern;
                                                                                                // Ex: dd-MM-yyyy >> 2011-12-03 >> 3 Dec 2011

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
