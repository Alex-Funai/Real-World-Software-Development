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

// [Functional Interface] --- An interface containing only a single abstract method.
package src.main.java.bankstatementanalyzer;
@FunctionalInterface
public interface Interface_BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}