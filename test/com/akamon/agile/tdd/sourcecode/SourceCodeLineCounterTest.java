package com.akamon.agile.tdd.sourcecode;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miguelgarcia
 */
public class SourceCodeLineCounterTest {
            
    @Test
    public void countAllLines() {
       String[] sourceCode = {"int c;"};
       
       
       assertEquals("There was one line of code", 1, SourceCodeProcessor.countLines(sourceCode));
    }
    
}
