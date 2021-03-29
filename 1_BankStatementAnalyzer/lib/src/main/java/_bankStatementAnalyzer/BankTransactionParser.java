// Main Class File: 'Main_Application.java'
// File: 'interface.Interface_Exporter.java'
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

/**
 * @deprecated .BankTransactionParser()
 *
 * @see _bankStatementAnalyzer.Interface_BankStatementParser for global parser.
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
// Parser for file type variants.
package _bankStatementAnalyzer;

public class BankTransactionParser {
    public BankTransaction parseFromCSV(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction parseFromJSON(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction parseFromXML(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }
}
