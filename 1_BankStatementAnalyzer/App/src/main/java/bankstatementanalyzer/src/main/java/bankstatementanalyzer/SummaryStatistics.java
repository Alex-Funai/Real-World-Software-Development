// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

/*  After analyzing the data, this SummaryStatistics will be created as a "Domain-Object" for storing valuable data
 *  that will be further analyzed using the methods we created in the "BankTransactionProcessor" class.
 *  A domain object is an instance of a class that is related to our domain. This is a form of decoupling, and allows us
 *  to export additional infromation by including it as part of this class without having to introduce cascading changes.
 * Another ideal solution would be to create a "Report" that could handle all different data types our methods process.
 *  The main thing to consider is thatt, the program's various methods handle and return different data types,; some are lists,
 * some are doubles, etc... We would need to refactor the program, if we specifically used one data-type such as find(transaction), thus
 *  the Report or Statistics solution is ideal.
 */
package src.main.java.bankstatementanalyzer;

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

    SummaryStatistics(final double sum, final double max, final double min, final double average) {

        this.sum = sum;         // Encapsulating the
        this.max = max;         // variable data, to
        this.min = min;         // isolate summaries
        this.average = average; // to each parse.
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }
}

