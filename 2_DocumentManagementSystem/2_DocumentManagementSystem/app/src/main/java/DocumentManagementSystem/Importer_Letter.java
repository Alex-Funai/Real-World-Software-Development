// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System


package java.DocumentManagementSystem;

// Class Framework:
import static java.DocumentManagementSystem.Attributes.ADDRESS;
import static java.DocumentManagementSystem.Attributes.BODY;
import static java.DocumentManagementSystem.Attributes.PATIENT;
import static java.DocumentManagementSystem.Attributes.TYPE;

// JDK Framework:
import java.io.File;
import java.io.IOException;
import java.util.Map;

/***********************************************/


class Importer_Letter implements Importer {

    private static final String NAME_PREFIX = "Dear ";

    @Override
    public Document importFile(final File file) throws IOException {
        final Definition_TextFile textFile = new Definition_TextFile(file);

        textFile.addLineSuffix (NAME_PREFIX,  PATIENT);

        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS);
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "LETTER");
        return new Document(attributes);
    }
}
