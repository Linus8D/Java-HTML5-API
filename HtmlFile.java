/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import tags.Html;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Linus Jarneving <your.name at your.org>
 */
public class HtmlFile 
{
    private Html html;    
    private String fileName;
    private String dir;
    
    public HtmlFile()
    {
        html = new Html();
        fileName = "";
    }
                        
    public void createHtmlFile(String directory)
    {
        if(!directory.endsWith("/"))
        {
            directory += "/";
        }        
        if(!fileName.endsWith(".html"))
        {
            fileName += ".html";
        }                
        File file = new File(directory+fileName);
        FileWriter fileWriter = null;
        try 
        {
            fileWriter = new FileWriter(file);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(HtmlFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) 
        {
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.print("<!DOCTYPE html>\n"+html);
        }   
        catch (IOException ex) 
        {
            Logger.getLogger(HtmlFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public String getDir()
    {
        return dir;
    }
    
    public void setDir(String dir)
    {
        this.dir = dir;
    }
        
    public String getFileName()
    {
        return fileName;
    }            
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public Html getHtml()
    {
        return html;
    }
    
    public void setHtml(Html html)
    {
        this.html = html;
    }    
}
