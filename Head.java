/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.util.ArrayList;
import java.util.List;

/**
 * Models the HTML head tag of a HTML document. 
 * @author Linus Jarneving <your.name at your.org>
 */
public class Head extends HtmlTag
{
    private List<String> scriptSources;
    private List<String> cssSources;
    private List<String> meta;
    private String title;
    
    public Head()
    {
        meta = new ArrayList<>();
        meta.add("    <meta charset=\"utf-8\">\n");
        meta.add("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        meta.add("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");                     
        cssSources = new ArrayList();
        scriptSources = new ArrayList();
    };
                                        
    /**
     * Add description meta tag in the head.
     * @param description
     */
    public void setDescriptionMeta(String description)
    {                 
        meta.add("    <meta name=\"description\" content=\""+description+"\">\n");
    }
    
    /**
     * Add author meta tag in the head.
     * @param author 
     */
    public void setAuthorMeta(String author)
    {                 
        meta.add("    <meta name=\"author\" content=\""+author+"\">\n");
    }
    
    /**
     *
     * @return
     */
    public List<String> getMeta()
    {
        return meta;
    }
    
    /**
     *
     * @param meta
     */
    public void setMeta(List<String> meta)
    {
        this.meta = meta;
    }
     
    @Override
    public String toString()
    {
        String html = "<head>\n";
        
        for(String i : meta)
        {
            html += i;
        }
                
        html += "    <title>"+title+"</title>\n";
        
        if(!cssSources.isEmpty())
        {
            for(String i : cssSources)
            {
                html += "    <link href=\""+i+"\" rel=\"stylesheet\">\n";
            }           
        }
        
        if(!scriptSources.isEmpty())
        {
            for(String scriptSrc : scriptSources)
            {
                html += "   <script src=\""+scriptSrc+"\"></script>\n";
            }
        }
        
        html += "</head>\n";
            
        return html;
    }
    
    /**
     * Set the title within the &lt;title&gt; tags in the Head object.
     * @param title 
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Returns the title within the &lt;title&gt; tags in the Head object. 
     * @return 
     */
    public String getTitle()
    {
        return title;
    }
              
    /**
     * <p>Sets the CSS link in the Head object.<p><p><strong>Remark:</strong>
     *  It is recommended to use the 
     * addCss function instead since this function allows for specifying the
     * address to the CSS file only.</p>
     * @param cssSources 
     */
    public void setCssSources(List<String> cssSources)
    {
        this.cssSources = cssSources;
    }
    
    /**
     * Returns the list of CSS links in the Head object.
     * @return 
     */
    public List<String> getCssSources()
    {
        return cssSources;
    }
    
    /**
     * Return the list of script tags in the head. 
     * @return 
     */    
    public List<String> getScriptSources()
    {
        return scriptSources;
    }
    
    /**
     * <p>Sets the list of scripts e.g. JavaScripts in the Head object.<p>
     * <p><strong>Remark:</strong> It is recommended to use the addAsScriptTag 
     * function instead since this function allows for specifying the address to
     * the scripts only instead of specifying the entire script tag.</p>
     * @param scriptSources
     */
    public void setScriptSources(List<String> scriptSources)
    {
        this.scriptSources = scriptSources;
    }
}

        