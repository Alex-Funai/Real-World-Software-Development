// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

/******************************************************************************
 * @apiNote .BankStatementAnalyzer()
 * 'class.BankStatementAnalyzer' is preceeded by a final class in this package known as "Main_Application", and
 * the "BankStatementProcesseor" which is a class for listing various analytical operation methods that are independent
 * to the class as a whole. It is much more manageable, has better cohesion methodology, and more accessible for this
 * program as it evolves, updates, or is worked on by other programmers.
 *
 * @apiNote .analyze()
 * <p>
 * We specify our parsed file that was buffered into a List of strings, as the variable lines. Second here we utilize
 * the method "File.ReadAllLines" which opens a text file, reads all of the lines into a string array, and then closes
 * the file. Since list/sets are an abstract data structure (sort of) we need to utilize this method for manipulating
 * that data into a string type.Possibly "StringBuilder" or "StringUtils.join" could be utilzied, but I 'm unsure,
 * and that could possibly include more complications througout the program.
 * <p>
 * @apiNote .collectSummary()
 * The "collectSummary" method intakes  methods from the "bankStatementProcessor" (bankStatement), and prints out some
 * simple calculations and information regarding that data. This form of decoupling is ideal, because we can simply add
 * or change our methods in the "bankStatementProcessor" class to create more user-cases without having to revise this
 * class as well. Additionaly it creates a form of legibility for others whom may have to manage this code, or utilize
 * it without struggling to determine where processes are, and how to revise them to their own needs.
 *
 ******************************************************************************/

package _bankStatementAnalyzer;
import java.io.IOException;
import java.nio.file.Files; import java.nio.file.Path; import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * The BankStatementAnalyzer class will parse a CSV file from the "src/Resources" folder of the projecct, and return a
 * few standard System.out statements under the "collectSummary" method to mainly verify that the operating
 * "class.*(BankStatementProcessor, BankStatementTransaction, BankStatementParser, BankTransactionProcessor" work.
 *
 * <p>Bugs: none yet.
 *
 * @author akfunai
 */
public class BankStatementAnalyzer {

    private static final String RESOURCES = "lib/src/main/resources/";  // Initialize variable 'RESOURCES'
                                                                        // for storing file path directory.
    /**
     * (Write a succinct description of this method here. If necessary,
     * additional paragraphs should be preceded by <p>, the html tag for
     * a new paragraph.)
     *
     * @param fileName (Describe the first parameter here)
     * @param interfaceBankStatementParser (Do the same for each additional parameter)
     */
    public void analyze (final String fileName, final Interface_BankStatementParser interfaceBankStatementParser) throws IOException {

        final Path path = Paths.get (RESOURCES + fileName);   // Initializing variable 'path' to reference
                                                                   // RESOURCES and the object fileName() file location.

        final List <String> lines = Files.readAllLines(path);   // Initialize list 'lines' to intake object path's
                                                                // file, and read all lines in.

        final List <BankTransaction> bankTransactions = interfaceBankStatementParser.parseLinesFrom(lines);     // Initialize 'bankTransactions' as a list using
                                                                                                                //  parser object, parseLinesFrom method, and lines object

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);     // Initialize a new processor object that
                                                                                                                // uses the bankTransactions list object.
        collectSummary (bankStatementProcessor);    //
                                                    //
    }
    /**
     * collectSummary() leverages 'bankStatementProcessor' object w/ '.calulation*...' methods
     * to i/o bank statement amounts, month-amounts, and category-amounts.
     *
     * @param bankStatementProcessor The processor class for standard calculation methods.
     */
    private static void collectSummary  (final BankStatementProcessor bankStatementProcessor) {

        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());   // Prints out total transaction values
                                                                                                                    // of the entire document.

        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));  // Prints out total transaction value
                                                                                                                                        // for the month January.

        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));    // Prints out total transaction value
                                                                                                                                            // for the month February.
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));   // Prints out total transaction value
                                                                                                                            // for description/category[2] Salary.
    }
}
/******************************************************************************
 * @deprecated
 private static final BankStatementCsvParser bankStatementParser = new BankStatementCsvParser();

 public static void main ( final String ... args) throws IOException {

 final String fileName = "ExampleStatements.csv";    // file name here
 final Path path = Paths.get (  RESOURCES + fileName);;
 final List<String> lines = Files.readAllLines(path);

 final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
 // Decoupling CSV specific parser to replace for file type variance.

 final Interface_BankStatementProcessor bankStatementProcessor = new Interface_BankStatementProcessor(bankTransactions);
 // Decoupling interface since  BankStatementtParser encompasses different file type possibiilities.

 final List <BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
 // final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

 collectSummary (bankStatementProcessor);
 }
 ******************************************************************************/


