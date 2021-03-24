package DocumentManagementSystem;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DocumentManagementSystem {
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentsView = Collections.unmodifiableList(documents);
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new Importer_Letter());
        extensionToImporter.put("report", new Importer_Report();
        extensionToImporter.put("jpg", new Importer_Image());
        extensionToImporter.put("invoice", new Importer_Invoice());
    }

    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        
    }

}
