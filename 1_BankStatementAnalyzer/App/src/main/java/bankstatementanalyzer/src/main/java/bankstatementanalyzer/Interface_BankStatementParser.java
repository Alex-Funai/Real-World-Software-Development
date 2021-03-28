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

package src.main.java.bankstatementanalyzer;

import java.util.List;

public interface Interface_BankStatementParser {

    BankTransaction parseFrom (String line);

    List<BankTransaction> parseLinesFrom (List<String> lines);
}
