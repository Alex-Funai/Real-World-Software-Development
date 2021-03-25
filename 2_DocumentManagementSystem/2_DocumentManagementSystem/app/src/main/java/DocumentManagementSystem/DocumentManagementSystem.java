// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System


package java.DocumentManagementSystem;

// JDK Framework::
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


    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

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
    public List<Document> contents() {
        return documentsView;
    }

    public List<Document> search(final String query) {
        return documents.stream().filter(Query.parse(query)).collect(Collectors.toList());
    }
}
