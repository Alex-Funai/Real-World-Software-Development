package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import static  javax.lang.model.type.UnknownTypeException.;
import  java.io.FileExc

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

    public List <Document> contents() {
        /...
    }

    public List<Document> search(final String query) {
        / ...
    }

    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf('.');
        if  (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new FileNotFoundException("No extension found for file:" + path);
            }
            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);
            if (importer == null) {
                throw new FileFormatException("For file: " + path);
            }

            final Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new FileFormatException("No extension  found for file: " + path);
        }
    }
    // end::importFile[]
}
