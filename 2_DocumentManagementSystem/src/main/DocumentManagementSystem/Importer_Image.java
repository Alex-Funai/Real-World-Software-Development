package DocumentManagementSystem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static DocumentManagementSystem.Attributes.PATH;
import static DocumentManagementSystem.Attributes.TYPE;
import static DocumentManagementSystem.Attributes.WIDTH;

class Importer_Image implements Importer {

    @Override
    public Document importFile(final File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(TYPE, "IMAGE");

        return new Document(attributes);
    }
}
