package tags;

/**
 * Enforces extensions to override the <code>toString()</code> method to return
 * the HTML of the extension (HTML tag).
 * @author Linus Jarneving <your.name at your.org>
 */
public abstract class HtmlTag
{
    /**
     * Returns the HTML of the HTML component. 
     * @return 
     */
    @Override
    public abstract String toString();
}
