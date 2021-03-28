# Bank Statement Analyzer

This is an excercise program from the book Real World Software Development by Rauol-Gabriel Urma and  Richard Warburton.
The program is capable of parsing CSV, HTML, and JSON file types, and then returning specific information to the user.

<br>

## Getting Started:

1. Clone the repository or download the '.zip' and extract locally.
2. Configure the 'build.gradle' file for libraries/dependencies.
3. Configure project structure for libraries/dependencies.
4. Modify the *"exporter" class with methods and classes to specify information that is returned.
5. Modify the file location in 'class.Main_Application.BankStatementAnalyzer(). 
6. Run 'class.Main_Application.main()', to parse and analyze documents.


### Prerequisites:
* JDK-8.0/1.8
* Gradle-6.8.3
* Grovy-3.3
* JUnit-4.13.2
* HamCrest-all-2.2


### Installing:
1. Initialize new Java project with Gradle.
2. Import '\src' files into your root project directory.
2. File > ProjectStructure > Libraries/Dependencies > Add:  JUnit-4.13.2 / HamCrest-1.2.
3. Build Gradle framework >> terminal > gradle clean > gradle build (or gradle init -- if you use Kotlin/Groovy).
3. Edit 'gradle.build'  > add plugins / dependencies / test framework:  JUnit-4.13.2 / HamCreset-1.2 / Java.

```
// build.gradle

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

## Running the tests

Tests are located in "src/test". Ensure 'gradle.build' and ProjectStructure include Junit-4.13.2 and HamCrest-core-collections libraries to execute tests.

### What do the tests do?

The tests are basic and not useful. They only are used to experiment with throwing assertions. There is one semi-useful
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

* [IntelliJ-2020-3.3](https://www.jetbrains.com/idea//) - Preferred Java IDE.
* [Gradle-6.8.3](https://gradle.org/) - Build automation.
* [JUnit-4.13.2](https://junit.org/junit4/) - Testing framework
* [HamCrest-1.3](http://hamcrest.org/JavaHamcrest/) - Additional testing library.

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


<style type="text/css">
/*	akfunai_Readme_Styles00	*/


/* Body and virtual container */
body {
width: 100%;
height: 125%;
background-color: #282A36;
color: #ffffff;
font-family: 'Source Sans Pro';
font-size: 13px;
}
  
  /* Headers */
  h1 {
  color: #ffebff;
  text-decoration: underline;
  font-size: 29.125px;
  font-family: 'Source Sans Pro';
  
  }
  
  h2 {
  color: #e6f8ff;
  font-size: 21.825px;
  text-decoration: overline;
  font-family: 'Source Sans Pro';
  }
  
  h3 {
  color: #e6f8ff;
  font-family: 'Source Sans Pro';
  font-size: 15.125px;
  font-weight: lighter;
  }
  
  h4 {
  color: #e6f8ff;
  font-family: 'Source Sans Pro';
  font-weight: lighter;
  }
  
  /* Fenced code blocks */
  code {
  color: #36ff9a;
  font-family: 'Source Sans Pro';
  font-size: 11.5px;
  }
  
  /* href Links */
  a:link {
  color: #52b5e3;
  }
  
  
/* END[] */  
</style>