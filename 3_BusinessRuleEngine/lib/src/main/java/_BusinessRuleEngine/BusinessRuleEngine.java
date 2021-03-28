///////////////////////////////////////////////////////////////////////////////
// Title: The Business Rule Engine
// Files:
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

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Business Rule Engine.
 *
 * Bugs: none known
 *
 * @author       Rauol-Gabriel Urma & Richard Warburton
 * @version      1.0
 * @see also     addAction, count, run
 */
    public class BusinessRuleEngine {

        private final List<interface_Action> actions;       // Initialize list for
                                                            // engine-action storage.
    /**
     * Add an action to the engine.
     *
     * @param action The action to add.
     */
    public BusinessRuleEngine() {

        this.actions = new ArrayList<>();       // Initializes a new
                                                // arraylist for actions.
    }

    /**
     * Add an action to the engine.
     *
     * @param action The action to add to the list.
     */
    public void addAction (final interface_Action action) {

        this.actions.add(action);       // Adds the action(s) to
                                        // the 'this.actions' arraylist.
    }

    /**
     * Count the number of actions.
     *
     * @param count counts the number actions.
     * @return the number of actions last executed.
     */
    public int count() {
        return this.actions.size();
    }

    /**
     * Runs engine-actions.
     *
     * @param run executes the stored actions.
     * @throws run UnsupportedOperationException
     */
    public void run() {
        throw new UnsupportedOperationException();
    }

}
