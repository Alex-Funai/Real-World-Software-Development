///////////////////////////////////////////////////////////////////////////////
// Title: The Business Rule Engine
// File: RuleBuilder.java
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
 * Builder for creating rule objects with the appropriate condition and action. You can use this class
 * to create RuleBuilder then configure a rule using the methods when(), then(), and createRule().
 *
 * @author (Rauol-Gabriel Urma & Richard Warburton)
 */
public class RuleBuilder {

    private Condition condition;



    /**
     * Supplies condition to a created rule.
     * @param condition :the condition supplied.
     */
    private RuleBuilder (Condition condition) {
        this.condition = condition;
    }

    /**
     * Supplies the action to a create rule.
     * @param action :the action supplied.
     */
    public static RuleBuilder when (Condition condition) {

        return new RuleBuilder (condition);
    }

    /**
     * Creating a default rule object.
     */
    public Rule then (Action action) {

        return new Rule (condition, action);
    }
}
