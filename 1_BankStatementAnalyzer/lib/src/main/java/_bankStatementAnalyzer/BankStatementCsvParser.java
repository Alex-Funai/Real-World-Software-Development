///////////////////////////////////////////////////////////////////////////////
// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////
/**
 * @apiNote DateTimeFormatter DATE_PATTERN[]
 * DateTimeFormatter() declares and specifies that DATE_PATTERN will be the variable to hold the date parsed from our
 * files. The DateTimeFormatter and .ofPattern method allow us to specify the data format that is anticipated to be
 * processed, so it is returned to the compiler for furhter manipulatin down the line properly. Such as when we call
 * for specifying the data into separate columns of our array below.
 *<p>
 * @apiNote Line.split[]
 * 'Line.split' utilizes a specific character or variable as a delimitter/separator, and splits the array by column
 * when it handles that data-type. For example here, we have specified "line.split" to associate the "," (comma)
 * character as a delimitter, since our example data sheet utilizes a comma to separate the different and
 * important information we will need to handle >> Data, Transaction, Description.
 * <p>
 * @apiNote LocalDate[]
 * Initialize LocalDate class to store data into variable "date" by first declaring the LocalDate class, second parsing
 * by character, and third respecting our declaration of what the date is, given by >> it will be in column[0] and in
 * the pattern declared above as/is variable DATE_PATTERN.
 * <p>
 * @apiNote amount[]
 * Initialize a double variable '.amount' to be the value of column[1]. The Double class uses '.parseDouble'
 * method, which seems to be necessary for extracing it from our CSV since it has been specified into the form of an
 * array. Double parseDouble returns as a string type, and maybe that's the important part.
 * <p>
 * @apiNote Return BankTransaction(date, amount, columns[2])[]
 * Finally we return the preceeed data, and include the last column which is a string description in our file. Because
 * the file is already a string we dont need to utilize any parsing methods or extra classes, and can simply incooporate
 * it directly into our return constructor. However we do need to specify that this will be a "new BankTransaction",
 * because theoretically we will have to intialize several more BankTransactions throughout this program, and they will
 * all need unique instances of their own to handle unique data values.
 *
 */
package _bankStatementAnalyzer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  // 'format.DateTimeFormatter' allows converting
                                            // calendar date formats for compilation.
import java.util.List;
import static java.util.stream.Collectors.toList;   // 'util.stream' to output complex data-
                                                    // structures such as lists, maybe arrays, etc.
/**
 * 'class.BankStatementCsvParser' will scan through a general/specified format of data such that ---
 * the format is: "Date (dd--MM-yyyy)", "Amount as double",   "Description as String". Commas are delimiters
 * to separate data objects into array.
 *
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author akfunai
 */
public class BankStatementCsvParser implements Interface_BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");    // Initialize 'DATE_PATTERN' variable
                                                                                                        // to store converted date from documents.
    /**
     * Parses a CSV and returns it's column data
     *
     * @param line The document's rows.
     * @return (date, amount, columns[2]) The transaction date, amount, and description.
     */
    public BankTransaction parseFrom(final String line) {

        final String[] columns = line.split(",");   // Delimits columns array[] at commas.

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);   // Initializes converted date >> 'date' object.

        final double amount = Double.parseDouble(columns[1]);   // Initaize transaction amount >> 'amount' object.

        return new BankTransaction(date, amount, columns[2]);   // Returns transaction date, amount, and description.
    }
    /**
     * (Write a succinct description of this method here. If necessary,
     * additional paragraphs should be preceded by <p>, the html tag for
     * a new paragraph.)
     *
     * @param lines The lines of a document passed through a parser.
     * @return The date, amount, description as a list<string>
     */
    public List<BankTransaction> parseLinesFrom(final List<String> lines) {

        return lines.stream().map(this::parseFrom).collect(toList());   // Returns converted date, amount, description.
    }
}