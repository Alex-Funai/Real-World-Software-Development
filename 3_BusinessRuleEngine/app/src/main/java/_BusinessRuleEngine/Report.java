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




public class Report {

    private final ConditionalAction conditionalAction;

    private final Facts facts;

    private final boolean isPositive;

    public Report (
            final Facts facts,
            final ConditionalAction conditionalAction,
            final boolean isPositive) {

        this.facts = facts;

        this.conditionalAction = conditionalAction;

        this.isPositive = isPositive;
    }

    public ConditionalAction getConditionalAction() {

        return conditionalAction;
    }

    public Facts getFacts() {

        return facts;
    }

    public boolean isPositive() {

        return isPositive;
    }

    @Override
    public String toString() {

        return "Report{" + "conditionalAction=" + conditionalAction + ", facts="
                + facts + ", result =" + ", result=" + isPositive + '}';
    }
}
