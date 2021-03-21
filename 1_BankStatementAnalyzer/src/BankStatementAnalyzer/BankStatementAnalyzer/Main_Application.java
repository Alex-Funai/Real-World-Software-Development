// Alexander Kitaro Funai -- March 120 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer


/* [DESCRIPTION]:  This program Will parse through CSV, XML,  and JSON >> leveraging commas as delimitter/separator
  * date (dd-mm-yyyy) , double value (the transactiono amount), and string (transaction description).
  */

/*  [REPRO STEPS]:
  *  1. Edit the file name in the bankStatementAnalyzer class  under "fileName" object.
  *  2. Run main.
  */

package BankStatementAnalyzer;

public class Main_Application {

    public static void main ( String [] args)  throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final Interface_BankStatementParser bankStatementParser = new BankStatementCsvParser();

        bankStatementAnalyzer.analyze("ExampleStatements2.csv", bankStatementParser);

    }
}
