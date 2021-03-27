package DocumentManagementSystem;// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Importer_Image" class is a framework for importing ".image" files, and is leveraged  into the Importer
 *  interface (which serves as the main handler for the various importerse of different file types). This demonstrates utilizing
 *  good principle of decoupling, and anticipation for positive code-usability, because we can modify each specific importer class
 *  individually to adjust accordingly as the program evolves.  */

// JDK Framework::
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Class Framework:
import static DocumentManagementSystem.Attributes.HEIGHT;
import static DocumentManagementSystem.Attributes.PATH;
import static DocumentManagementSystem.Attributes.TYPE;
import static DocumentManagementSystem.Attributes.WIDTH;

/*  Instead of independently importing the classes by calling the package > class > method
 *  you could also call the class name as a method prior to the class name within the body of this class.
 *  The package is already included  in the header, so technically you wouldn't need to import, but we choose to
 *  do so here, as  to improve the eligiblity of the code  (Example:   "Attributes.WIDTH" ||   "Attributes.PATH").  */

class Importer_Image implements Importer {

    @Override
    public Document importFile(final File file) throws IOException {

        /*  We initialize a HashMap here of two string variables, which serves as a template for
         *  HashMaps are two variables data-pairs in an associative array structure that "maps-keys" together, and keeps
         * them together. This is ideal for assuring our variable values stay paired to their assigned definitions. */
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());

        /*  The method valueOf returns an integer as a string data-type since. This is ideal so we can resolve our program
         *  in future classes/methods using a common data-type -- instead of having to handle type-discrepancies.
         * The BuffferedImage and ImageIO classes, allow us to render an ".image" type file and return it's integer also as a string.   */
        final BufferedImage image = ImageIO.read(file);
        attributes.put (WIDTH, String.valueOf(image.getWidth()));
        attributes.put (HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "IMAGE");


        return new Document(attributes);
    }
}
