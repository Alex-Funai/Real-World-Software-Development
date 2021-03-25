package DocumentManagementSystem;
import static DocumentManagementSystem.Attributes.ADDRESS;
import static DocumentManagementSystem.Attributes.BODY;
import static DocumentManagementSystem.Attributes.PATIENT;
import static DocumentManagementSystem.Attributes.TYPE;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*  This is a class API for importing ".letter" type files. It leverages the "Definition_TextFile" template.
 *
 */

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
