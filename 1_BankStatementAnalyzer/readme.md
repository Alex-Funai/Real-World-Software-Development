# Bank Statement Analyzer

This is an excercise program from the book Real World Software Development by Rauol-Gabriel Urma and  Richard Warburton.
The program is capable of parsing CSV, HTML, and JSON file types, and then returning specific information to the user.

## Getting Started

1.  Setup environment to use Gradle 6.8.3 and JUnit 4.13.2.
2. Configure the 'build.gradle' file to utilize Junit and Java (see below).
3. Add Junit to project structure modules/libraries.
4. Modify the *"exporter" classes to personalize analytic output.
5. Modify file to parse location in class 'Main_Application'  __BankStatementAnalyzer__ method. 
   (default location for files is pointing to 'src\resources' > put files to parse in there, and only type file name)
6. Run program/class "Main_Application", to parse and analyze documents.


### Prerequisites
1. JUnit 4.13.2
2. Gradle 6.8.3
3. JDK 15

### Installing
1. Initialize new project with Gradle.
2. Open file > Project Structure > Modules > Dependencies.
3. Add 'JUnit 4.13.2' .
4. Open file > Project Structure > Libraries.
5. Add  'Junit 4.13.2'.
6. Open 'build.gradle'  and configure file  and edit in Junit and Java (see below).

#### __'build.gradle 'configuration:__
```
apply plugin: 'java'

plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation('org.junit.jupiter:junit-jupiter-api:4.13.2')
    testRuntime('org.junit.jupiter:junit-jupiter-engine:4.13.2')
}

test {
    useJUnitPllatform()
}
```


End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Tests are located in "src/test"

### What do the tests do?

Tests are basic and not useful. They only are used to experiment with throwing assertions. There is one semi-useful
tests at the bottom that verifies data from the analyization matches it. One test fails, the other doesn't.


```
    @Test       // T00 -- Example of a failing Assert test.
    public void shouldParseOneCorrectLine_FAIL() throws Exception {
        Assert.fail("Not yet implemented");
    }

    @Test       // T01 -- Example of a passing parsing test.
    public void shouldParseOneCorrectLine_Pass() throws Exception {
        final String line = "30-01-2017, -50,Tesco";    // White space fails comparison test, but test continues on still.
        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0;

        // Three-stage pattern "unit-test" known as the "Given-When-Then" formula.
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
```




## Built With

* [IntelliJ](https://www.jetbrains.com/idea//) - Preferred Java IDE
* [Gradle](https://gradle.org/) - Build automation
* [JUnit](https://junit.org/junit4/) - Testing framework

## Contributing

Please read [CONTRIBUTING.md](https://github.com/Iteratr-Learning/Real-World-Software-Development) for details on our code of conduct, and the process for submitting pull requests to us.


## Authors

* ***Rauol-Gabriel Urma & Richard Warburton*** - *Initial work* - [rauolDoc](https://github.com/Iteratr-Learning/Real-World-Software-Development)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Rauol-Gabriel Urma
* Richard Warburton
