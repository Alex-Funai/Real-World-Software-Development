// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

/* Bank Transaction Analyzer (Simple Version)
 * Parses as CSV file and returns it as a list for calculating double values.
 * Format of CSV should be, DD-MM-YYYY, [±TRANSACTION AMOUNT], [TRANSACTION COMPANY]
 * Note: Uses comma as the delimiter for establishing columns -- don't include brackets.
 */






package src.main.java.bankstatementanalyzer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

public class BankStatementAnalyzer_Simple {

    // [2.1] Setting a file path to a private variable RESOURCES.
    private static final String RESOURCES = "App/src/main/resources/";

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
