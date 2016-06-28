# Java-HTML5-API
An API (application programming interface) for creating HTML documents using Java that can be used for creating static websites.

## Example - Hello, world!
The following example illustrates how to create a HTML document at the working directory that prints _Hello, world!_ in the browser.

```java

import com.lj.html.HtmlFile;
import com.lj.html.tags.Html;
import com.lj.html.tags.HtmlTag;

public class HelloWorld {

    public static void main(String[] args) {
        HtmlFile index = new HtmlFile();
        index.setDir("");
        index.setFileName("index");
        
        Html html = new Html();
        html.getHead().setAuthorMeta("Joe Doe"); // The author meta tag within the head tags.
        html.getHead().getCssSources().add("css/style.css"); // Links to a .CSS file in a folder named css. 
        html.getHead().setTitle("Hello, World!"); // The title meta tag in the head.
        html.getHead().setDescriptionMeta("Hello World is a basic computer program that prints hello world."); // The description tag
        
        H1 siteTitle = new H1("Hello, World!"); // Example of an extension of the HtmlTag class.
        
        html.getBody().getChildreen().add(siteTitle); // Put the H1 objectet siteTitle within the HTML body tags. 
        
        index.setHtml(html); // Set the HTML html tags of the HTML document.
        
        index.createHtmlFile("/home/Joe Doe/Desktop");  // Creates the HTML document at directory home/Joe Doe/Desktop
    }               
}
