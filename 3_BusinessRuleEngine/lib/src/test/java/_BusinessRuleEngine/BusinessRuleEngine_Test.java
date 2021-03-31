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
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;


/**
 * Represents a Business Rule Engine.
 *
 * Bugs: none known
 *
 * @author       Rauol-Gabriel Urma & Richard Warburton
 * @version      1.0
 * @see also     shouldHaveNoRulesInitially, shouldAddTwoActions
 */
public class BusinessRuleEngine_Test {

    /**
     * Verifies that there aren't any rules initially.
     *
     * @testcase shouldHaveNoRulesInitially
     *
     * @precondition none
     *
     * @userInteraction
     * <li>
     * </li>
     * @postcondition
     * @passCriteria
     */
    @Test
    public void shouldHaveNoRulesInitially() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();     // initializes business-
                                                                                    // rule-engine to test.
        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    /**
     * Description: Verifies that two actions can be added to the rule engine.
     *
     * @testcase
     *
     * @precondition none
     *
     * @userInteraction
     * <li>
     *
     * </li>
     * @postcondition
     *
     * @passCriteria
     */
    @Test
    public void shouldAddTwoActions() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();     // Initializes business-
                                                                                    // rule-engine to test.
        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    /**
     * Creates a mock object and verifies an Action is executed.
     *
     * @testcase
     *
     * @apiNote org.mockito-2.2-all
     *
     * @precondition none
     *
     * @userInteraction
     * <li>
     *
     * </li>
     * @postcondition
     *
     * @passCriteria
     */
    @Test
    void shouldExecuteOneAction() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();     // Initializes the BRE (base).

        final Action mockAction = mock(Action.class);       // Initializes a mock-action
                                                                                // using the interface_action.
        businessRuleEngine.addAction(mockAction);       // Adds and runs
        businessRuleEngine.run();                       // the mock-action.

        verify(mockAction).perform();       // Verify the perform() method
                                            // is invoked on the Action object.
    }

    /**
     * Creates a mock object and verifies an Action is executed.
     *
     * @testcase
     *
     * @apiNote org.mockito-2.2-all
     *
     * @precondition none
     *
     * @userInteraction
     * <li>
     *
     * </li>
     * @postcondition
     *
     * @passCriteria
     */
    @Test
    public void shouldPerformAnActionWithFacts() {
        final Action mockAction = mock(Action.class);
        final Facts mockFacts = mock(Facts.class);
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockedFacts);

        businessRuleEngine.addActions(mockActions);
        businessRuleEngine.run();

        verify(mockAction).perform(mockFacts);
    }
}
