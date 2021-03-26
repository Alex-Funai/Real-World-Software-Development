// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Exception_UnknownFileTypeException" is a utility class dedicated to storing the handling of outputting a message.
 *  The Exception is unspeecified in JDK, JUnit, and HamCrest, but is available through third party API/Library imports, if this
 *  technique doesn't suffice proficienct.  */

package java.DocumentManagementSystem;

/*RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.
 * RuntimeException and its subclasses are unchecked exceptions. Unchecked exceptions do not need to be declared in a method or constructor's throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
 *  Since: 1.0
 * Author:Frank Yelli   */

public class Exception_UnknownFileTypeException extends RuntimeException {

    public Exception_UnknownFileTypeException (final String message) {
        super (message);
    }
}
