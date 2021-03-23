package BankStatementAnalyzer;
// [Functional Interface] --- An interface containing only a single abstract method.

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}