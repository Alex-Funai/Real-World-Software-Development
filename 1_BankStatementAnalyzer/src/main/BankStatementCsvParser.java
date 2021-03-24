// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer


import java.time.LocalDate;         // Idk something regarding local date, when using the LocalDate class.
import java.time.format.DateTimeFormatter;      //DateTimeFormatter allows us to handle different general calendar date formats for our compiler to handle.
import java.util.List;      // Dependency for  List class.
import static java.util.stream.Collectors.toList;   // Stream allows us to output complex data structures such as lists, maybe arrays, etc. Stuff like ArraytoList, kind of function.

/*  The BankStatementCsvParser class will scan through a general/specified format of data such that:
 *  the format is:  "Date (dd--MM-yyyy)", "Amount as double",   "Description as String".    Notice that commas
 *  in between each information type, as the "commas is used as the delimitter/separator, for the array that is initialized
 *  to separate that data.
 */

public class BankStatementCsvParser implements Interface_BankStatementParser {

    /* DateTimeFormatter --- Declares and specifies that DATE_PATTERN will be the variable to hold the date parsed from our files.
     *  The DateTimeFormatter and .ofPattern method allow us to specify the data format that is anticipated to be
     *  processed, so it is returned to the compiler for furhter manipulatin down the line properly. Such as when
     *  we call for specifying the data into separate columns of our array below.
     */
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankTransaction parseFrom(final String line) {

        /*  Line.split utilizes a specific character or variable as a delimitter/separator, and splits the array by column when it handles that data-type.
         *  For example here, we have specified "line.split" to associate the "," (comma) character as a delimitter, since our example data sheet
         *  utilizes a comma to separate the different and important information we will need to handle >> Data, Transaction, Description.
         */
        final String[] columns = line.split(",");



        /*  Initialize LocalDate class to store data into variable "date" by first declaring the LocalDate class, second parsing by character, and third
         *  respecting our declaration of what the date is, given by >> it will be in column[0] and in the pattern declared above as/is variable DATE_PATTERN.
         */
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

        /* Initialize a double variable "amount" to be the value of column [1]. The Double class is assisted by the parseDouble method which
         *  seems to be necessary for extracing it from our CSV since it has been specified into the form of an array. Double parseDouble returns
         *  as a string type, and maybe that's the important part. Is to coordinating exportation of data-type, so when we further manipulate data
         *  in the program, we won't have to tediously manage returns/exports.
         */
        final double amount = Double.parseDouble(columns[1]);

        /*  Finally we return the preceeed data, and include the last column which is a string description in our file. Because the file is already a string
         *  we dont need to utilize any parsing methods or extra classes, and can simply incooporate it directly into our return constructor. However we
         *  do need to specify that this will be a "new BankTransaction", because theoretically we will have to intialize several more BankTransactions throughout this program,
         *  and t hey will all need unique instances of their own to handle unique data values (unlesse every transaction were the same, which they are not).
         */
        return new BankTransaction(date, amount, columns[2]);
    }

    /* parseLinesFrom allows us to parse lines of text from a text buffer into a string set/list.
     * We then do some map collect stuff to parse it (come back to define this later).
     */
    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        return lines.stream().map(this::parseFrom).collect(toList());
    }
}