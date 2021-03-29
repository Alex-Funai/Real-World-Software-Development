///////////////////////////////////////////////////////////////////////////////
// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

package _bankStatementAnalyzer;

/**
 * Filters bank statements for bank transactions only.
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
@FunctionalInterface
public interface Interface_BankTransactionFilter {

    /**
     * Compares incoming bank transactions from statements w/
     * default bank transaction structure to verify, it is one.
     *
     * @author Raoul-Gabriel Urma & Richard Warburton
     */
    boolean test (BankTransaction bankTransaction);
}