///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: Action.java
// Date: March 28, 2021
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
 * Functional interface for decoupling the Business Rules Engine.

 * @author       Rauol-Gabriel Urma & Richard Warburton
 */
@FunctionalInterface
interface Action {
    /**
     * Executes a rule action.
     *
     * @param facts :list of business facts.
     */
    void execute (Facts facts);
}
