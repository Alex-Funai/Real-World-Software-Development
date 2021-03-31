

import org.junit.Test;


import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import _BusinessRuleEngine.*;

public class InspectorTest {

    @Test
    public void inspectOneConditionEvaluatesTrue() {

        final Facts facts = new Facts();
        facts.setFact("jobTitle", "CEO");
        final ConditionalAction conditionalAction = new JobTitleCondition();
        final Inspector inspector = new Inspector(conditionalAction);

        final List<Report> diagnosisList = inspector.inspect(facts);

        assertEquals(1, diagnosisList.size());
        assertTrue(diagnosisList.get(0).isPositive());


    }

    private static class JobTitleCondition implements ConditionalAction {

        @Override
        public void perform(Facts facts) {

        }

        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFact("jobTitle"));
        }
    }
    
}