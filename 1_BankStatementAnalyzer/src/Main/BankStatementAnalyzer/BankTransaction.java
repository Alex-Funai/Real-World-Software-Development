// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer



/*  The "BankTransaction" class is a domain class for holding the construction of how each BankTransaction should  be.
 *  The "BankTransaction" domain class anticipates the data type structure that is necessary for processing our specific file.
 *  In this case the "BankTransaction" domain class specifies that there will always be: [date, amount, description].
 *  These various data-types are declared as private to separate the variables from being overridden , as the program continues
 *  to run through several more transactions. This is ideal and reduces redundancy in having to create tons of variables, because we can
 *  leverage the this/that parameter to give each class run-through it's own unique value, but theoretically using the same variable name.
 */

package BankStatementAnalyzer;

import java.time.LocalDate;
import java.util.Objects;

// [2-4] A domain class for a bank transaction:
public class BankTransaction {

    /*  Declaration and initialization of private final variables, and constructing the basis of data that each transaction will entail.
     *  Private and final ensures that the data is not manipulated further through the program when leveraging them into other methods
     *  in the program, and allows us to reduce redundancy by using the this/that parameters to theoretically reuse the same named variables,
     *  but assigning them their own each unique values.
     */
    private final LocalDate date;              // Initialize an immutable class of LocalDate to the variable "date".
    private final double amount;            // Initialize a double class to the variable "amount".
    private final String description;       // Initialize a string class  to the variable "description".

    // Constructor limiting private variables to "this" implementer.
    public BankTransaction(final LocalDate date, double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    // Method for returning the date.
    public LocalDate getDate() {
        return date;
    }

    // Method for returning transaction amount.
    public double getAmount() {
        return amount;
    }

    // Method for returning the description.
    public String getDescription() {
        return description;
    }



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
