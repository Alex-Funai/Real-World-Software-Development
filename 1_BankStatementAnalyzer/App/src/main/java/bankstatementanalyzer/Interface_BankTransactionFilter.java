// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

// [Functional Interface] --- An interface containing only a single abstract method.
package src.main.java.bankstatementanalyzer;
@FunctionalInterface
public interface Interface_BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}