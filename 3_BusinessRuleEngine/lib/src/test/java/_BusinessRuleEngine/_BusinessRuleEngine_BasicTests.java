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
import static junit.framework.Assert.assertEquals;

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
     * Executes an action in the Business Rules Engine.
     *
     * @param execute The execution process.
     * @return (description of the return value)
     */
    @Test
    void shouldHaveNoRulesInitially() {

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();     // initializes business-
                                                                                    // rule-engine to test.
        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    /**
     * Executes an action in the Business Rules Engine.
     *
     * @param execute The execution process.
     * @return (description of the return value)
     */
    @Test
    void shouldAddTwoActions() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();     // Initializes business-
                                                                                    // rule-engine to test.
    }
}
