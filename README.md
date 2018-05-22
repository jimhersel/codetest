# codetest
Used a listener/command pattern that is injected into the springboot service using configured beans.  A REST service is provided as the interface.  It was implemented as a POST and will return 200 if successful or 500(can be changed as needed) when validation fails or an error occurs.  The response on validation failure provides the rules for validation.

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
