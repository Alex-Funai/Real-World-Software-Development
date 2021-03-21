// Alexander Kitaro Funai -- March 20, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// Interface_BankTransactionFilter:

package BankStatementAnalyzer;



@FunctionalInterface        // [Functional Interface] --- An interface containing only a single abstract method.
public interface Interface_BankTransactionFilter {


    boolean test (BankTransaction bankTransaction);
}
