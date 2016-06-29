/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

/**
 * 
 * 
 * Todo: Add possibility to use different languages.
 * 
 * @author Linus Jarneving <your.title at your.org>
 */
public class Html extends HtmlTag
{
    private Body body;            
    private Head head;    
    private String lang;      
    
    /**
     * <code>Html</code> instance with <code>Body</code> and <code>Head</code>
     * instances instantiated with empty constructors. The language setting of
     * the  <code>Html</code> instance is set to English.
     */
    public Html()
    {
        body = new Body();
        head = new Head();
        lang = "en"; 
    };
         
    @Override
    public String toString() 
    {
        String html = "<html lang=\""+lang+"\">\n";
        html += head;
        html += body;
        html += "</html>";
        
        return html;
    }
                  
    /**
     * Returns the body instance in the Html object.
     * @return
     */
    public Body getBody()
    {
        return body;
    }
    
    /**
     * Sets the Body instance in the Html object.
     * @param body
     */
    public void setBody(Body body)
    {
        this.body = body;
    }
    
    /**
     * Returns the Head instance in the Html object.
     * @return
     */
    public Head getHead()
    {
        return head;
    }
    
    /**
     * Sets the Head instance in the Html object.
     * @param head
     */
    public void setHead(Head head)
    {
        this.head = head;
    }
         
    /**
     * Sets the language setting (e.g. en) of the Html file as specified in
     * the Html-tag e.g. &lt;html="en"&gt;. 
     * @param lang
     */    
    public void setLang(String lang)
    {
        this.lang = lang;
    }    
    
    /**
     * Returns the language setting (e.g. en) of the Html file as specified in
     * the Html-tag e.g. &lt;html="en"&gt;.  
     * @return 
     */
    public String getLang()
    {
        return lang;
    }        
}
