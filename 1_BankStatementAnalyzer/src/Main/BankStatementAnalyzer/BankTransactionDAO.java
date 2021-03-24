// Alexander Kitaro Funai -- March 19, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer


 /*
   [Bank Transaction DAO] --- Reusing previously declared classes and considering how to cohesively disect program into utilizable methods
   without jeopardizing the legibility, functionality, and structure.

   [COHESION] --- Creating separate classes is ideal because it allows us to utilize the same methods and manipulate them elsewhere in our program.

   [UTILITY]--- Be careful not to group unrelated methods inside a class. Be aware of where cohesion can be utilized  without complicating the program structure.
    A scenario with overgrouped methods would be considered an example of poor cohesion,  the program loses class discoverability, and revision/updating becomes
   more complicated... Especially if the program intends on adding new features, or updating foundational structure for improvement.
  */

package BankStatementAnalyzer;

import java.time.LocalDate;

public class BankTransactionDAO {

    // Example here -- is we can reference our previously grouped methods, and add new functionality to them without having to be redundant.
    public BankTransaction create (final LocalDate date, final double amount, final String description) {
        throw new UnsupportedOperationException();
    }

    // The following are examples of cohesion by grouping multiple concerns together, but this can create dependency flaws.

    public BankTransaction read (final long id) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction update (final long id)  {
        // ...
        throw new UnsupportedOperationException();
    }

    public void delete (final BankTransaction BankTransaction) {
        // ...
        throw new UnsupportedOperationException();
    }
}
