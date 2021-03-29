///////////////////////////////////////////////////////////////////////////////
// Main Class File: Main_Application.java
// File: BankStatementProcessor.java
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

/******************************************************************************
 * @apiNote .BankStatementProcessor
 * Methods from this class can be reused else where in the project w/o
 * depending on .BankStatementAnalyzer.
 * <p>
 * @apiNote
 ******************************************************************************/

package _bankStatementAnalyzer;
import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Processes a list of bank transactions.
 * @see BankStatementAnalyzer
 *
 * @author :Raoul-Gabriel Urma & Richard Warburton
 */
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;   // Initializes a list of
                                                            // bank transactions as an object.
    /**
     * Processes a bank statement and it's transactions list.
     *
     * @param bankTransactions :A list of bank transactions.
     */
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {

        this.bankTransactions = bankTransactions;   // Encapsulate the transaction (date, amount, description).
    }

    /**
     * Summarizes bank statement's transactions.
     *
     * @return (getSum, getMax, getMin, getAverage) :The sum, maximum, minimum, and average transaction value.
     */
    public SummaryStatistics summarizeTransactions() {

        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions
                .stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }

    /**
     * Summarizes bank statement's transactions.
     *
     * @return (getSum, getMax, getMin, getAverage) :The sum, maximum, minimum, and average transaction value.
     */
    public double summarizeTransactions (final Interface_BankTransactionSummarizer bankTransactionSummarizer) {

        double result = 0;

        for (final BankTransaction bankTransaction: bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    /**
     * Calculates total transaction amount
     * for a specified month.
     *
     * @param (month) :The month you want to analyze.
     *
     * @return (total) :The accumulated transaction amount for the month.
     */
    public double calculateTotalInMonth(final Month month) {

        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount(): acc);
    }

    /**
     * Find transactions >= specified value.
     *
     * @return (amount) :The transactions greater-or-equal to specified amount.
     */
    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    /**
     * Summarizes a bank statement's transactions.
     *
     * @return (getSum, getMax, getMin, getAverage) :The sum, maximum, minimum, and average transaction value.
     */
    public List<BankTransaction> findTransactions(final Interface_BankTransactionFilter bankTransactionFilter) {

        final List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
    /**
     * Calculates the total accumulative
     * value of a list of bank transactions.
     *
     * @return (total) :The total value of transactions.
     */
    public double calculateTotalAmount() {

        double total = 0;   // Resets total value to zero in-case,
                            // it's been set by other methods.

        for (final BankTransaction bankTransaction : bankTransactions) {    // Loop through a
                                                                            // transaction list.

            total += bankTransaction.getAmount();   // Accumulate transaction values
                                                    // to total while looping.
        }
        return total;   // Return the total amount
                        // for the transaction list.
    }





    /**
     * Calculates total transaction amount,
     * for a specified category/description.
     *
     * @param (category) :The category/description to analyze.
     *
     * @return (total) :The accumulated transaction amount for the category/description.
     */
    public double calculateTotalForCategory(final String category) {

        double total = 0;   // Resets total value to zero in-case,
                            // it's been set by other methods.

        for (final BankTransaction bankTransaction : bankTransactions) {    // Loops through a transaction list.

            if (bankTransaction.getDescription().equals(category)) {    // Asserts loop to continue -- only if the
                                                                        // transaction month = month passed into method.

                total += bankTransaction.getAmount();   // If yes, then accumulate transactions
                                                        // to the total varaible, and continue loop.
            }
        }
        return total;
    }



    /* This method is less desireable, because it combines multiple operations of a bank transaction.
     *  This method is less desireable, because the "selection-logic" is coupled w ith the "iteration-logic".
     *  If the previous 2 test methods stand, then this is redundant.
     *
     *  [SOLUTION]: Implement a BankTransactionFilter interface to couple the BankTransaction class.
     *  The BankTransactionFilter we'll entail all the properties of the BankTransaction class, and return a boolean.
     *  This would be a functional interface.
     *  [Functional Interface] --- A functional interface, is an interface that only contains a single abstract method.
     *  A functional interface is notated by using the "FunctionalInterface" annotation to clarify the interface's intent.
     */



}