// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System


// Package:
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
