package com.akamon.agile.tdd.data;

import java.util.Enumeration;

/**
 * Class reponsible for abstracting the concept of the source code content
 * @author miguelgarcia
 */
public class SourceCode {
    
    private String[] content;    
    
    public SourceCode(String[] content) {
        this.content = content;
    }
    
    /**
     * @return the content
     */
    String[] getContent() {
        return content;
    }
    
    public Enumeration<SourceCodeLine> getLineEnumeration(){
        return new SourceCodeLineEnumeration(this);
    }    
        
}
