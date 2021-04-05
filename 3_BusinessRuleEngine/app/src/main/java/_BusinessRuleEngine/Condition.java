///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: Condition.java
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

/**
 * Fact check state.
 */
@FunctionalInterface
public interface Condition {

    /**
     * Evaluates if a fact is true/false to a business.
     * @param facts
     * @return true/false.
     */
    boolean evaluate (Facts facts);
}
