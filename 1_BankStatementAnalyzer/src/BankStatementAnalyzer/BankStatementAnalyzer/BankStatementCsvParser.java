// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

package BankStatementAnalyzer;

// Declaring class dependencies:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class BankStatementCsvParser implements Interface_BankStatementParser {

    /* DateTimeFormatter --- Declares and specifies that DATE_PATTERN will be the variable to hold the date parsed from our files.
     *  The DateTimeFormatter and .ofPattern method allow us to specify the data format that is anticipated to be
     *  processed, so it is returned to the compiler for furhter manipulatin down the line properly. Such as when
     *  we call for specifying the data into separate columns of our array below.
     */
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);

        return new BankTransaction(date, amount, columns[2]);
    }

    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        return lines.stream().map(this::parseFrom).collect(toList());
    }
}