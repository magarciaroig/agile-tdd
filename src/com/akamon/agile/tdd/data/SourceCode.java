package com.akamon.agile.tdd.data;

/**
 * Class reponsible for abstract the concept of the source code content
 * @author miguelgarcia
 */
public class SourceCode {
    
    private String[] content;
    
    public SourceCode(String[] content) {
        this.content = content;
    }
    
    public int countLines() {
        return this.content.length;
    }
}
