import com.intellij.openapi.fileTypes.UnknownFileType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

interface Importer {

    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf(',');
        if (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new UnknownFileType("No extension found for file: " + path);
            }

            final String extension = path.substring(separatorIndex +1);
            final Importer importer = extensionToIMporter.get(extension);
            if (importer == null) {
                throw new UnknownFileType("For file: " + path);
            }
            final Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new UnknownFileType("No extension found for file: " + path);
        }
    }

    public static final String PATH = "path";

    Document ImportFile(File file) throws IOException;

    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter("letter", new LetterImporter());
        extensionToImporter("report", new ReportImporter());
        extensionToImporter("jpg", new ImageImporter());
    }


}
