// Alexander Kitaro Funai -- March 22, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// [INTERFACE] --- Bank Transaction Processor

package BankStatementAnalyzer;

// Class Dependencies
import jdk.jfr.Category;
import java.time.Month;
import java.util.List;


public interface Interface_BankTransactionProcessor {

    /* Listed are the following  implementations that would be needed in this method.
     * however this act's more like a god class and has unecessary complications in it's API definition. */

/*    double calculateTotalAmount();
    double calculateTotalInMonth (Month month);
    double calculateTotalInJanuary();
    double calculateAverageAmount();
    double calculateAverageAmountForCategory (Category category);
    List<BankTransaction> findTransactions (Interface_BankTransactionFilter bankTransactionFilter);
}*/

    /* [NOTES]:
     * An interface in Java defines a contract, that every singlew implementation has to adhere by. The more operations
     * added, increases the scope for potential problems down the line.
     *
     * There are operations that are dependent on domain objects in the BankTransaction class; such as:
     *  calculateAverageForCateogry() and calculateTotalInJanuary()l and having to change these objects
     *  would be more complicated when implementing feature changes (or changing the motnh filter).
     */
// A more ideal approach could be to implement various interfaces instead, as following:
    interface CalculateTotalAmount {
        double calculateTotalAmount();
    }

    interface CalculateAverage {
        double calculateAverage();
    }

    interface CalculateTotalInMonth {
        double calculateTotalInMonth (Month month);
    }
}