// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "DocumentManagementSystem" class serves as a Framework for importing all different file types, and manages the input of different filetypes, and their
 *  initialization of most efficient data structures.   List is used to intake the files, as it will query them without specifications, and HashMap is utilized to manage the
 *  parsed file type (as an indiscriminate string), and the unique data as key-pairs. This ensures that our "Attributes" data remains correlated to the correct references
 *  through the program's cycle.    */


// JDK Framework::

package _DocumentManagementSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Collections.unmodifiableList;


public class DocumentManagementSystem {

    // [4] - Declaring/initializing data structures to
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentsView = unmodifiableList(documents);
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {

        // [4-6] - Registering the Importers.
        extensionToImporter.put("letter", new Importer_Letter());
        extensionToImporter.put("report", new Importer_Report());
        extensionToImporter.put("jpg", new Importer_Image());
    }
    {
        extensionToImporter.put("invoice", new Importer_Invoice());
    }


    // Methodo for importing different filetypes, and exceptions if the file does not exist, or the extension is unmanaged.
    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        // Method for specifying the delimiter variable to be used -- which in this case is a comma.
        final int separatorIndex = path.lastIndexOf('.');
        if (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new Exception_UnknownFileTypeException("No extension for file found: " + path);
            }
            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);
            if (importer == null) {
                throw new Exception_UnknownFileTypeException("For file: " + path);
            }
            final Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new Exception_UnknownFileTypeException("No extension  found for file: " + path);
        }
    }

    // Method for returning the contents.
    public List<Document> contents() {

        return documentsView;
    }

    // Method for searching an "Attribute" type in a Document
    public List<Document> search(final String query) {

        return documents.stream().filter(Query.parse(query)).collect(Collectors.toList());
    }
}
