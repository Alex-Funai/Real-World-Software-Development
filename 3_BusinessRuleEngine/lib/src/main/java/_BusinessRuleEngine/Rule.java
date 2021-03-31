package _BusinessRuleEngine;



/**
 * Modeling the concept of a rule.
 *
 * @author (Rauol-Gabriel Urma & Richard Warburton)
 */
@FunctionalInterface
public interface Rule {

    void perform (Facts facts);
}

public class DefaultRule implements Rule {

    private final Condition condition;

    private final Action action;


    public Rule (final Condition condition, final Action action {

        this.condition = condition;

        this.action = action;
    }

    public void perform (final Facts facts) {

        if (condition.evalute(facts)) {

            action.execute(facts);
        }
    }
}
