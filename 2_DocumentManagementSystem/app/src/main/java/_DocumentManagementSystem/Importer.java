// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Importer" interface serves as a framewoork to intake the other specific file type interfaces into . It promotes de-coupling, and cohesive legibility.
 *  Other alternatives to structuring thise type of program could be:
 *  1. Using a utility class.
 *  2. Use inheritance.
 *  3. Use a domain class.  */

// JDK Framework:


package _DocumentManagementSystem;

import java.io.File;
import java.io.IOException;


interface Importer {

    Document importFile(File file) throws IOException;
}
