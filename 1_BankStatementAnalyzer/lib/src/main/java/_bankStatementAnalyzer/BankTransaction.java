///////////////////////////////////////////////////////////////////////////////
// Main Class File: Main_Application.java
// File: BankTransaction.java
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

/******************************************************************************
 * @apiNote (date, amount, description)
 * Declaration and initialization of private final variables, and constructing the basis of data that each transaction
 * will entail. Private and final ensures that the data is not manipulated further through the program when leveraging
 * them into other methods in the program, and allows us to reduce redundancy by using the this/that parameters to
 * theoretically reuse the same named variables, but assigning them their own each unique values.
 ******************************************************************************/

package _bankStatementAnalyzer;
import java.time.LocalDate;
import java.util.Objects;

/**
 *  class.BankTransaction is a domain class for holding the construction of how each BankTransaction should  be.
 *  The class.BankTransaction domain class anticipates the data type structure that is necessary for processing a
 *  specific file. In this case (domain)class.BankTransaction specifies structure -- that there will always be:
 *  [date, amount, description].These various data-types are declared as private to separate the variables from
 *  being over-written , as the program continues to run through several more transactions. This is ideal, and reduces
 *  redundancy in having to create tons of variables, because we can leverage the .this/.that constructor-keywords to
 *  give each class, it's own unique value -- but theoretically using the same variable name.
 *
 * <p>Bugs: none.
 *
 * @author akfunai
 */
public class BankTransaction extends BankTransactionDAO {

    private final LocalDate date;           // Initialize an immutable class
                                            // of LocalDate to the variable 'date'.

    private final double amount;            // Initialize an immutable double
                                            // to the variable 'amount'.

    private final String description;       // Initialize an immutable string
                                            // to the variable 'description'.

    /**
     * .BankTransaction() is a Domain method
     * for encapsulating and storing a
     * transaction:(date, amount, description).
     *
     * @param (date) The date[0] of the transaction.
     * @param (amount) The transaction amount[1].
     * @param (description) The description[2] of the transaction.
     */
    public BankTransaction(final LocalDate date, double amount, final String description) {

        this.date = date;                   // Initializing encapsulated
        this.amount = amount;               // variable values for a
        this.description = description;     // .bankTransactions: (date, amount, description).
    }

    /**
     * Stores the transaction's date.
     *
     * @return (date) The transaction date.
     */
    public LocalDate getDate() {

        return date;    // Returns transaction date to getDate().
    }

    /**
     * Stores the transaction amount.
     *
     * @return (amount) The transaction amount.
     */
    public double getAmount() {

        return amount;  // Returns transaction amount to getAmount().
    }

    /**
     * Stores the transaction description.
     *
     * @return (description) The transaction description.
     */
    public String getDescription() {

        return description; // Returns transaction description to getDescription().
    }

    /******************************************************************************
     ******************************************************************************/
    @Override
    public String toString() {
        return "BankTransaction (" + "date=" + date + ", amount=" + amount + ", description=" + description
                + '\'' + ')';
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
