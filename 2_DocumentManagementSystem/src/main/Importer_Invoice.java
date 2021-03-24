import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Importer_Invoice {

    void addLineSuffix(final String prefix, final String attributeName) {
        for (final String line: lines) {
            if (line. startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length() ));
                break;
            }
        }
    }

    @Override
    public Document importFile(final File file) throws IOException {
        final Definition_TextFile textFile = new Definition_TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "INVOICE");
        return new Document(attributes);
    }
}
