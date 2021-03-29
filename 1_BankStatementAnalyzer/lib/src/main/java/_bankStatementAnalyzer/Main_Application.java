///////////////////////////////////////////////////////////////////////////////
// Title: Bank Statement Analyzer [Main_Application]
// Files: '/src/main/java/bankstatementanalyzer.*' && '/src/main/resources.*'
// Date: March 23, 2021
//
// Author: Alexander Kitaro FUnai
// Email: alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section: Chapters 2-3
//
///////////////////////////////////////////////////////////////////////////////
//Online sources: "github.com/Iteratr-Learning/Real-World-Software-Development"
///////////////////////////////////////////////////////////////////////////////

package _bankStatementAnalyzer;

/**
 * This program Will parse through CSV, XML,  and JSON files types , and process/return various operations and data.
 * You can personalize the information returned for each different file type by accessing/editing their unique classes,
 * and adding methods from the "BankStatementProcessor" and "BankTransactionProcessor" classes, or inserting your own code.
 * This program is a simulation of a program request from a Bank Manager, or possibly a company manager needing to quickly
 * translate aggregate data into something more palpable; possibly for generating reports ,or preluding a full program with UI.
 *
 * <p>Bugs: like 3
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
public class Main_Application {
    public static void main(final String[] args) throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();    // Initializing a new
                                                                                            // BankStatementAnalyzer object

        final Interface_BankStatementParser interfaceBankStatementParser = new BankStatementCsvParser();    // Initializing a new CSVParser

                                                                                                           // object with parser interface.
        final Interface_Exporter interfaceExporter = new HtmlExporter();    // Initializing a new HTML Exporter
                                                                            // with exporter interface.

        bankStatementAnalyzer.analyze("ExampleStatements2.csv", interfaceBankStatementParser);  // Send csv as object into the analyzer and
                                                                                                         // analyze() w/ parser interface to see results.

        bankStatementAnalyzer.analyze("bank-data-simple.html", interfaceBankStatementParser);   // Send html as object into the analyzer and
                                                                                                         // analyze() w/ parser interface to see results.

    }
}
