# Comment templates for Java.

<br>

## [Source File] Main Class Header

///////////////////////////////////////////////////////////////////////////////
// ALL STUDENTS COMPLETE THESE SECTIONS
// Title: (program's title)
// Files: (list of source files)
// Date:
//
// Author: (your name)
// Email: (your email address)
// CS Login: (your login name)
// Lecturer's Name: (name of your lecturer)
// Lab Section: (your lab section number)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
// If pair programming is allowed:
// 1. Read PAIR-PROGRAMMING policy (in cs302 policy)
// 2. choose a partner wisely
// 3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER
// a. one partner creates the team
// b. the other partner must join the team
// 4. complete this section for each program file.
//
// Pair Partner: (name of your pair programming partner)
// Email: (email address of your programming partner)
// CS Login: (partner's login name)
// Lecturer's Name: (name of your partner's lecturer)
// Lab Section: (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
// must fully acknowledge and credit those sources of help.
// Instructors and TAs do not have to be credited here,
// but tutors, roommates, relatives, strangers, etc do.
//
// Persons: Identify persons by name, relationship to you, and email.
// Describe in detail the the ideas and help they provided.
//
// Online sources: 
//
///////////////////////////////////////////////////////////////////////////////


<br>

## [Source Files] Class File Header:

<br>

///////////////////////////////////////////////////////////////////////////////
// ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File: (name of main application class)
// File: (name of this class's file)
// Semester: (course) Spring 2016
//
// Author: (your name and email address)
// CS Login: (your login name)
// Lecturer's Name: (name of your lecturer)
// Lab Section: (your lab section number)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner: (name of your pair programming partner)
// Email: (email address of your programming partner)
// CS Login: (partner's login name)
// Lecturer's Name: (name of your partner's lecturer)
// Lab Section: (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
// fully acknowledge and credit all sources of help,
// other than Instructors and TAs.
//
// Persons: Identify persons by name, relationship to you, and email.
// Describe in detail the the ideas and help they provided.
//
// Online sources: avoid web searches to solve your problems, but if you do
// search, be sure to include Web URLs and description of
// of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////


## Class[]
/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy. If necessary, additional paragraphs should
 * be preceded by <p>, the html tag for a new paragraph.)
 *
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */

<br>
## Method[]

/**
 * (Write a succinct description of this method here. If necessary,
 * additional paragraphs should be preceded by <p>, the html tag for
 * a new paragraph.)
 *
 * @param (parameter name) (Describe the first parameter here)
 * @param (parameter name) (Do the same for each additional parameter)
 * @return (description of the return value)
 */

<br>
## Test[]
/**
 * Interactive test that asks user to install more than one test MIDlet
 * suite associated with this test case. In order to do that the developer needs
 * to define the <code>JADPath&lt;N&gt;</code> and
 * <code>JARPath&lt;N&gt;</code> properties, where
 * <code>N</code> is decimal integer starting from 1 to infinity (without gaps).
 * For instance, if you need a testcase to install 3 MIDlet suites, use N=1,2, and 3.
 * Each property contains the pointer to the appropriate test MIDlet.
 *
 * @testcase
 *
 * @precondition none
 *
 * @userInteraction
 * <ul>
 * <li>Install <code>syspropviewer.jad</code> using the
 * provided URL</li>
 * <li>Select installed MIDlet and launch it</li>
 * <li>Install <code>choicegroup.jad</code> using the
 * provided URL</li>
 * <li>Select installed MIDlet and launch it.</li>
 * </ul>
 * @postcondition The 2 MIDlet suites are installed
 * @passCriteria User is able to install both of the MIDlet suites and
 * launch them. The "SysPropertiesViewer" MIDlet should show a list of
 * system properties describing your device. "ChoiceGroupDemo" application
 * should display different types of choice group UI.
 *
 * @card.property JADPath1=syspropviewer/syspropviewer.jad
 * @card.property JARPath1=syspropviewer/syspropviewer.jar
 * @card.property JADPath2=choicegroup/choicegroup.jad
 * @card.property JARPath2=choicegroup/choicegroup.jar
 */
void t02InstallMoreThanOneMIDletSuite();
