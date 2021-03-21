// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// Bank Statement CSV Parser

/* [Notes] God Class:
 * Avoid delegating all features into a single class "God Class", because this will strain efforts in updating the
 * program and adding/removing new features.
 */

/* [Notes] Single Responsibility Principle (SRP):
 * 1. A class has responsibility over a single functionality.
 * 2. There is only one single reason for a class to change.
 *
 * SRP for this program:
 * 1. Reading input.
 * 2. Parsing the input in a given format.
 * 3. Processing the result.
 * 4. Reporting a summary of the result.
 */


package BankStatementAnalyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


// [2-3] Extracting the parsing logic in a separate class:
public class BankStatementCsvParser implements Interface_BankStatementParser {

    //BankStatementAnalyzer.Interface_BankStatementCsvParser {    // Decouple initial CSV parser to new full spectrum file-type parser.

    // Translate the CSV date format to be read into the DATE_PATTERN variable..
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern ("dd-MM-yyyy");

    // Method to specify the line as a parameter, for where the document parsing should begin [Default = start = 0].
    public BankTransaction parseFrom (final String line) {
        // Initializes an array named columns, and specifies "," as a delimiter/separator.
        final String[] columns = line.split(",");

        //  Indexing columns, and translating each section into the appropriate data-type..
        final LocalDate date = LocalDate.parse (columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble (columns[1]);
        final String description = columns[2];

        // Return all the values parsed through the BankTransaction variable. Declared new for anticipation of reptition that will occur. Many BankTransactions will need to run.
        return new BankTransaction(date, amount, description);
    }

    public List <BankTransaction> parseLinesFrom (final List <String> lines) {
        return lines.stream().map (this :: parseFrom).collect (toList());
    }

    /*******************************
    public List <BankTransaction> parseLinesFromCSV (final List <String> lines) {
    final List <BankTransaction> bankTransactions = new ArrayList<>();
    for (final String line: lines) {
    bankTransactions.add(parseFromCSV(line));
    }
    return bankTransactions;
    }

    @Override
    public BankTransaction parseFrom(String line) {
    return null;
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
    return null;
    }
    ********************************/
}