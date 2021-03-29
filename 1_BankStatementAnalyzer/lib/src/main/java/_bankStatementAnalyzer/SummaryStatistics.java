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
    private final double max;       // values of the sum, max,
    private final double min;       // min, averagecalculations
    private final double average;   // that occur below in SummaryStatistics().

    /**
     * SummaryStatistics creates an extended domain class that stores,
     * and return a statements' transaction: total, max,
     * min, and average value.
     *
     * @implNote '.this' for encapsulating return values.
     *
     * @param sum Total amount for transactions.
     * @param max Largest transaction amount.
     * @param min Lowest transaction amount.
     * @param average Average transaction amount.
     *
     * @return sum
     * @return max
     * @return min
     * @return average
     */
    SummaryStatistics(final double sum, final double max, final double min, final double average) {

        this.sum = sum;         // Encapsulating the
        this.max = max;         // variable data, to
        this.min = min;         // isolate values of
        this.average = average; //'class.SummaryStatistics'.
    }

    public double getSum() { return sum; }          // Creating methods for returning
    public double getMax() {
        return max;
    }          // the encapsulated values for:
    public double getMin() {
        return min;
    }          // the statement's sum, max/min
    public double getAverage() {
        return average;
    }  // and average values.
}

