///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: _BusinessRuleEngine.*
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
 * @see     BusinessRuleEngine, addAction, count, run
 */
    public class BusinessRuleEngine {

        private final List<Action> actions;

        private final List<Rule> rules;

        private final Facts facts;



    /**
     * List of business facts.
     *
     * @param facts :List of business facts.
     */
    public BusinessRuleEngine ( Facts facts) {

        this.facts = facts;

        this.rules = new ArrayList<>();

        this.actions = new ArrayList<>();
    }

    /**
     * Add an action to the engine.
     *
     * @param action :List of business actions.
     */
    public void addAction (final Action action) {

        this.actions.add (action);       // Adds the action(s) to
                                        // the 'this.actions' arraylist.
    }

    /**
     * Add rules
     * @param rule :List of business rules.
     */
    public void addRule (final Rule rule) {

        this.rules.add (rule);
    }

    /**
     * Count the number of actions.

     */
    public int count() {

        return this.actions.size();
    }

    /**
     * Runs engine-actions.

     */
    public void run() {

        this.actions.forEach (action -> action.perform (facts));
    }

    public void run2() {

        this.rules.forEach (rule -> rule.perform (facts));
    }

}
