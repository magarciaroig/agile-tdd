package com.akamon.agile.tdd.sourcecode;

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
       final String sourceCode = "int c;";      
       SourceCodeProcessor processor = new SourceCodeProcessor();
       final int expected = 1;       
       
       assertEquals("There was one line of code", expected, processor.countNonCommentedAndNonBlankLines(sourceCode));
    }
    
    @Test
    public void notCountBlankLines() {
        final String sourceCode = "int c;\n";        
        SourceCodeProcessor processor = new SourceCodeProcessor();
        final int expected = 1; 
        
        assertEquals("Blank lines MUSN'T be counted", expected, processor.countNonCommentedAndNonBlankLines(sourceCode));
    }
    
    @Test
    public void notCountSimpleCommentedLines() {
        final String sourceCode = "// Var definition\nint c;";        
        SourceCodeProcessor processor = new SourceCodeProcessor();
        final int expected = 1; 
        
        assertEquals("Simple commented lines MUSN'T be counted", expected, processor.countNonCommentedAndNonBlankLines(sourceCode));
    }
        
    @Test
    public void notCountBlockCommentedLines() {
        
        StringBuilder sourceCodeContentMultiLineBlockComment = new StringBuilder();
        sourceCodeContentMultiLineBlockComment
                .append("/** Var definition\n")
                .append("* Please place the variables in this section\n")
                .append("**/\n")
                .append("int c;\n");
        
        StringBuilder sourceCodeContentOneLineBlockComment = new StringBuilder();
        sourceCodeContentOneLineBlockComment
                .append("/** Var definition */")
                .append("int c;");
        
        final String multiLineBlockCommentTestWarning = "Block commented lines MUSN'T be counted";
        final String oneLineBlockCommentTestWarning = "One line Block commented lines MUSN'T be counted";
                
        final int lineCountExpected = 1; 
        
        checkSourceCodeBlockComentCount(sourceCodeContentMultiLineBlockComment.toString(), 
                lineCountExpected, 
                multiLineBlockCommentTestWarning);
        
        checkSourceCodeBlockComentCount(sourceCodeContentOneLineBlockComment.toString(), 
                lineCountExpected, 
                oneLineBlockCommentTestWarning);                
    }
    
    @Test
    public void countLinesWithCodeBeforeOfAfterComments(){
        StringBuilder sourceCodeWithCodeBeforeOfAfterComments = new StringBuilder();
        sourceCodeWithCodeBeforeOfAfterComments
                .append("/** Var definition\n")
                .append("* Please place the variables in this section\n")
                .append("**/ int c;\n")
                .append("c = 1;");
        
        final int lineCountExpected = 2; 
        final String codeWithCodeBeforeOfAfterCommentsWarning = 
                "Lines with code before of after comments MUST be counted";
        
        checkSourceCodeBlockComentCount(sourceCodeWithCodeBeforeOfAfterComments.toString(), 
                lineCountExpected, 
                codeWithCodeBeforeOfAfterCommentsWarning);     
    }
    
    private void checkSourceCodeBlockComentCount(String sourceCodeContent, int expectedCount, String warningMsg) {        
        SourceCodeProcessor processor = new SourceCodeProcessor();
        
        assertEquals(warningMsg, expectedCount, processor.countNonCommentedAndNonBlankLines(sourceCodeContent));
    }    
}
