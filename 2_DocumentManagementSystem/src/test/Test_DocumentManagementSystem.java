package main;
import Attributes.PATIENT;
import org.junit.Test;

import javax.swing.text.Document;
import java.util.jar.Attributes;

import static DocumentManagementSystem.Attributes.ADDRESS;
import static DocumentManagementSystem.Attributes.BODY;
import static DocumentManagementSystem.Attributes.PATIENT;
import static DocumentManagementSystem.Document.
import static java.awt.PageAttributes.MediaType.LETTER;;


public class Test_DocumentManagementSystem {


    @Test
    public void shouldImportFile() throws Exception{
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }

    //  Test for importing letters:
    @Test
    public void shouldImportLetterAttributes() throws Exception {
        system.importFile(LETTER);

        final Document document = onlyDocument();

        assertAttributeEquals(document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals(document, ADDRESS , "123 Fake Street\n" + "Westminster\n" + "London\n" + "United Kingdom");
        assertAttributeEquals(document, BODY, "We are writing to you to confirm the re-scheduling of your appointment\n" +
                "with Dr. Avaj from 29th December 2016 to 5th January 2017.");
        assertTypeis("LETTER", document);

    }
}
