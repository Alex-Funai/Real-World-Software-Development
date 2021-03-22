// Alexander Kitaro Funai -- March 20, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer
//  BankTransactionIsInFebruaryAndExpensive

package BankStatementAnalyzer;

// Class Dependencies:
import java.time.Month;

class BankTransactionIsInFebruaryAndExpensive implements BankStatementAnalyzer.BankTransactionProcessor.Interface_BankTransactionFilter {

    @Override
    /* This parameter test for February is cumbersome, as we'd have to re-iterate for every other month in the year.
        The solution to this excessiveness, would be to convert this into a "Lambada-Expression".                                      */
    public boolean test (final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;

    }
}
