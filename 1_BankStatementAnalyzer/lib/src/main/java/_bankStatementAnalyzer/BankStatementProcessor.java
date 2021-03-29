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
 * @apiNote bankTransactions
 * We intialize and declare a List interface to the variable "bankTransactions" by importing our initial list of data.
 * Again we utilize private/final to anticipate the repitition of this class when it runs through several transactions,
 * each list being represented as a line of data.
 * <p>
 * @apiNote
 ******************************************************************************/

package _bankStatementAnalyzer;
import java.time.Month; import java.util.List;

/**
 * BankStatementProcesseor uses BankStatementAnalzyer
 * and runs calculation operations on bank statements.
 * @see BankStatementAnalyzer
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;   // Initializes a list of
                                                            // bank transactions as an object.
    /**
     * Processes a list of bank transactions.
     *
     * @param bankTransactions :A list of bank transactions.
     */
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {

        this.bankTransactions = bankTransactions;   // Encapsulate the transaction (date, amount, description).
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
     * Calculates the total transaction amount
     * in a specified month.
     *
     * @param (month) :The month you want to analyze.
     *
     * @return (total) :The accumulated transaction amount for the month.
     */
    public double calculateTotalInMonth(final Month month) {

        double total = 0;   // Resets total value to zero in-case,
                            // it's been set by other methods.

        for (final BankTransaction bankTransaction : bankTransactions) {    // Loops through a transaction list.

            if (bankTransaction.getDate().getMonth() == month) {    // Asserts loop to continue -- only if the
                                                                    // transaction month = month passed into method.

                total += bankTransaction.getAmount();   // If yes, then accumulate transactions
                                                        // to the total varaible, and continue loop.
            }
        }
        return total;   // Return accumulated transaction
                        // amount for the specified month.
    }

    // Method for calculating the cumulative value of transactions, of a specified category [col2].
    /**
     * Calculates the total transaction amount for
     * a specified category/description.
     *
     * @param (category) :The category/description to analyze.
     *
     * @return (total) :The accumulated transaction amount for the month.
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