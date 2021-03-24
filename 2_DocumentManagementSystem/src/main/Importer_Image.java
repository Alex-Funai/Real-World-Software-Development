import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.grpc.netty.shaded.io.netty.handler.codec.http.cookie.CookieHeaderNames.PATH;
import static javax.swing.SpringLayout.WIDTH;
import static javax.xml.crypto.dsig.SignatureProperties.TYPE;

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
