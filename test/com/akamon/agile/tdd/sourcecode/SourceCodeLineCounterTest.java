package com.akamon.agile.tdd.sourcecode;

import com.akamon.agile.tdd.data.ISourceCodeProvider;
import com.akamon.agile.tdd.data.MemorySourceCodeProvider;
import com.akamon.agile.tdd.service.SourceCodeProcessor;
import com.akamon.agile.tdd.service.SourceCodeStats;
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
       final int expected = 1;     
       final String warningMsg = "There was one line of code";
       final ISourceCodeProvider sourceCodeProvider = new MemorySourceCodeProvider(sourceCode);
       
       checkRightTextLineCount(sourceCodeProvider, expected, warningMsg);       
    }
    
    @Test
    public void notCountBlankLines() {
        final String sourceCode = "int c;\n";               
        final int expected = 1; 
        final String warningMsg = "Blank lines MUSN'T be counted";
        final ISourceCodeProvider sourceCodeProvider = new MemorySourceCodeProvider(sourceCode);
        
        checkRightTextLineCount(sourceCodeProvider, expected, warningMsg);
    }
    
    @Test
    public void notCountSimpleCommentedLines() {
        final String sourceCode = "// Var definition\nint c;";                
        final int expected = 1; 
        final String warningMsg = "Simple commented lines MUSN'T be counted";
        final ISourceCodeProvider sourceCodeProvider = new MemorySourceCodeProvider(sourceCode);
        
        checkRightTextLineCount(sourceCodeProvider, expected, warningMsg);
    }
        
    @Test
    public void notCountBlockCommentedLines() {
        
        StringBuilder sourceCodeContentMultiLineBlockComment = new StringBuilder();
        sourceCodeContentMultiLineBlockComment
                .append("/** Var definition\n")
                .append("* Please place the variables in this section\n")
                .append("**/\n")
                .append("  \n")
                .append("int c;\n");
        
        StringBuilder sourceCodeContentOneLineBlockComment = new StringBuilder();
        sourceCodeContentOneLineBlockComment
                .append("/** Var definition */")
                .append("int c;");
        
        final String multiLineBlockCommentTestWarning = "Block commented lines MUSN'T be counted";
        final String oneLineBlockCommentTestWarning = "One line Block commented lines MUSN'T be counted";
        
        final ISourceCodeProvider sourceCodeProviderMultiLineBlockComment = 
                new MemorySourceCodeProvider(sourceCodeContentMultiLineBlockComment.toString());
        
         final ISourceCodeProvider sourceCodeProviderOneLineBlockComment = 
                new MemorySourceCodeProvider(sourceCodeContentOneLineBlockComment.toString());
                
        final int lineCountExpected = 1; 
        
        checkRightTextLineCount(sourceCodeProviderMultiLineBlockComment, 
                lineCountExpected, 
                multiLineBlockCommentTestWarning);
        
        checkRightTextLineCount(sourceCodeProviderOneLineBlockComment, 
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
                .append(" // Single line comment \n")
                .append("c = 1;");
        
        final int lineCountExpected = 2; 
        final String codeWithCodeBeforeOfAfterCommentsWarning = 
                "Lines with code before of after comments MUST be counted";        
        final ISourceCodeProvider sourceCodeProvider = 
                new MemorySourceCodeProvider(sourceCodeWithCodeBeforeOfAfterComments.toString());
        
        checkRightTextLineCount(sourceCodeProvider, 
                lineCountExpected, 
                codeWithCodeBeforeOfAfterCommentsWarning);     
    }
    
    private void checkRightTextLineCount(ISourceCodeProvider sourceCodeProvider, int expectedCount, String warningMsg) {
        final SourceCodeStats sourceStats = SourceCodeProcessor.analyze(sourceCodeProvider);
        final int nonCommentedAndNonBlankLines = sourceStats.getNonCommentedAndNonBlankLines();
        
        assertEquals(warningMsg, expectedCount, nonCommentedAndNonBlankLines);
    }    
}
