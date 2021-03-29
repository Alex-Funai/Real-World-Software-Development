///////////////////////////////////////////////////////////////////////////////
// Main Class File: Main_Application.java
// File: BankTransactionDAO.java
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

package _bankStatementAnalyzer;
import java.time.LocalDate;

/**
 * [CRUD operations] to (add, parse, update)
 * bank transaction objects.
 *
 * @see _bankStatementAnalyzer.BankTransaction
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
public class BankTransactionDAO {

    /**
     * .create() Creates a new transaction.
     *
     * @param (date) The date[0] of the transaction.
     * @param (amount) The transaction amount[1].
     * @param (description) The description[2] of the transaction.
     *
     * @throws UnsupportedOperationException since in-design.
     *
     * @see _bankStatementAnalyzer.BankTransaction
     */
    public BankTransaction create (final LocalDate date, final double amount, final String description) {

        throw new UnsupportedOperationException();  // in-design
    }

    /**
     * .read() Reads a transaction.
     *
     * @param (id) The transaction pair/index.
     *
     * @throws UnsupportedOperationException since in-design.
     *
     * @see _bankStatementAnalyzer.BankTransaction
     */
    public BankTransaction read (final long id) {
        // ...
        throw new UnsupportedOperationException();  // in-design
    }

    /**
     * .update() Updates a transaction.
     *
     * @param (id) The transaction id pair/index.
     *
     * @throws UnsupportedOperationException since in-design.
     *
     * @see _bankStatementAnalyzer.BankTransaction
     */
    public BankTransaction update (final long id) {
        // ...
        throw new UnsupportedOperationException();  // in-design
    }

    /**
     * .delete() Deletes a transaction.
     *
     * @param (bankTransaction) A single bank transaction.
     *
     * @throws UnsupportedOperationException since in-design.
     *
     * @see _bankStatementAnalyzer.BankTransaction
     */
    public void delete (final BankTransaction bankTransaction) {
        // ...
        throw new UnsupportedOperationException();  // in-design
    }
}
