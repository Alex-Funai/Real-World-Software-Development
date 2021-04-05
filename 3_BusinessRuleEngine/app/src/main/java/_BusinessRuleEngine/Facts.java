///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: Facts
// Date: March 31, 2021
//
// Author: Alexander Kitaro Funai
// Email: alexanderfunai@protonmail.com
// Book Author: Rauol-Gabriel Urma & Richard Warburton
// Book Title: Real-World Software Development
// Book Section: Chapter 5
//
////////////////////////////////////////////////////////////////////////////////
// Online sources: "github.com/Iteratr-Learning/Real-World-Software-Development"
////////////////////////////////////////////////////////////////////////////////

package _BusinessRuleEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * Domain for methods operating on Facts.
 *
 * @author Rauol-Gabriel Urma & Richard Warburton.
 */
public class Facts {
    

    private final Map<String, String> facts = new HashMap<>();  // Map for facts/conditional-state of fact check.


    /**
     * Parse for a fact in the list.
     * @param name
     * @return name of listed fact.
     */
    public String getFact (String name) {

        return this.facts.get (name);
    }

    /**
     * Adds a facts to the list.
     * @param name
     * @param value
     */
    public void addFact (String name, String value) {

        this.facts.put (name, value);
    }

    /**
     * Sets a fact for analysis.
     * @param name
     * @param value
     */
    public void setFact (final String name, final String value) {

        this.facts.put (name, value);
    }
}
