// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// **********[ MAIN APPLICATION ]****************
// Bank Statement Analyzer --- This is the main program to run for parsing and calculating basic operations on a CSV.

package BankStatementAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/Resources/";


    public void analyze (final String fileName, final Interface_BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get (RESOURCES + fileName);
        final List <String> lines = Files.readAllLines(path);

        final List <BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary (bankStatementProcessor);
/*    }
    private static final BankStatementCsvParser bankStatementParser = new BankStatementCsvParser();

    public static void main ( final String ... args) throws IOException {

        final String fileName = "ExampleStatements.csv";    // file name here
        final Path path = Paths.get (  RESOURCES + fileName);;
        final List<String> lines = Files.readAllLines(path);


*//*        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
*//**//*        " Decoupling CSV specific parser to replace for file type variance."*//**//*

        final Interface_BankStatementProcessor bankStatementProcessor = new Interface_BankStatementProcessor(bankTransactions);
*//**//*        " Decoupoling interface since  BankStatementtParser encompasses different file type possibiilities.*//*

        final  List <BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary (bankStatementProcessor);*/
    }

    private static void collectSummary  (final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
