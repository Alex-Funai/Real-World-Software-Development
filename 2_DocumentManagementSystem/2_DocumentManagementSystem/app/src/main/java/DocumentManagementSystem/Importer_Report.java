// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

package java.DocumentManagementSystem;


//  JDK Framework::
import java.io.File;
import java.io.IOException;
import java.util.Map;


public class Importer_Report  implements Importer{

    private static final String NAME_PREFIX = "Patient ";

    @Override
    public Document importFile (final File file) throws IOException {

        final Definition_TextFile textFile = new Definition_TextFile (file);

        textFile.addLineSuffix (NAME_PREFIX, Attributes.PATIENT);
        textFile.addLines (2, line -> false, Attributes.BODY);

        final Map<String, String> attributes = textFile.getAttributes();

        attributes.put(Attributes.TYPE, "REPORT");

        return new Document(attributes);
    }
}
