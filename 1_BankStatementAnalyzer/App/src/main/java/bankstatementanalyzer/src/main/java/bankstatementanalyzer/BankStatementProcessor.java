// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

/*  The "BankStatementProcesseor" class is a rendition of the "BankStatementAnalzyer" that refines the program by
 *  improving it's cohesion. The "BankStatementProcessor" separates various different transaction operations into their own
 *  methods, which allows us to conveniently reference them in other classes of our program since they are not dependent on the class
 *  as a whole. Think of it as somewhat of an API or interface that is easily accessible and manageable.
 */

package src.main.java.bankstatementanalyzer;
import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    /*  We intialize and declare a List interface to the variable "bankTransactions" by importing our initial list of data.
     *  Again we utilize private/final to anticipate the repitition of this class when it runs through several transactions,
     *  each list being represented as a line of data.
     */
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    // Method for calculating the total cumulative value of all transactions:
    public double calculateTotalAmount() {
        double total = 0;
        // Loops through the BankTransaction
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
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