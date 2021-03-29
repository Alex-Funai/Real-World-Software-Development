///////////////////////////////////////////////////////////////////////////////
// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

package _bankStatementAnalyzer;

/**
 * After analyzing the data,  'class.SummaryStatistics' will be created as a domain-object for storing data
 * that will be further analyzed using the methods we created in the 'class.BankTransactionProcessor'.
 * A domain object is an instance of a class that is related to our domain. This is a form of decoupling,
 * and allows us to export additional infromation by including it as part of this class without having to introduce
 * cascading changes. Another ideal solution would be to create a "Report" that could handle all different data types
 * our methods process. The main thing to consider is thatt, the program's various methods handle and return different
 * data types; some are lists, some are doubles, etc... We would need to refactor the program, if we specifically used
 * one data-type such as find(transaction), thus this solution is ideal.
 *
 * <p>Bugs: n/a
 *
 * @author akfunai
 */
public class SummaryStatistics {

    private final double sum;       // Initialization/storage for
    private final double max;       // (sum, max, min, average)
    private final double min;       // values, for the object
    private final double average;   // '.SummaryStatistics'

    /**
     * SummaryStatistics creates a domain object that stores
     * list<transaction> data: (total, max, min, average).
     *
     * @see .this Encapsulates return values through loop iterations.
     *
     * @param sum Total amount for transactions.
     * @param max Largest transaction amount.
     * @param min Lowest transaction amount.
     * @param average Average transaction amount.
     */
    SummaryStatistics(final double sum, final double max, final double min, final double average) {

        this.sum = sum;         // Encapsulating:
        this.max = max;         // (sum, max, min, average)
        this.min = min;         // variable values through
        this.average = average; // each loop iteration.
    }
    /**
     * getSum() Stores accumulative transactions' value.
     *
     * @return (sum) The accumulative transactions' value.
     */
    public double getSum() {
        return sum;
    }
    /**
     * getMax() Stores maximum transaction value.
     *
     * @return (average) The average transaction value.
     */
    public double getMax() {
        return max;
    }
    /**
     * getMin() Stores minimum transaction value.
     *
     * @return (min) The smallest transaction value.
     */
    public double getMin() {
        return min;
    }
    /**
     * getAverage() Stores average transaction value.
     *
     * @return (average) The average transaction value.
     */
    public double getAverage() {
        return average;
    }
}

