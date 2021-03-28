///////////////////////////////////////////////////////////////////////////////
// Main Class File: 'BusinessRuleEngine.java'
// File: '_BusinessRuleEngine_BasicTests.java'
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
import static _BusinessRuleEngine.interface_Action;

/**
 * Represents a Business Rule Engine.
 *
 * Bugs: none known
 *
 * @author       Rauol-Gabriel Urma & Richard Warburton
 * @version      1.0
 * @see also     shouldHaveNoRulesInitially, shouldAddTwoActions
 */
public class _BusinessRuleEngine_BasicTests {

    /**
     * Description:
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
     * Description:
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

        final interface_Action mockAction = mock(interface_Action.class);       // Initializes a mock-action
                                                                                // using the interface_action.
        businessRuleEngine.addAction(mockAction);       // Adds and runs
        businessRuleEngine.run();                       // the mock-action.

        verify(mockAction).perform();       // Verify the perform() method
                                            // is invoked on the Action object.
    }
}
