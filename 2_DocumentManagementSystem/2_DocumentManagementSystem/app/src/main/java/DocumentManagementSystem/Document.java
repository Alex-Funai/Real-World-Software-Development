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

    private final Map<String, String> attributes;

    Document (final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
