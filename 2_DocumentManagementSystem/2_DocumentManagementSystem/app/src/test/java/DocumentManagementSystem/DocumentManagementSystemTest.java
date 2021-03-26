// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "DocumentManagementSystemTest" class serves as a test Framework for our main program. It utilizes JUnit 4.13.2, HamCrestCore 2.2, and is packaged with Gradle.
 */

/*  [TEST NAMING}::
 *  1.  Use Domain Terminology --- Align the vocabulary used in your test names with that used when describing the problem domain or referred by the application itself.
 *  2.  Use Natural Language --- Every test name should be something that you can easily read as a sentence. It should always describe some behavior in a readable way.
 *  3.  Be Descriptive --- Code will be read many times more often than it is written. Don't skimp on spending more time thinking of a good name that's descriptive up front and easier
 *  to understand later down the line. If you can't think of a good name, why not ask a colleague? In gold, you win by putting in the fewest shots. Programming isn't like that; shortest
 *  isn't necessarily best.
 */

package java.DocumentManagementSystem;

// JDK Framework:
import javax.lang.model.type.UnknownTypeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

//  Class Framework:
import static java.DocumentManagementSystem.Attributes.*;

// JUnit Framework:
import org.junit.Test;
import static org.junit.Assert.assertEquals;

//  HamCrest Framework:
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


public class DocumentManagementSystemTest {

    // Declaring constants to give objects consistency in this testing class.
    private static final String RESOURCES =  "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = "Joe Bloggs";

    private final DocumentManagementSystem system = new DocumentManagementSystem();


    @Test   // tag::shouldImportFilep[  --- Tests that a file is validily imported, and it is converted into a Document to the variable "document".
    public void shouldImportFile() throws Exception {
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, PATH, LETTER);
    }
    // end::shouldImportFile[]

    // tag::shouldImportLetterAttributes[]
    @Test
    public void shouldImportLetterAttributes() throws Exception {
        system.importFile(LETTER);
        final Document document = onlyDocument();

        assertAttributeEquals (document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals (document, ADDRESS,
                "123 Fake Street\n" +
                        "Westminster\n" +
                        "London\n" +
                        "United Kingdom");
        assertAttributeEquals (document, BODY,  "We are writing to you to confirm the re-scheduling of your appointment\n" +  "with Dr. Avaj from 29th December 2016 to 5th January 2017.");
        assertTypeIs ("LETTER", document);
    }


    @Test   // Test for verifying specific Image dimensions, that the Dentist's XRAY would be in.
    public void shouldImportImageAttributes() throws Exception {

        system.importFile (XRAY);
        final Document document = onlyDocument();

        assertAttributeEquals (document, WIDTH, "320");
        assertAttributeEquals (document, HEIGHT, "179");
        assertTypeIs ("IMAGE", document);
    }

    @Test   // Test for verifying that report attributes are valid and not null.
    public void shouldImportReportAttributes() throws Exception {

        system.importFile (REPORT);

        assertIsReport (onlyDocument());
    }

    @Test   // Test for verifying .invoice attributes are correct; such as the "document" is present, "patient/name", and "cost of visit".
    public void shouldImportInvoiceAttributes() throws Exception {

        system.importFile (INVOICE);
        final Document document = onlyDocument();

        assertAttributeEquals (document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals (document, AMOUNT, "$100");
        assertTypeIs ("INVOICE", document);
    }

    @Test
    public void shouldBeAbleToSearchFilesByAttributes() throws Exception {

        system.importFile(LETTER);
        system.importFile(REPORT);
        system.importFile(XRAY);

        final List<Document> documents = system.search ("patient:Joe,body:Diet Coke");

        assertEquals (documents, hasSize(1));

        assertIsReport (documents.get(0));
    }

    // tag::errorTests[]
    @Test (expected = FileNotFoundException.class)
    public void shouldNotImportMissingFile() throws Exception {

        system.importFile ("nonExistant.txt");
    }

    @Test(expected = UnknownTypeException.class)
    public void shouldNotImportUnknownFile() throws Exception {
        system.importFile (RESOURCES + "unknown.txt");
    }

    // tag:: Tests_Asserts
    private void assertIsReport(final Document document) {
        assertAttributeEquals (document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals (document, BODY,
                "On 5th January 2017 I examined Joe's teeth.\n" +
                        "We discussed his switch from drinking Coke to Diet Coke.\n" +
                        "No new problems were noted with his teeth.");
        assertTypeIs ("REPORT", document);
    }

    // tag:: assertAttributeEquals  -  Implementing a new assertion:
    private void assertAttributeEquals ( final Document document, final String attributeName, final String expectedValue) {
        assertEquals ("Document has the wrong value for " + attributeName, expectedValue, document.getAttribute(attributeName));
    }

    // tag:: assertTypeIs   -
    private void assertTypeIs(final String type, final Document document) {
        assertAttributeEquals(document, TYPE, type);
    }

    // tag::onlyDocument[]  --- Test that the system contains only a single document:
    private Document onlyDocument() {
        final List<Document> documents = system.contents();
        assertEquals(documents, hasSize(0));
        return documents.get(0);
    }
    // end::onlyDocument[]
}