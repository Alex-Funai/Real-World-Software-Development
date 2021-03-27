package _DocumentManagementSystem;// Alexander Kitaro Funai -- March  25, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 4-- Document Management System

/*  The "Attributes" class defines a set of specific strings that are present as common variables in the different file types requested from the Dentist.
 *  These strings are paired with their actual values into a HashMap when importing files.
 *  The "Attributes" class can be modified to uniquely adhere to different document specifications/commonalities, if the program is updated.. If done so
 *  create a new "Importer_<yourFileTypeHere>"  and include the determined Attributes here/there.
 */

public  class Attributes {

    public static final String PATH = "path";
    public static final String PATIENT = "patient";
    public static final String ADDRESS = "address";
    public static final String BODY = "body";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String TYPE = "type";
    public static final String AMOUNT = "amount";
}
