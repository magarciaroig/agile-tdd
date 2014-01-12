package com.akamon.agile.tdd.data;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * Class responible for implementing an enumeration over a SourceCode object
 * @author miguelgarcia
 */
class SourceCodeLineEnumeration implements Enumeration<SourceCodeLine> {
    
    private SourceCode sourceCode;
    private String[] sourceCodeContent;    
    private int currentPosition = -1;
    
    SourceCodeLineEnumeration(SourceCode sourceCode) {
        this.sourceCode = sourceCode;
        this.sourceCodeContent = sourceCode.getContent();
    }
    
    @Override
    public boolean hasMoreElements() {        
        return ( nextPosition() < sourceCodeContent.length );
    }

    @Override
    public SourceCodeLine nextElement() {
        if ( !hasMoreElements() ) {
            throw new NoSuchElementException();
        }
        
        int position = nextPosition();
        int lineNumber = currentLineNumber();
        
        String nextLineContent = sourceCodeContent[position];        
        updatePosition();
        
        return new SourceCodeLine(nextLineContent, lineNumber, this.sourceCode);
    }
    
    private int nextPosition() {
        return currentPosition + 1;
    }
    
    private int currentLineNumber() {
        return nextPosition() + 1;
    }
       
    
    private void updatePosition(){
        currentPosition++;
    }
}
