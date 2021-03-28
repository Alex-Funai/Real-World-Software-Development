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

/**
 * This exporter class will be utilized as an API. The reason we introduce this as an interface, is so we can decouple
 * multiple implemntations of exporters withoutt having to jeopardize managing the code, and avoiding  the tedious
 * process of revision. For exapmle, if we need to substitute the exporter to handle JSON from XML, it can simply be
 * implemented into this interface.
 * <p>
 * 'Interface_Exporter' method is for constructing and delcaring a new Interface_Exporter as the variable interfaceExporter.
 * This constructor manages and holds the methods and classes we which to access, and then use on our data.
 * In this scenario, we have designated a unique exporter for different file types, so we can simply managae the exporter class
 * to change request. They all inherit a basis construction for the data types they should have, and we can make changes to them
 * specifically without having to jeopardize the code base/structure of the program as a whole.
 *
 * <p>
 * Bugs: can't find any here.
 *
 * @author akfunai
 */
public interface Interface_Exporter {

    /**
     * export() will ouitput the SummaryStatistics).This API alternative returns as string. It's clear that
     * the "Exporter" will export a string by it's definition. Exporter will return text, and then another
     * part of the program will decide if to print, save, or send it. Texts strings are useful for testing,
     * as you can directly compare them with assertions.
     * <p>
     * Now the API is defined to export information, and you can implement various kinds of exporters that respect
     * the contract of the Exporter interface. Another example for implenting a basic HTML exporter is created,
     * and shown in a new class "HTMLExporter". We can simply call to this interface_Exporter by utilizing
     * the "implements" declaration.
     *
     * @param summaryStatistics The sum/min/max/average of a bankstatement.
     */
    String export(SummaryStatistics summaryStatistics);
}

    /**
     * @deprecated
     * This is an example of utilizing the exporter to push out SummaryStatistics, but return void.
     * Using the void type here is not useful, because it won't tell us what is returned. Signature of
     * export() implies that some change is happening somehwere or that this method will log or print
     * information back to the screen. Returning void makes it hard to test the results with assertions.
     * We can't compare the actual results with the expected resultse when we utilzie void here unfortunately.
     *
     * @param summaryStatistics The sum/min/max/average of a bankstatement.
     */
    // void export (SummaryStatistics summaryStatistics);

