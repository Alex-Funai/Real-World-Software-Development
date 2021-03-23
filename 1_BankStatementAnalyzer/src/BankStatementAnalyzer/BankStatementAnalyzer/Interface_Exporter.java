// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

package BankStatementAnalyzer;

/*  This exporter class will be utilized as an API.
 *  The reason we introduce this as an interface, is so we can decouple multiple implemntations of exporters
 *  withoutt having to jeopardize managing the code, and avoiding  the tedious process of revision.
 *  For exapmle, if we need to substitute the exporter to handle JSON from XML, it can isimply be implemented into this interface.
 *
 */

public interface Interface_Exporter {

    /*  [0] This is an example of utilizing the exporter to push out SummaryStatistics, but return void.
     *          Using the void type here is not useful, because it won't tell us what is returned. Signature of export() implies that some change is happening somehwere or that
     *          this method will log or print information back to the screen. Returning void makes it hard to test the results with assertions. We can't compare the actual results
     *          with the expected resultse when we utilzie void here unfortunately.
     */
    //  void export (SummaryStatistics summaryStatistics);


    /* [1] This example of utilizing exporter, will ouitput the SummaryStatistics).
     *          This API alternative returns as string. It's clear that the "Exporter" will export a string by it's definition. Exporter will return text,
     *           and then another part of the program will decide if to print, save, or send it. Texts strings are useful for testing, as you can directly
     *          compare them with assertions.
     */
    String export(SummaryStatistics summaryStatistics);

    /*  [2] Now the API is defined to export information, and you can implement various kinds of exporters that respect the contract of the Exporter interface.
                Another example for implenting a basic HTML exporter is: created and shown in a new class "HTMLExporter". We can simply call to this interface_Exporter
                by utilizsing the "implements" declaration.
     *
     */
}
