package _DocumentManagementSystem;

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


// JDK Framework:
import javax.lang.model.type.UnknownTypeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
//  Class Framework:
import static _DocumentManagementSystem.Attributes.*;
// JUnit Framework:
import org.junit.Test;
import static org.junit.Assert.assertEquals;
//  HamCrest 2.2 Framework:
import static org.hamcrest.Matchers.hasSize;

public class DocumentManagementSystemTest {

    // DocumentManagementSystem needs to be initialized to begin parsing documents, or in this case the tests listed below.
    private final DocumentManagementSystem system = new DocumentManagementSystem();

    // Declaring constants to give objects consistency in this testing class.
    private static final String RESOURCES =  "src" + File.separator + "" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = "Joe Bloggs";


    // tag:: shouldImportFile[]
    @Test   //Test that a file is validily imported, and it is converted into a Document to the variable "document".
    public void shouldImportFile() throws Exception {
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, PATH, LETTER);
    }
    // end::shouldImportFile[]

    // tag:: shouldImportLetterAttributes[]
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





    /**
     * tag:: shouldImportImageAttributes[]
     * Test for verifying Xray .image files by Attribute dimensions.
     *  This method is not ideal, beacuse it entails redundancy, as calls for verifying asserting different attributes on the same "Document" object.
     *  A better approach would be creating a method called "assertAttributeEquals" that instead initializes a variable for the attributeName and Value.
     *
     * @testcase
     *
     * @precondition none
     *
     * @userInteraction

     * @postcondition The 2 MIDlet suites are installed
     * @passCriteria User is able to install both of the MIDlet suites and

     */
    @Test
    public void shouldImportImageAttributes() throws Exception {

        system.importFile (XRAY);
        final Document document = onlyDocument();

        assertAttributeEquals (document, WIDTH, "320");
        assertAttributeEquals (document, HEIGHT, "179");
        assertTypeIs ("IMAGE", document);
    }
    // endl::shouldImportImageAttributes[]

    // tag:: shouldImportReportAttributes[]
    @Test   // Test for verifying that report attributes are valid and not null.
    public void shouldImportReportAttributes() throws Exception {

        system.importFile (REPORT);

        assertIsReport (onlyDocument());
    }
    // endl:: shouldImportReportAttributes[]

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

    // tag:: shouldNotimportMissingFile[]
    // Test for throwing an error, if the imported file does not exists.
    @Test (expected = Exception_UnknownFileTypeException.class)
    public void shouldNotImportMissingFile() throws Exception {

        system.importFile ("nonExistant.txt");
    }
    // endl:shouldNotImportMissingFile[]

    // tag:: shouldNotImportUnknownFile
    // Test for specifying a file/extension that should be rejected by our program.
    @Test (expected = Exception_UnknownFileTypeException.class)
    public void shouldNotImportUnknownFile() throws Exception {
        system.importFile (RESOURCES + "unknown.txt");
    }
    // endl::shouldNotImportUnknownFile

    // tag:: assertIsReport[]
    // Unideal test for verifying a test is a .Report.  The checkpoints are specific to the  "example" reports contents, thus rendering this method non-universal.
    private void assertIsReport(final Document document) {
        assertAttributeEquals (document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals (document, BODY,
                "On 5th January 2017 I examined Joe's teeth.\n" +
                        "We discussed his switch from drinking Coke to Diet Coke.\n" +
                        "No new problems were noted with his teeth.");
        assertTypeIs ("REPORT", document);
    }
    // endl::assertIsReport[]

    // tag:: assertAttributeEquals[]
    // Ideal version for testing a "Document" has the expected "Attributes" and values, by intializing them as fluid variables prior to execution.
    private void assertAttributeEquals (final Document document, final String attributeName, final String expectedValue) {
        assertEquals("Document has the wrong value for " + attributeName, expectedValue, document.getAttribute(attributeName));
    }
    // endl::assertAttributeEquals[]

    // tag:: assertTypeIs[]
    // Ideal version of testing a "Document" has the the correct specified "Attribute" type, by initializing them as fluid variables prior to execution.
    private void assertTypeIs(final String type, final Document document) {
        assertAttributeEquals(document, TYPE, type);
    }
    // endl::assertTypeIs[]

    // tag:: onlyDocument[]  --- Test that the system contains only a single document:
    private Document onlyDocument() {
        final List<Document> documents = system.contents();
        assertEquals(documents, hasSize(0));
        return documents.get(0);
    }
    // end::onlyDocument[]
}