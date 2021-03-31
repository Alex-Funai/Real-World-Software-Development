///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: Report.java
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

public class Report {

    private final ConditionalAction conditionalAction;

    private final Facts facts;

    private final boolean isPositive;

    /**
     * Default report structure.
     * @param facts
     * @param conditionalAction
     * @param isPositive
     */
    public Report (
            final Facts facts,
            final ConditionalAction conditionalAction,
            final boolean isPositive) {

        this.facts = facts;

        this.conditionalAction = conditionalAction;

        this.isPositive = isPositive;
    }

    /**
     * Get the conditional action.
     * @return
     */
    public ConditionalAction getConditionalAction() {

        return conditionalAction;
    }

    /**
     * Get the set facts.
     * @return List<Facts>
     */
    public Facts getFacts() {

        return facts;
    }

    /**
     * Validate positive.
     * @return true/false.
     */
    public boolean isPositive() {

        return isPositive;
    }

    /**
     * View report analysis as strings.
     * @return Report
     */
    @Override
    public String toString() {

        return "Report{" + "conditionalAction=" + conditionalAction + ", facts="
                + facts + ", result =" + ", result=" + isPositive + '}';
    }
}
