// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Importer_Report" class is a framework for importing ".report" files, and is leveraged  into the Importer
 *  interface (which serves as the main handler for the various importerse of different file types). This demonstrates utilizing
 *  good principle of decoupling, and anticipation for positive code-usability, because we can modify each specific importer class
 *  individually to adjust accordingly as the program evolves.
 */

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
