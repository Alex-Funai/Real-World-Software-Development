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

        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final Interface_BankStatementParser bankStatementParser
                = new BankStatementCsvParser();

        final Interface_Exporter exporter
                = new Exporter_HTML();


        bankStatementAnalyzer.analyze("bank-data-simple.html", bankStatementParser, exporter);

        bankStatementAnalyzer.analyze("ExampleStatements2.csv", bankStatementParser, exporter);

        bankStatementAnalyzer.analyze("ExampleStatements.csv", bankStatementParser, exporter);

    }
}
