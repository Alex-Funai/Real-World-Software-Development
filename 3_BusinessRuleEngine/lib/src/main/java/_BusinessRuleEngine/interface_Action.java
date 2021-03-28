///////////////////////////////////////////////////////////////////////////////
// Main Class File: (name of main application class)
// File: 'interface_Action.java'
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
 *
 * Bugs: none known
 *
 * @author       Rauol-Gabriel Urma & Richard Warburton
 * @version      1.0
 * @see also     execute
 */
@FunctionalInterface
public interface interface_Action {

    /**
     * Executes a BRE action.
     *
     * @param none none
     */
    void execute();
}
