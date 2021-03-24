# Document Management System

Simulation for a program design request for a dentist business
who would like to automate their document management.

## Requirements

*   Reports:    A body of text detailing some consultation of operation on a patient.
*   Letters:    A text document that gets sent to an address.
*   Images: The dental practice often records x-rays of photos of teeth and gums.
*   Documents:  Need to record path to file that is being managed and reference the correct patient.
### Feature Requests:
*   Searching the documents.
*   Query whether the attributes of different type documents contain certain pieces of information.
*   Design for implementation of more document file types in the future.


```

```

### The Design:
1.  DocumentManagementSystem should be able to import documents on requests and add them into the internal storage of documents.

__void importFile (String path)__
```
Takes a path to a file that our user can import into the DocumentManagementSystem (DMS). Utilize intake of String
rather than type-safe class like "java.nio.Path" or "java.io.file".
```
__List<Document> contents()__
```
Returns a list of all documents that the DocumentManagementSystem currently stores.
```
__Importers__<br>
Capability to import different file types being: .letter, .report, and .jpg.
```
switch(extension) {
    case "letter":
        // code for importing letters.
        break;

    case "report":
        // code for importing reports:
            break;

    case "jpg":
        // code for importing images
        break;

    default:
        throw new UnknownFileTypeException("For file: " + path);
}
```
Create an importer interface, and then a unique Importer class for importing each different type of file.
__Importer__
```
interface Importer {
    Document importFile(File file) throws IOException;
    }
```
__The Document Class__
```
public class Document {
    private final Map<String, String> attributes
```

## Running the tests



### Break down into end to end tests



```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
