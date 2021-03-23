// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

package BankStatementAnalyzer;

/*  After analyzing the data, this SummaryStatistics will be created as a "Domain-Object" for storing valuable data
 *  that will be further analyzed using the methods we created in the "BankTransactionProcessor" class.
 *  A domain object is an instance of a class that is related to our domain. This is a form of decoupling, and allows us
 *  to export additional infromation by including it as part of this class without having to introduce cascading changes.
 * Another ideal solution would be to create a "Report" that could handle all different data types our methods process.
 *  The main thing to consider is thatt, the program's various methods handle and return different data types,; some are lists,
 * some are doubles, etc... We would need to refactor the program, if we specifically used one data-type such as find(transaction), thus
 *  the Report or Statistics solution is ideal.
 */

public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;

    SummaryStatistics(final double sum, final double max, final double min, final double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
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

