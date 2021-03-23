package BankStatementAnalyzer;
// [Functional Interface] --- An interface containing only a single abstract method.

@FunctionalInterface
public interface Interface_BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}