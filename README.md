# Java-HTML5-API
An API (application programming interface) for creating HTML documents using Java that can be used for creating static websites.

## Introduction
The Java-HTML5-API creates a static web page by creating a HtmlFile instance with the following members

1.  A method for printing the HTML document at a given directory.
2.  An instance variable that names the file e.g. index.html. 
3.  An Html object.

The Html object contains the &lt;head&gt; and &lt;body&gt; tags of a HTML document. These tags are in turn modeled by 
two corresponding classes:

1.  <strong> Body - </strong> Which models the &lt;body&gt; tags and the HTML tags within the opening and closing body tags. This include all content that is rendered in the browser.
2.  <strong> Head - </strong> Which models the &lt;head&gt; tags and the HTML tags within the opening and closing head tags. Examples includes links to external assets and the title, meta, author and description tags of a HTML document.

To create a HTML document the HtmlFile instance is declared and the HTML file is named:
```java
    // Create a HtmlFile instance and name the HTML document that it models index.
    HtmlFile index = new HtmlFile();
    index.setFileName("index");
```    
The above HtmlFile instance models a HTML document with the following HTML markup:
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>null</title>
</head>
<body>
</body>
</html>
```
The above HTML can be created as the HTML document _index.html_ at a given directory using the HtmlFile instance 
_createHtmlFile()_ method:
```java
    // Create a HtmlFile instance and name the HTML document that it models index.
    HtmlFile index = new HtmlFile();
    index.setFileName("index");
    // Create a HTML document named index.html at the directory /home/JoeDoe/Desktop/Hello World
    index.createHtmlFile("/home/JoeDoe/Desktop/Hello World");
```
### Adding meta tags within the &lt;head&gt;&lt;/head&gt; tags
From the HTML markup of the empty HTML document in the previous example, the reader can notice that the 
head tags of the HTML document contains a minimal, default markup. Because a HTML document would (normally) contain atleast
a &lt;title&gt; tag and links to external assets, such as CSS files. Adding content inside the head tags is of great 
interest. 

The approach of Java-HTML5-API is to use _getters_ and _setters_ to set the instance variables. Therefore, in order to add
HTML elements within the &lt;head&gt; tags we first get the <strong>Head</strong> instance of the HtmlFile instance and
add elements to the Head instance.

In the following listing, we add a title, author and description to the Hello World document. Add this before the method
call to _createHtmlFile_ :
```java
    // Add meta inside the head tags:
    index.getHtml().getHead().setTitle("Hello World");
    index.getHtml().getHead().setAuthorMeta("Joe Doe");
    index.getHtml().getHead().setDescriptionMeta(
        "Hello World is an introductory application in computer science "
        + "that, in some fashion, displays Hello World! to a user");
```
Including the above listing with the previous listings generates a HTML document with the following markup:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Joe Doe">
    <meta name="description" content="Hello World is an introductory application in computer science that, in some fashion, displays Hello World! to a user">
    <title>Hello World</title>
</head>
<body>
</body>
</html>
```
We still have not added content to the HTML document, as can be seen since there are no content between the &lt;body&gt; opening and closing tags. In order to add content to the body tags, we operate on the Body instance of the Html instance 
(which is an instance variable of the HtmlFile instance).

### Adding HTML elements to the &lt;Body&gt; instance
The Body class contains an instance variable declared as `List<HtmlTags> tags`. The `HtmlTag` class is an `abstract Class`
that all aforementioned classes except the `HtmlFile` class extends. Hence, in order to add content to the `Body` instance, one or more `HtmlTag` extensions are instantiated and added to the `Body` instance. In the following example we illustrate how to
extend the HtmlTag class by creating a new class `P` that models a HTML paragraph tag. An instance of the class is instantiated
with the text "Hello World!" and added to the `Body` instance. 

#### Defining the P class
The P class is defined as a class which constructor takes a `String` object as input argument and the `toString()` method
is overriden to print out the HTML of the HTML paragraph tags. This later overriding of the `toString` method is enforced by
the `abstract Class` `HtmlTag` which the `P` class extends:
``` java
class P extends HtmlTag
{
    String txt;

    public P(){};
    
    public P(String txt)
    {
        this.txt = txt;
    }
    
    @Override
    public String toString() 
    {
        return "<p>"+txt+"</p>\n";
    }    
}
```
#### Printing Hello World to the browser
The following section proceds by instantiating a `P` instance `P helloWorld` with the text "Hello World" and adding the `P` instance to the list of `HtmlTag`s in the  `Body` instance:
```java
        P helloWorld = new P("Hello world!");
        index.getHtml().getBody().getTags().add(helloWorld);
```
Including the above listing before the method call to the `createHtmlFile()` method constructs a HTML document with the following HTML:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Joe Doe">
    <meta name="description" content="Hello World is an introductory application in computer science that, in some fashion, displays Hello World! to a user">
    <title>Hello World</title>
</head>
<body>
<p>Hello world!</p>
</body>
</html>
```
Which the reader recognizes as a HTML document that prints _Hello World!_ in the browser. An complete Java class of the 
above example is submitted in the next listing. 
```java
package HelloWorld;

import com.lj.html.HtmlFile;
import com.lj.html.tags.Html;
import com.lj.html.tags.HtmlTag;

public class HelloWorld 
{
    public static void main(String[] args) 
    {        
        HtmlFile index = new HtmlFile();
        index.setFileName("index");
        
        index.getHtml().getHead().setTitle("Hello World");
        index.getHtml().getHead().setAuthorMeta("Joe Doe");
        index.getHtml().getHead().setDescriptionMeta(
                "Hello World is an introductory application in computer science "
                + "that, in some fashion, displays Hello World! to a user");
        
        P helloWorld = new P("Hello world!");
        index.getHtml().getBody().getTags().add(helloWorld);
        
        index.createHtmlFile("/home/linus/Desktop/Hello World");
    }               
}

class P extends HtmlTag
{
    String txt;

    public P(){};
    
    public P(String txt)
    {
        this.txt = txt;
    }
    
    @Override
    public String toString() 
    {
        return "<p>"+txt+"</p>\n";
    }    
}
```

## Example - A simple blog
Att skriva...
1.  Antag att vi har en databas med artiklar. Varje tupel kan skrivas som (id, titel, beskrivning, innehåll, publiseringsdatum, författare).
2.  Antag vidare att en java class som heter databas har skapats med vilken man kan hämta artiklar ur databasen.
3.  Antag vidare att database klassen förvarar sina artiklar i en List<Article> articleData instans.
4.  Antag att artikel instansen är skriven enligt java beans så att man kan skriva get...() och set...().
5.  Konstruera nu en HtmlTag extension som beskriver hur en artikel skall se ut på websidan.
