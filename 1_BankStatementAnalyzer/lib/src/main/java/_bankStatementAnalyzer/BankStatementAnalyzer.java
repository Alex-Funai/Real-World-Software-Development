// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////


/* [DEFINITIONS]:
Cohesion --- "how related things are in a class".
Coupling --- "how dependent classes are upon one another".
*/

/*  The BankStatementAnalyzer class will parse a CSV file from the "src/Resources" folder of the projecct, and return a few
 *  standard System.out statements under the "collectSummary" method to mainly verify that the operating classes handling the data backend
 *  are working properly ("BankStatementProcessor", "BankStatementTransaction", "BankStatementParser", "BankTransactionProcessor".
 *
 *  Note that the BankStatementAnalyzer is proceeded by a final class in this package known as "Main_Application", and
 *  the "BankStatementProcesseor" which is a class for listing various analytical operation methods that are independent to
 *  the class as a whole. It is much more manageable, has better cohesion methodology, and more accessible for this progrma as
 *  it evolves, updates, or is worked on by other programmers.
 */

package _bankStatementAnalyzer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    // Edit root file path for Resources folder here.
    private static final String RESOURCES = "App/src/main/resources/";

    public void analyze (final String fileName, final Interface_BankStatementParser interfaceBankStatementParser) throws IOException {

        /*  Declaring/assigning file path name from the previously mentioned "src/Resources" folder +  the fileName variable of the actual file
         *  which  is specified in the "Main_Application" which  will finally call for this entire class. This was done to leverage de-coupling from anticipating
         *  the circumstances of revision/updating the program to eventually handle multiple files of various file types (CSV, XML, HTML, etc).
         */
        final Path path = Paths.get (RESOURCES + fileName);
        /*  We specify our parsed file that was buffered into a List of strings, as the variable lines. Second here we utilize the method
         *  "File.ReadAllLines" which opens a text file, reads all of the lines into a string array, and then closes the file. Since list/sets are an abstract
         *  data structure (sort of) we need to utilize this method for manipulating that data into a string type.Possibly "StringBuilder" or "StringUtils.join"
         * could be utilzied, but I 'm unsure, and that could possibly include more complications througout the program.
         */
        final List <String> lines = Files.readAllLines(path);

        final List <BankTransaction> bankTransactions = interfaceBankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary (bankStatementProcessor);
    }

    /*  The "collectSummary" method intakes  methods from the "bankStatementProcessor" (bankStatement), and prints out some simple
    *   calculations and information regarding that data. This form of decoupling is ideal, because we can simply add or change our methods in the
    *   "bankStatementProcessor" class to create more user-cases without having to revise this class as well. Additionaly it creates a form of legibility
    *   for others whom may have to manage this code, or utilize it without struggling to determine where processes are, and how to revise them to their
    *   own needs.
     */
    private static void collectSummary  (final BankStatementProcessor bankStatementProcessor) {
        // I/O leverage the "bankStatementProcessor" class object, and additionally use  the "calculateTotalAmount" method which holds a returned double value.
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        // I/O leverage the "bankStatementProcessor" class object, and  additionly  use it's calculateTotalInMonth method, with parameter arguments of method ".Month". and the specified parameter of  "JANUARY"
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        // I/O leverage the "bankStatementProcessor" class object, and  additionly  use it's calculateTotalInMonth method, with parameter arguments of method ".Month". and the specified parameter of  "FEBRUARY".
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

    /*
    private static final BankStatementCsvParser bankStatementParser = new BankStatementCsvParser();

    public static void main ( final String ... args) throws IOException {

        final String fileName = "ExampleStatements.csv";    // file name here
        final Path path = Paths.get (  RESOURCES + fileName);;
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
    // Decoupling CSV specific parser to replace for file type variance.

         final Interface_BankStatementProcessor bankStatementProcessor = new Interface_BankStatementProcessor(bankTransactions);
    // Decoupling interface since  BankStatementtParser encompasses different file type possibiilities.

         final  List <BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
    // final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary (bankStatementProcessor);
         }
         */

}
