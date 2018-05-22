# codetest
How to run and test:
1)	Drop the security-web-0.0.1-SNAPSHOT.jar into a directory and make sure a java 1.8 is available.
2)	Execute the command "java -jar security-web-0.0.1-SNAPSHOT.jar"
3)	Using a REST client, curl, etc. execute a POST to the URL  "http://localhost:20001/Security/validator" with a header "Content-Type:application/json" and the sample JSON payload below.
4)	The password can be changed to anything for validation and will respond as described below.
5)	The application can always be loaded in Eclipse, compiled and executed that way.  common-codetest is a support jar that is used to demonstrate IoC, etc.

Used a listener/command pattern that is injected into the springboot service using a configured bean.  A REST service is provided as the interface.  It was implemented as a POST and will return 200 if successful or 500(can be changed as needed) when validation fails or an error occurs.  The response on validation failure provides the rules for validation.

When requested the listener scanner reads all the validators in a package and applies them against the requested string of text.
If any validators fail the validation fails and a message is returned to the caller. 

This design allows for simple validators to be added or deleted with only a compile and re-deploy.
I had additional thoughts around adding regex patterns in the properties and creating a generic regex validator if additional regex validations could be useful.

Was going to use an annotation with an aspect implementation but decided that was even more overkill.

A sample JSON payload is provided.
{
	"password":"test1a8g7zr0"
}

Caveat, if needed, this is a simple REST service with no encryption or security so it would need further enhancement to be a more robust password validator.  It was implemented as a POST so as to provide some additional functionality in that area.

==================================
Instructions given for test:
Write a password validation service, meant to be configurable via IoC (using dependency injection engine of your choice). The service is meant to check a text string for compliance to any number of password validation rules. The rules currently known are:
 • Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
 • Must be between 5 and 12 characters in length.
 • Must not contain any sequence of characters immediately followed by the same sequence.

Include all artifacts in a zip file and please let us know how many hours you spent on the programming problem. The project should include a build capability in one of the following tools, Eclipse, IntelliJ, ant, or maven. The project should be ready for insertion into a production system. Show tests for the service and any constituent classes involved in fulfillment of the service. Also, show how to access and use the service at runtime.
