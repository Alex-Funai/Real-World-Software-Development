// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

package java.DocumentManagementSystem;

// JDK Framework:
import java.io.File;
import java.io.IOException;


interface Importer {

    Document importFile(File file) throws IOException;
}
