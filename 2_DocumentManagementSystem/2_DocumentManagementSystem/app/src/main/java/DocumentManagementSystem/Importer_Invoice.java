// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

package java.DocumentManagementSystem;

// JDK Framework::
import java.io.File;
import java.io.IOException;
import java.util.Map;

/******************************************************************************************************************/

class Importer_Invoice implements Importer {

     private static final String NAME_PREFIX = "Dear ";
     private static final String AMOUNT_PREFIX = "Amount: ";

    @Override
    public Document importFile(final File file) throws IOException {
        final Definition_TextFile textFile = new Definition_TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, Attributes.PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, Attributes.AMOUNT);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(Attributes.TYPE, "INVOICE");
        return new Document(attributes);
    }
}
