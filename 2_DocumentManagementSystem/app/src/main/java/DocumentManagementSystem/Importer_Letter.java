package DocumentManagementSystem;// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System


/*  The "Importer_Letter" class is a framework for importing ".letter" files, and is leveraged  into the Importer
 *  interface (which serves as the main handler for the various importerse of different file types). This demonstrates utilizing
 *  good principle of decoupling, and anticipation for positive code-usability, because we can modify each specific importer class
 *  individually to adjust accordingly as the program evolves.  */

// Class Framework:
import static DocumentManagementSystem.Attributes.ADDRESS;
import static DocumentManagementSystem.Attributes.BODY;
import static DocumentManagementSystem.Attributes.PATIENT;
import static DocumentManagementSystem.Attributes.TYPE;
// JDK Framework:
import java.io.File;
import java.io.IOException;
import java.util.Map;


class Importer_Letter implements Importer {

    // Declaring the "NAME_PREFIX" that will determine where to begin parsing the first unique object "PATIENT".
    private static final String NAME_PREFIX = "Dear ";

    @Override
    public Document importFile(final File file) throws IOException {

        // Declaring variables and data structures to intake keypairs of data.
        final Definition_TextFile textFile = new Definition_TextFile(file);
        final Map<String, String> attributes = textFile.getAttributes();
        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS);

        attributes.put(TYPE, "LETTER");
        textFile.addLineSuffix (NAME_PREFIX,  PATIENT);
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY);


        return new Document(attributes);
    }
}
