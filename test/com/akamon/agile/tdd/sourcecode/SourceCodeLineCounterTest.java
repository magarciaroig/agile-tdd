package com.akamon.agile.tdd.sourcecode;


import com.akamon.agile.tdd.data.SourceCode;
import com.akamon.agile.tdd.service.SourceCodeProcessor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miguelgarcia
 */
public class SourceCodeLineCounterTest {
            
    @Test
    public void countAllLines() {
       String[] sourceCodeContent = {"int c;"};
       SourceCode sourceCode = new SourceCode(sourceCodeContent);
       int expected = 1;       
       
       assertEquals("There was one line of code", expected, SourceCodeProcessor.countNonCommentedLines(sourceCode));
    }
    
    @Test
    public void notCountBlankLines() {
        String[] sourceCodeContent = {"int c;", ""};
        SourceCode sourceCode = new SourceCode(sourceCodeContent);
        int expected = 1; 
        
        assertEquals("Blank lines MUSN'T be counted", expected, SourceCodeProcessor.countNonCommentedLines(sourceCode));
    }
    
    @Test
    public void notCountDoubleBarCommentedLines() {
        String[] sourceCodeContent = {"// Var definition", "int c;"};
        SourceCode sourceCode = new SourceCode(sourceCodeContent);
        int expected = 1; 
        
        assertEquals("Double bar commented lines MUSN'T be counted", expected, SourceCodeProcessor.countNonCommentedLines(sourceCode));
    }
    
}
