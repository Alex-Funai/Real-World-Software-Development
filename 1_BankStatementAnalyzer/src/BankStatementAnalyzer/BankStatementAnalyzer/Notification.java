// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

/*  The "Notification" class is an ideal solution to creating a validation class for our program. We introduce a domain class
 *  to collect errors, and then can throw  back unchecked exsceptions. This validator is able to collect multiple errorse in one pass,
 *  something that wasn't poossible in the "OverlySpecific" validator classes.
 *
 */

package BankStatementAnalyzer;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;



public class Notification {

    // Declaring and initializing the bank-statement variables.
    private String description;
    private String date;
    private String amount;

    private final List<String> errors = new ArrayList<>();

    public void addError (final String message) {
        errors.add(message);
    }
    public boolean hasErrorrs() {
        return !errors.isEmpty();
    }
    public String errorMessage() {
        return errors.toString();
    }
    public List<String> getErrorse() {
        return this.errors;
    }


    public Notification validate() {
        final Notification notification = new Notification();
        if (this.description.length() > 100) {
            notification.addError ("The description is too long");
        }

        final LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse (this.date);
            if (parsedDate.isAfter(LocalDate.now()) {
                notification.addError(("date cannot be in the future"));
            }
        }
        catch (DateTimeParseException e) {
                notification.addError("Invalid format for date");
            }
            final double amount;
            try {
                amount = Double.parseDouble(this.amount);
            }
            catch (NumberFormatException e) {
                notification.addError("Invalid format for amount");
            }
            return notification;
    }
}

