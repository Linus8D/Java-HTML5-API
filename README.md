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
        html.getHead().setAuthorMeta("Linus Jarneving");
        html.getHead().getCssSources().add("css/bootstrap.min.css");
        html.getHead().getCssSources().add("css/custom.css");
        html.getHead().setTitle("Welcome to Linus website!");
        html.getHead().setDescriptionMeta("The website of Linus Jarneving");
        
        H1 siteTitle = new H1("Hello, World!");
        
        html.getBody().getChildreen().add(siteTitle);
        
        index.setHtml(html);
        
        index.createHtmlFile("/home/linus/Desktop");
    }               
}
