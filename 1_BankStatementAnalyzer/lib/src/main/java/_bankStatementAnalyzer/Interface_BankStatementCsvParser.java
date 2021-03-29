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

package _bankStatementAnalyzer;
import java.util.List;

/**
 * @deprecated Interface_BankStatementCsvParser
 *
 * Interface_BankStatementCsvParser was used for parsing
 * a CSV file by line.
 *
 * @see Interface_BankStatementParser for updated/global utilization instead.
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
public interface Interface_BankStatementCsvParser {

    /**
     * .parseLinesFromCSV() reads in information from a CSV and
     * starts a new array at each line break.
     *
     * @deprecated parseLinesFromCSV()
     *
     * @see Interface_BankStatementParser for updated/global utilization instead.
     */
    List<BankTransaction> parseLinesFromCSV(List<String> lines);
}
