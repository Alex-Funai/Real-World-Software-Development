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
 * 'class.BankStatementProcesseor' is an extension to 'class.BankStatementAnalzyer' that refines the program by
 * improving it's cohesion. 'class.BankStatementProcessor' separates various different transaction operations into
 * independent methods,and allows us to conveniently reference them in other classes of our program. Think of it as
 * an API or interface, that is easily accessible.
 *
 * <p>Bugs: none.
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;   // Initialize 'bankTransactions' object from
                                                            // 'class.BankTransaction' return.
    /**
     * Encapsulates each iterations' bank transaction values.
     *
     * @param bankTransactions The statement: (date, amount, description)
     */
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {

        this.bankTransactions = bankTransactions;   // Encapsulate the transaction (date, amount, description).
    }
    /**
     * calculateTotalAmount() calculates total cumulative value
     * of the document's transactions.
     *
     * @return (total) The total value of transactions.
     */
    public double calculateTotalAmount() {
        double total = 0;
        // Loops through the BankTransaction
        for (final BankTransaction bankTransaction : bankTransactions) {    // Loop through list<bankTransaction>
            total += bankTransaction.getAmount();   // Accumulate amount values through loop
                                                    // to the same 'total' variable.
        }
        return total;   // Total accumulative value of a document's transactions.
    }

    // Method for calculating the cumulative value of transactions in a specified date.month [col1].
    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    // Method for calculating the cumulative value of transactions, of a specified category [col2].
    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
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