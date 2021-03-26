// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Document" class is an object framework for structuring different text file types, and is called by our various "Importer"
*   classes -- to define them.  Intential creation of the "Document" class with the Importer -- instead of having "Document" extend HashMap
*  is an example of using the [Liskov Substitution Principle (LSP)]. The Liskov Substitution Principle divides a program into "types"
*  and "sub-types", or more simply classes/interfaces, and extensions/implementations. More complicated t his is what the LIskov Substitution Principle (LSP) is:
*   LSP --- Let q(x) be a property provable about objects x of type T. Then q(y) should be true for objects y of type S where S is a subtype of T.
 */

/*  Rules of the Liskov Substitution Principle (LSP)::
 *  1.  Preconditions cannot be strenghtened in a subtype.
 *  2.  Postconditions cannot be weakened in a subtype.
 *  3.  Invariants of the supertype must be preserved in a subtype.
 *  4.  The History Rule -- the class is immutable and should retain the same behavior through the program.
 */

package java.DocumentManagementSystem;

// JDK Framework:
import java.util.Map;


public class Document {

    // Initializing a map for the various document attributes that will need to retain key pair associations through the programs' life-cycle.
    private final Map<String, String> attributes;

    // Initializing a "Document" to be parsed.
    Document (final Map<String, String> attributes) {
        // Isolating variable storage internally for each Document, as the program is intended for scanning multiple documents at once.
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        /* In case the case of data-structure type Map with the method-argument "get" -- we are returning the value associated to the key-pairing
         *  In this case it the value should retrun the attribute's name as a string, and not the reference variable that is associated as pair [0] in the pairing.
         */
        return attributes.get(attributeName);
    }
}
