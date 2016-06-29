# Java-HTML5-API
An API (application programming interface) for creating HTML documents using Java that can be used for creating static websites.

## Example - Hello World!
The Hello World example demonstrates how to create a HTML file at a given local directory and how to extend the HtmlTag class. 

```java

import com.lj.html.HtmlFile;
import com.lj.html.tags.Html;
import com.lj.html.tags.HtmlTag;

public class HelloWorld 
{
    public static void main(String[] args) 
    {        
        // Create a HtmlFile object and name it index:
        HtmlFile index = new HtmlFile();
        index.setFileName("index");
        
        /* 
            Add a header 1 element (i.e. <h1> element) to the created HTML page that says Hello World!
            Since the content of a HTML document that is seen in the web-browser lies within the <body></body> 
            tags, we add the <h1> element within those tags:
        */ 
        index.getHtml().getBody().getTags().add(new H1("Hello World!"));
        
        // Create the HTML file physically in the local directory: 
        index.createHtmlFile("/home/linus/Desktop/Hello World");
        
        // The H1 object declared in this example is implemented in the class below and demonstrates how to extend
        // the HtmlTag class.
    }               
}

class H1 extends HtmlTag
{
    String txt;

    public H1(){};
    
    public H1(String txt)
    {
        this.txt = txt;
    }
    
    @Override
    public String toString() 
    {
        return "<h1>"+txt+"</h>\n";
    }    
}
