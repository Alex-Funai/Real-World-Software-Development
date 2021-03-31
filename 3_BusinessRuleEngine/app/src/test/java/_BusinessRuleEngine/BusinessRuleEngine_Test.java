///////////////////////////////////////////////////////////////////////////////
// Main Class File: 'BusinessRuleEngine.java'
// File: 'BusinessRuleEngine_Test.java'
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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;


/**
 * Represents a Business Rule Engine.

 * @author       Rauol-Gabriel Urma & Richard Warburton
 * @version      1.0
 */
public class BusinessRuleEngine_Test {


    private final List<Facts> facts = new ArrayList<>();



    @Test
    public void shouldHaveNoRulesInitially() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(null);     // initializes business-
                                                                                    // rule-engine to test.
        assertEquals(2, businessRuleEngine.count());
    }

    /**
     * Description: Verifies that two actions can be added to the rule engine.
     */
    @Test
    public void shouldAddTwoActions() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(null);     // Initializes business-
                                                                                    // rule-engine to test.
        businessRuleEngine.addAction((rule) -> {});
        businessRuleEngine.addAction((rule) -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    /**
     * Creates a mock object and verifies an Action is executed.
     *

     */
    @Test
    public void shouldExecuteOneAction() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(null);     // Initializes the BRE (base).

        final Action mockAction = mock(Action.class);       // Initializes a mock-action
                                                                                // using the interface_action.
        businessRuleEngine.addAction(mockAction);       // Adds and runs
        businessRuleEngine.run();                       // the mock-action.

        verify(mockAction).perform(null);       // Verify the perform() method
                                            // is invoked on the Action object.
    }

    /**
     * Creates a mock object and verifies an Action is executed.
     *

     */
    @Test
    public void shouldPerformAnActionWithFacts() {
        final Action mockAction = mock(Action.class);
        final Facts mockFacts = mock(Facts.class);
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).perform(mockFacts);
    }
}
