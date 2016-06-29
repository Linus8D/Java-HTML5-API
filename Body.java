package tags;
import java.util.ArrayList;
import java.util.List;

public class Body extends HtmlTag 
{
    private List<HtmlTag> tags;
    private List<String> scriptSources;
    
    public Body() 
    {
        tags = new ArrayList();
        scriptSources = new ArrayList();
    }
    
    @Override
    public String toString() 
    {
        String html = "<body>\n";
        
        if(!tags.isEmpty())
        {
            for(HtmlTag i : tags)
            {
                html += i;
            }
        }
        
        if(!scriptSources.isEmpty())
        {
            for(String scriptSrc : scriptSources)
            {
                html += "   <script src=\""+scriptSrc+"\"></script>\n";
            }
        }
        
        html += "</body>\n";
        
        return html;
    }
        
    public void setTags(List<HtmlTag> tags)
    {
        this.tags = tags;
    }
    
    public List<HtmlTag> getTags()
    {
        return tags;
    }
                 
    public void setScriptSources(List<String> scriptSources)
    {
        this.scriptSources = scriptSources;
    }
    
    public List<String> getScriptSources()
    {
        return scriptSources;
    }
}
