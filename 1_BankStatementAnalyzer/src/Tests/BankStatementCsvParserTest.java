// Alexander Kitaro Funai -- March 20, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

/*      00_JunitTest:
  *     This is a failing unit test for the CSV Parser.
  */

/*   Using JUnit --- Utilize JUnit framework to establish and write unit tests. Leveraging JUnit and automation will
  *   aid in long term maintenance of the program. Utilize comonent, functionality, regression, and unit testing methodologies.
  */


// Import class dependencies.
import BankStatementAnalyzer.BankStatementCsvParser;
import BankStatementAnalyzer.Interface_BankStatementParser;
// Import JUnit framework testing dependencies.
import org.junit.Assert;        // Diagnostic message prompt.
import org.junit.Test;             // Method representation of a single "test unit".

public class BankStatementCsvParserTest {

    private final Interface_BankStatementParser statementParser = new BankStatementCsvParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        Assert.fail("Not yet implemented");
    }
}
