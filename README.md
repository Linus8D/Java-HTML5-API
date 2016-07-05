# Introduction
Websites can be thought of as either being static or dynamic. A static website is usually composed of HTML files, CSS files and JavaScripts stored on a 
web server. When an user visits a web page on a static website, the corresponding HTML
file is directly sent to the user’s web browser which renders and displays the web page to the
user. This contrasts to so–called dynamic websites in which the HTML files are not stored
on the server but are assembled on a case to case basis by a web application when the
corresponding web page receives a visitor. Hence, for dynamic websites, the HTML file that corresponds to the visited web page has to be assemblied before it is sent to the user's web broser.

While the HTML file assembly in dynamic websites allows for the HTML files to be created dynamically for a particular visitor it also increases the web page load time. Furhter more, the web application might be complicated to develop and/or increase the hosting costs of the website. Therefore, when dynamic properties are not necessary, it is desirable to implement static websites instead.  

Java-HTML5-API is a Java package for creating HTML files in a local directory that can be used to create static websites.


# Getting started
The following tutorials serves as instruction material for getting started with Java-HTML5-API.

## Tutorial 1 - A _Hello World_ application
A _Hello World_ application is an introductory application that displays the sentence _Hello World!_ to the user. In the following tutorial, the sentence _Hello World!_ will be displayed in the reader's web browser. In the process, the reader 
will learn how to

1.  create a HTML document at a directory of choosing using the Java-HTML5-API and
2.  how to extend Java-HTML5-API's `abstract class HtmlTags` in order to model HTML tags/elements such as the `<p>` tag.

### Part 1: An empty HTML document at a given directory
Java-HTML5-API's models a HTML document/file using the `HtmlFile` class. This class has a method `createHtmlFile`
that constructs a HTML file at the directory specified as input argument. The name of the HTML file is specified using the `setFileName` method. The name of the HTML file can be set excluding or including the `.html` extension:
```java
    // Create a HtmlFile instance and name the HTML document that it models Hello World!.
    HtmlFile helloWorld = new HtmlFile();
    helloWorld.setFileName("Hello World!"); // Also ok: index.setFileName("Hello World!.html");
```    
The above HtmlFile instance models a HTML document with the following HTML:
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
</head>
<body>
</body>
</html>
```
The above HTML can be created as the HTML document _Hello World!.html_ at a given directory using the HtmlFile instance 
`createHtmlFile` method:
```java
    // Create a HtmlFile instance and name the HTML document that it models Hello World!.
    HtmlFile helloWorld = new HtmlFile();
    helloWorld.setFileName("Hello World!");
    // Create a HTML document named Hello World!.html at the directory /home/JoeDoe/Desktop/Hello World
    helloWorld.createHtmlFile("/home/JoeDoe/Desktop/Hello World");
```
---

<strong>Remark:</strong> In the above example we used the directory `/home/JoeDoe/Desktop/Hello World/`. Make sure that you
use a directory that exists on your system.

---
Before proceeding to the next section, we consider the general structure of the HTML generated by the above program as it provides insight into how Java-HTML5-API is designed:
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
</head>
<body>
</body>
</html>
```
The above markup contains three major HTML elements/tags. These are the `<html></html>`, `<head></head>` and `<body></body>` tags. We also find that the `<head></head>` and `<body></body>` tags are nested within the `<html></html>` tags:
```HTML
<!DOCTYPE html>
<html lang="en">

    <head>
        .
        .
        .
    </head>
    
    <body>
        .
        .
        .
    </body>
    
</html>
```
This nested hierarchy suggests that the head and body tags can be considered as members of the html tags which in turn are members of the HTML document. This hierarchy is reflected in the design of the Java-HTML5-API as follows:

1.  `HtmlFile` has a `Html` instance member. `Html` is a class that models `<html></html>`.
2.  `Html` has a `Head` instance member and a `Body` instance member. `Head` is a class that models `<head></head>` and `Body` is a class that models  `<body></body>`

From previous listings we also find that there exists HTML tags within the head tags. These HTML tags are similarly members
of `Head` instances (albeit not necessarily explicitly declared). 

Adding HTML tags within the head tags is of concern in the next section.

### Part 2: Adding HTML tags within the `<head></head>` tags
From the HTML markup of the empty HTML document in the previous example, the reader can notice that the 
head tags of the HTML document contains a minimal, default markup. Because a HTML document would (normally) contain atleast
a `<title>` tag and links to external assets (such as CSS files) adding content inside those `<head>` tags is of great 
interest. 

Java-HTML5-API is a Java Bean which means that the (typically) prefered way of changing the state of an object are through _getters_ e.g. `getFoo()` and _setters_ e.g. `setFoo(...)`. Hence, to change the state of the HTML elements within the &lt;head&gt; tags we first get the <strong>Head</strong> instance of the HtmlFile instance and add elements to the Head instance:
```java
    helloWorld.getHead().setFoo(...);
```
In the following listing, we add a title, author and description to the Hello World document. Add this before the method
call to `createHtmlFile`:
```java
    // Add meta inside the head tags:
    helloWorld.getHtml().getHead().setTitle("Hello World");
    helloWorld.getHtml().getHead().setAuthorMeta("Joe Doe");
    helloWorld.getHtml().getHead().setDescriptionMeta(
        "Hello World! is an introductory application in computer science "
        + "that prints Hello World!");
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
    <meta name="description" content="Hello World! is an introductory application in computer science that prints Hello World!">
    <title>Hello World!</title>
</head>
<body>
</body>
</html>
```
The above markup will add the text _Hello World!_ to a browser's toolbar and displays the title _Hello World!_ for the web page
in search engines such as Google. However there still does not exist any content between the `<body></body>` tags in the above
markup. Hence, no content will actually be displayed within the browser. In order to add content to the body tags, we operate on the Body instance of the Html instance (which is an instance variable of the HtmlFile instance). This is of concern in the next section.

### Adding HTML elements to the &lt;Body&gt; instance
The Body class contains an instance variable declared as `List<HtmlTags> tags`. The `HtmlTag` class is an `abstract Class`
that all aforementioned classes except the `HtmlFile` class extends. Hence, in order to add content to the `Body` instance, one or more `HtmlTag` extensions are instantiated and added to the `Body` instance. In the following example we illustrate how to
extend the HtmlTag class by creating a new class `P` that models a HTML paragraph tag. An instance of the class is instantiated
with the text "Hello World!" and added to the `Body` instance. 

#### Defining the P class
The P class is defined as a class which constructor takes a `String` object as input argument and the `toString()` method
is overriden to print out the HTML of the HTML paragraph tags. This later overriding of the `toString` method is enforced by
the `abstract Class` `HtmlTag` (which the `P` class extends):
``` java
class P extends HtmlTag
{
    String txt;

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
---

<strong>Remark:</strong> The above example is a simple implementation for illustrative purposes. 

---
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
