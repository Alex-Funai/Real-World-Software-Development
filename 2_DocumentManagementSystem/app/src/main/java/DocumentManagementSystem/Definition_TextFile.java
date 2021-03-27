package DocumentManagementSystem;// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Definition_TextFile" class is a domain class. This domain class allows us to manipulate the contents of a textFile, models
 *  the underlying concepts of a text file, and provides asesociated methods for extracting data from text files.   */


// JDK Framework::
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;


class Definition_TextFile {

    // Declaration/Initialization:
    private final Map<String, String> attributes;
    private final List<String> lines;
    /*   1.  Map for storing key-pair attributes to their unparsed reference variables.
     *   2.  List to add the "Document" information, and store each line to a unique referenceable array value.  */

    Definition_TextFile(final File file) throws IOException {
        attributes = new HashMap<>();
        attributes.put(Attributes.PATH, file.getPath());
        lines = Files.lines(file.toPath()).collect(toList());
    }

    // Method for returning the "Attributes" in parsed string form.
    Map<String, String> getAttributes() {

        return attributes;
    }

    int addLines(final int start, final Predicate<String> isEnd, final String attributeName) {
        /* The "addLines" method is utilized by the different Importer classes/interface. It begins by starting an index for initializing the scan,
         *  and an "isEnd" method for initializing when the scan reaches the end of the line. "isEnd" is stored as a boolean variable, and returns true,
         *  if the scan reaches the end of the line.    */

        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get (lineNumber);
            if (isEnd.test (line)) {
                break;
            }
            accumulator.append (line);
            accumulator.append("\n");
        }
        attributes.put (attributeName, accumulator.toString().trim());
        return lineNumber;
    }

    void addLineSuffix (final String prefix, final String attributeName) {
        for (final String line : lines) {
            if (line.startsWith(prefix)) {
                attributes.put (attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
}

