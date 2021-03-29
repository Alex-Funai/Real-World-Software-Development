<!--- 
Alexander Kitaro Funai
<Date here>
https://www.alexanderfunai.com
-->

# Chapter 1 Notes

## Designing the program

### Query:
 * What is the total profit and loss from a list of bank statements? Is it positive or negative?
 * How many bank transactions are there in a particular month?
 * What are their top-10 expenses?
 * Which category does they spend most of their money on?
 
 ### Process:
 - Loading the CSV file passed as a command-line argument to the application.
 - Path class represents a path in the filesystem.
 - Files.readAllLines() to return a list of lines.
 - Parsing the lines list by:
	a. Splitting them by split() with a "," as the delimiter/separator.
	b. Extracting the amount.
	c. Parsing the amount to a double.
	
 ### Complications:
 * What if the file is empty?
 * What if parsing the amount fails because the data was corrupted?
 * What if a statement line has missing data?


## The Kiss Principle
When analyzing certain requested dependencies in a program request you can start simple by listing them in a query. 
"KISS" is an acronym for "Keep-It-Short-Simple". Initially answer the first solution in your query, and have the 
applications code in a single class.

### Definitions:
Cohesion - how related tings are in a class.
Coupling - how dependent classes are upon one another.

### Final Variables
Depending on the project Final keywords may be preferable to specify variables not being local and reassigned.

## Code Maintainability and Anti-Patterns:
 * Code is simple to locate code responsible for particular features.
 * Code is simple to understand what the code does.
 * Code is simple to add or remove new features.
 * Code provides good encapsulation. 
 * Implementation details should be hidden to users, so it's easier to understand and make changes.

## Exceptions

Java incoorporates exceptions as a first-class language feature to control flow in code, and improve maintenance and test in isolation.

### Documentation:
The langauge supports exceptionse as part of method signatures.

### Type Safety:
The type system figures out whether you are handling the exception flow.

### Separation of Concern:
Businesse logic and exception recovery are separated out with a try/catch block.

### Checked Exceptions:
These are errors that you are expected to be able to recover from. In java, you have to declare a method with a list of checked  exceptions it can
throw. If noit, you have to provide a suitable try/catch block for that particular exception.

### Unchecked Exceptions:
These are errors that can be thrown at any time during the program execution. Methods don't have to explicitly declare these exceptions in their
signature and the caller doesn't have to handle them explicitly, as it would with a checked exception.

## Overly Specific BankStatement Validator Class
The "OverlySpecificBankStatementValidator" class entails specifications and checks for the format of a parsed filed.
Instead of utilizing multiple exceptions, which would be counter-productive, as it forces to user to use your API (not kind).
It's not ideal to convert edge cases into checked exceptions, and the approach below of may be better.

```
package BankStatementAnalyzer;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class OverlySpecificBankStatementValidator {

    // Declaring and initializing the bank-statement variables.
    private String description;
    private String date;
    private String amount;

    public OverlySpecificBankStatementValidator (final String description, final String date, final String amount) {
        this.description = Objects.requireNonNull (description);
        this.date = Objects.requireNonNull (description);
        this.amount = Objects.requireNonNull (description);
    }

    // Overly specific validation class [Do not use].
    public boolean validate() throws DescriptionTooLongException, InvalidDateFormat, DateInTheFutureException, InvalidAmountException {
        if (this.description.length() > 100) {
            throw new DescriptionTooLongException();
        }
        final LocalDate parsedDate;
        try {
            parsedDate = Local.Date.parse (this.date);
        }
        catch (DateTimeParseException e) {
            throw new InvalidDateFormat();
        }
        if (parsedDate.isAfter (LocatelDate.now())) throw new DateInTheFutureException();
        try {
            Double.parseDouble (this.amount);
        }
        catch (NumberFormatException e {
            throw new InvalidAmountException();
        }
        return true;

    }

    // Overly apathetic validation class [Do not use].
    public class OverlyApatheticBankStatementValidator {
    // Just a bunhc of IllegalArgument exceptions everywhere.
    public boolean validate() {
        if (this.description.length() > 100) {
            throw new IllegalArgumentException ("The description is too long");
        }
        final LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse (this.date);
        }
        catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for date", e);
        }
        if (parsedDate.isAfter(LocalDate.now))) throw new IllegalArgumentException(("date cannot be in the future"));
        try {
            Double.parseDouble(this.amount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format for amount", e);
        }
        return true;
    }
}
```
## The Notification Class
The "Notification" class is an ideal solution to creating a validation class for our program. We introduce a domain class
to collect errors, and then can throw  back unchecked exsceptions. This validator is able to collect multiple errorse in one pass,
something that wasn't poossible in the "OverlySpecific" validator classes.
 
 
```
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
```

<style type="text/css">
/*	akfunai_Readme_Styles01	*/


/* Body and virtual container */
body {
width: 100%;
height: 125%;
background-color: #282A36;
color: #FFFFFF;
font-family: 'Source Sans Pro';
font-size: 12.825px;
}
  
  /* Headers */
  h1, {
  font-size: 30px;
  color: pink;
  text-decoration: underline;
  font-family: 'Source Sans Pro';
  }  
  
  h2, {
	color: pink;
	font-family: 'Source Sans Pro';
	font-size: 21px;
	text-decoration: overline;
	
  }
  
  h3 {
	color: pink;
	font-family: 'Source Sans Pro';
	font-size: 16px;
	font-weight: lighter;
  }
  
  /* Fenced code blocks */
  code {
  color: #31c46a;
  font-family: 'Source Sans Pro';
  font-size: 11.5px;
  }
  
  .container {
  height: 100%;
  width: 100%;
  
/* END[] */  
</style>