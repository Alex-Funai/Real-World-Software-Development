

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Takes a list of conditional action objects and evaluates them based on some facts.
 * Returns a list of reports that capture the facts, the conditional actions, and the result.
 *
 * @author Rauol-Gabriel Urma & Richard Warburton
 */
public class Inspector {

    private final List<ConditionalAction> conditionalActionList;

    public Inspector (final ConditionalAction...conditionalActions) {

        this.conditionalActionList = Arrays.asList(conditionalActions);
    }


    /**
     * @param facts
     *
     * @return The list of reports that captures the facts, the conditional act, and the result.
     */
    public List<Report> inspect (final Facts facts) {

        final List<Report> reportList = new ArrayList<>();

        for (ConditionalAction conditionalAction : conditionalActionList) {

            final boolean conditionResult = conditionalAction.evaluate(facts);

            reportList.add(new Report(facts, conditionalAction, conditionResult));
        }
        return reportList;
    }
}
