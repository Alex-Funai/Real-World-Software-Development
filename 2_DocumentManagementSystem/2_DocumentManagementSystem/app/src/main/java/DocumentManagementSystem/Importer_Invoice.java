// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Importer_Invoice" class is a framework for importing ".invoice" files, and is leveraged  into the Importer
 *  interface (which serves as the main handler for the various importerse of different file types). This demonstrates utilizing
 *  good principle of decoupling, and anticipation for positive code-usability, because we can modify each specific importer class
 *  individually to adjust accordingly as the program evolves.  */

package java.DocumentManagementSystem;
// JDK Framework::
import java.io.File;
import java.io.IOException;
import java.util.Map;

class Importer_Invoice implements Importer {

     private static final String NAME_PREFIX = "Dear ";
     private static final String AMOUNT_PREFIX = "Amount: ";


    @Override
    public Document importFile(final File file) throws IOException {
        /* Since the Importer_Invoice class presumably is importing a ".invoice" file -- we can safely assume that it is a text file,
         * and given that -- we can use our "Document" class as a method and structure for importing it.   */

        final Definition_TextFile textFile = new Definition_TextFile(file);
        final Map<String, String> attributes = textFile.getAttributes();


        textFile.addLineSuffix(NAME_PREFIX, Attributes.PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, Attributes.AMOUNT);
        /*  In this example (compared to the "Importer_Image" class) we reference the variables from "Attributes" class
         *  without importing them in the header. Instead the methods are pre-fixed by their class name. This could potentially
         *  increase or decrease eligiblity depending on the coder, and honestly I sort of like it better this way, because it's distinct.  */

        attributes.put(Attributes.TYPE, "INVOICE");


        return new Document(attributes);
    }
}
