package BankStatementAnalyzer.Main.Resources;

public class MainApplication {

    public static void main ( String [] args)  throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final Interface_BankStatementParser bankStatementParser = new BankStatementCsvParser();

        bankStatementAnalyzer.analyze("ExampleStatements2.csv", bankStatementParser);

    }
}
