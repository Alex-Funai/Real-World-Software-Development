// Alexander Kitaro Funai -- March 20, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// JUnit tests for the CSV parser.

/* Using JUnit --- Utilize JUnit framework to establish and write unit tests. Leveraging JUnit and automation will
 * aid in long term maintenance of the program. Utilize comonent, functionality, regression, and unit testing methodologies.
 */

/* LIBRARIES --- Importing libraries through the project structure manager will copy the .jar files as a local duplicate in the project's local domain.
 * IDE's or SDK often have libarries compiled in their directories that are commonly used, and can be conveniently acceesed in their "$root/lib" directories.
 */

// Import project class dependencies:
import BankStatementAnalyzer.BankStatementCSVParser;
import BankStatementAnalyzer.BankStatementParser;
import BankStatementAnalyzer.BankTransaction;

// Import JUnit framework testing dependencies:
import org.junit.Assert;        // Diagnostic message prompt.
import org.junit.Test;             // Method representation of a single "test unit".

// Local class dependencies:
import java.time.LocalDate;
import java.time.Month;


// Class declaration for >> Testing the BankStatementCSV Parser.
public class BankStatementCsvParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();


    @Test       // T00 -- Example of a failing Assert test.
    public void shouldParseOneCorrectLine_FAIL() throws Exception {
        Assert.fail("Not yet implemented");
    }

    @Test       // T01 -- Example ofa passing parsing test.
    public  void shouldParseOneCorrectLine_Pass() throws Exception {
        final String line = "30-01-2017, -50,Tesco";    // White space fails comparison test, but test continues on still.
        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction (LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0;

        // Three-stage pattern "unit-test" known as the "Given-When-Then" formula.
        Assert.assertEquals (expected.getDate(), result.getDate());
        Assert.assertEquals (expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals (expected.getDescription(), result.getDescription());

         /* [What's Going on Above here]:
          *  1.  You set up the context for your test. In this case a line to parse.
          *  2.  You carry out an action. In this case, you parse the input line.
          *  3.  You specify assertions of the expected output. Here, you check that the date, amount, and description were parsed correctly.
          *  4.  Basically you are leveraging the pre-defined "get" methods and comparing the contrasting them with "expected" and "result".
          *  5.  The structure fed into the "assertEquals" argument is defined as variables that leverage the BankTransaction class,
          *        and statementParser.ParseFrom(line) process.
          */

        /*  [ASSERTION Statements]:
         *  1. Assert.fail(message) --- Let method fail. Useful placeholder before you implement test code.
         *  2. Assert.assertEquals(expected,actual) --- Test that two values are the same.
         *  3. Assert.assertEquals(expected, actual, delta) --- Assert that two floats or doubles are within a delta.
         *  4. Assert.assertNotNull(object) --- Assert that an object is not null.
         */

        /*  [CODE COVERAGE]:
         * More code coverage for test's isn't necessarily better, but you should aim for 70-90%.
         * Popular code coverage tools include: JaCoCo, Emma, and Cobertura.
         * Code coverage can often be referenced in small-talk as "line-coverage" and "branch-coverage".
         */
    }
}
