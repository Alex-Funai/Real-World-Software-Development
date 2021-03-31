package _BusinessRuleEngine;

import org.junit.Test;

import java.util.List;


import static org.junit.Assert.assertEquals;

public class InspectorTest {

    @Test
    public void inspectOndConditionEvaluatesTrue() {

        final Facts facts = new Facts();

        facts.setFact("jobTitle", "CEO");

        final ConditionalAction conditionalAction = new JobTitleCondition();

        final Inspector inspector = new Inspector(conditionalAction);

        final List<Report> reportList = inspector.inspect(facts);

        assertEquals(1, reportList.size());

        assertEquals(true, reportList.get(0).isPositive());
    }

    private static class JobTitleCondition implements ConditionalAction {

        @Override
        public void perform (Facts facts) {

            throw new UnsupportedOperationException();
        }

        @Override
        public boolean evaluate (Facts facts) {

            return "CEO".equals(facts.getFact("jobTitle"));+
        }
    }
}
