// Main Class File: Main_Application.java
// File: BankStatementAnalyzer.java
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

/******************************************************************************
 * @apiNote .BankStatementAnalyzer()
 * class.BankStatementAnalyzer is preceeded by a final class in this package known as class.Main_Application, and
 * class.BankStatementProcesseor is for listing various analytical operation methods that are independent
 * to the class as a whole. It's more manageable, has better cohesion methodology, and is easier to access as the
 * program receives feature updates/revision.
 * <p>
 * @apiNote .analyze()
 * We specify our parsed file that was buffered into a List of strings, as the variable lines. Second here we utilize
 * the method "File.ReadAllLines" which opens a text file, reads all of the lines into a string array, and then closes
 * the file. Since list/sets are an abstract data structure (sort of) we need to utilize this method for manipulating
 * that data into a string type.Possibly "StringBuilder" or "StringUtils.join" could be utilzied, but I 'm unsure,
 * and that could possibly include more complications througout the program.
 * <p>
 * @apiNote .statementSummaryBasic()
 * The "statementSummaryBasic" method intakes  methods from the "bankStatementProcessor" (bankStatement), and prints out some
 * simple calculations and information regarding that data. This form of decoupling is ideal, because we can simply add
 * or change our methods in the "bankStatementProcessor" class to create more user-cases without having to revise this
 * class as well. Additionaly it creates a form of legibility for others whom may have to manage this code, or utilize
 * it without struggling to determine where processes are, and how to revise them to their own needs.
 ******************************************************************************/

package _bankStatementAnalyzer;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files; import java.nio.file.Path; import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * The BankStatementAnalyzer class will parse a CSV file from the "src/Resources" folder of the projecct, and return a
 * few standard System.out statements under the "statementSummaryBasic" method to mainly verify that the operating
 * "class.*(BankStatementProcessor, BankStatementTransaction, BankStatementParser, BankTransactionProcessor" work.
 *
 * <p>Bugs: n/a
 *
 * @author :Raoul-Gabriel Urma & Richard Warburton
 */
public class BankStatementAnalyzer {



    private static final String RESOURCES = "lib/src/main/resources/";  // Initialize variable 'RESOURCES'
    // for storing file path directory.

    /**
     * Analyzes a list of bank transactions.
     *
     * @param fileName                     :The file being analyzed.
     * @param interfaceBankStatementParser :The indiscriminate bank statement parser.
     * @throws IOException :
     */
    public void analyze(
            final String fileName,
            final Interface_BankStatementParser interfaceBankStatementParser,
            final Interface_Exporter exporter) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);   // Initializing variable 'path' to reference
        // RESOURCES and the object fileName() file location.


        final List<String> lines = Files.readAllLines(path);   // Initialize list 'lines' to intake object path's
        // file, and read all lines in.

        final List<BankTransaction> bankTransactions = interfaceBankStatementParser.parseLinesFrom(lines);     // Initialize 'bankTransactions' as a list using
        //  parser object, parseLinesFrom method, and lines object

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);     // Initialize a new processor object that
        // uses the bankTransactions list object.


        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();


            System.out.println("\n");
            System.out.println("*****************************************************************\n" +
                    "Statement Summary: " + "\n" +
                    "File Path: " + path + "\n" +
                    "File Name: " + fileName + "\n");

            statementSummaryBasic(bankStatementProcessor);

            System.out.println("*****************************************************************\n" +
                    "Transaction Data: " + "\n" +
                    "File Path: " + path + "\n" +
                    "File Name: " + fileName + "\n");

            statementAPI(bankStatementProcessor);


            if (fileName.contains(".html")) {

                System.out.println("******************************************************************");
                System.out.println("HTML DATA: ");
                System.out.println(exporter.export(summaryStatistics));

            }
        }



        /**
         * @deprecated
         * statementSummaryBasic (bankStatementProcessor);
         */

    /**
     * statementSummaryBasic()
     * Prints a bank statement total amount,
     * amount in certain months, and amount for a category.
     *
     * @param bankStatementProcessor The processor for bank statement calculation methods.
     */
    public static void statementSummaryBasic(final BankStatementProcessor bankStatementProcessor) {

        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());   // Prints out total transaction values
                                                                                                                    // of the entire document.

        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));  // Prints out total transaction value
                                                                                                                                        // for the month January.

        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));    // Prints out total transaction value
                                                                                                                                            // for the month February.

        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));   // Prints out total transaction value
    }


    /**
     * @apiNote API for using statement/transaction methods
     * for processing specific data.
     *
     * @param bankStatementProcessor The processor class.
     */
    public static void statementAPI(final BankStatementProcessor bankStatementProcessor) {

    /******************************************************************
     *                  -Bank Statement/Transaction API-
     *
     * @see Invoke methods you'd like to use in this statementAPI().
     *
     * @apiNote :Calculation Methods:
     *  bankStatementProcessor.calculateTotalAmount();
     *  bankStatementProcessor.calculateTotalInMonth(Month.JANUARY);
     *  bankStatementProcessor.calculateTotalForCategory("cheese");
     *
     *
     * @apiNote :Find Methods:
     *  bankStatementProcessor.findTransactionGreaterThanEqual(5);
     *
     * @apiNote :Summary Methods:
     *  bankStatementProcessor.summarizeTransactions();
     *
     *******************************************************************/

    System.out.println("The total amount for all transactions is: " + bankStatementProcessor.calculateTotalAmount());
    System.out.println("The total spent on Cheese is: " + bankStatementProcessor.calculateTotalForCategory("CHEESE"));
    System.out.println("The total spent in March was: " + bankStatementProcessor.calculateTotalInMonth(Month.MARCH));

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

 statementSummaryBasic (bankStatementProcessor);
 }
 ******************************************************************************/


