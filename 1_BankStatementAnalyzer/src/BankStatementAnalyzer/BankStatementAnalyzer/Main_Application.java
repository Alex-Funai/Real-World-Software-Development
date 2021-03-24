// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer


/* [DESCRIPTION]: This program Will parse through CSV, XML,  and JSON files types , and process/return various operations and data.
  *                                         You can personalize the information returned for each different file type by accessing/editing their unique classes, and
  *                                         adding methods from the "BankStatementProcessor" and "BankTransactionProcessor" classes, or inserting your own code.
  *                                         This program is a simulation of a program request from a Bank Manager, or possibly a company manager needing to quickly
  *                                         translate aggregate data into something more palpable; possibly for generating reports ,or preluding a full program with UI.
  */

/*  [REPRO STEPS]:
  *  1. Edit the file name in the bankStatementAnalyzer class  under "fileName" object.
  *  2. Manage transaction data cases to return, by accessing/editing the unique classes (HTMLExporter, etc) that have been created for each file type.
  *        you can add methods from the "BankStatementProcessor" class to personalize your analysis without having to refactor the whole program.
  *  3. Run  "Main_Application.main".
  */

package BankStatementAnalyzer;

public class Main_Application {

    public static void main(final String[] args) throws Exception {

        // Constructing and declaring a new BankStatementAnalyzer object, uzing our initial anlyziation class.
        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final Interface_BankStatementParser interfaceBankStatementParser
                = new BankStatementCsvParser();

        /* "Interface_Exporter" method is for constructing and delcaring a new Interface_Exporter as the variable interfaceExporter.
         *  This constructor manages and holds the methods and classes we which to access, and then use on our data.
         *  In our scenario, we have designated a unique exporter for different file types, so we can simply managae the exporter class
         *  to change request. They all inherit a basis construction for the data types they should have, and we can make changes to them
         *  specifically without having to jeopardize the code base/structure of the program as a whole.
         */
        final Interface_Exporter interfaceExporter
                = new HtmlExporter();

        /* " bankStatementAnalyzer.analyze" method
         *
         */
        bankStatementAnalyzer.analyze("ExampleStatements2.csv", interfaceBankStatementParser);

    }
}
