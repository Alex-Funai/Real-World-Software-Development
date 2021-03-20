// Alexander Kitaro Funai -- March 14, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// Bank Statement CSV Parser

/* [Notes] Defining a constructor and separate class is useful for the full application,
 */

package BankStatementAnalyzer;

import java.time.LocalDate;
import java.util.Objects;

// [2-4] A domain class for a bank transaction:
public class BankTransaction {

    private final LocalDate date;
    public double amount;
    private final String description;

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
